package geotrellis.spark.io.cassandra

import geotrellis.spark.io.avro._
import geotrellis.spark.io.avro.codecs._

import com.datastax.driver.core.schemabuilder.SchemaBuilder
import com.datastax.driver.core.querybuilder.QueryBuilder
import org.apache.spark.rdd.RDD
import com.datastax.driver.core.DataType._
import org.apache.cassandra.hadoop.cql3._
import org.apache.cassandra.utils.ByteBufferUtil
import org.apache.hadoop.mapreduce.Job

import java.nio.ByteBuffer

object CassandraRDDWriter {

  def write[K: AvroRecordCodec, V: AvroRecordCodec](
    raster: RDD[(K, V)],
    instance: CassandraInstance,
    decomposeKey: K => (Long, String, Int),
    table: String
  ): Unit = {
    implicit val sc = raster.sparkContext

    val codec   = KeyValueRecordCodec[K, V]
    val schema  = codec.schema
    val session = instance.session

    {
      val schema = SchemaBuilder.createTable(instance.keySpace, table).ifNotExists()
        .addPartitionKey("key", bigint)
        .addClusteringColumn("name", text)
        .addClusteringColumn("zoom", cint)
        .addColumn("value", blob)

      session.execute(schema)
    }

    val job = Job.getInstance(sc.hadoopConfiguration)
    instance.setCassandraConfig(job)
    instance.setOutputColumnFamily(job, table)
    job.setOutputFormatClass(classOf[CqlBulkOutputFormat])
    CqlConfigHelper.setOutputCql(job.getConfiguration, s"UPDATE ${instance.keySpace}.${table} SET value=?")

    QueryBuilder.update(instance.keySpace, table)
    val kvPairs =
      raster
        .groupBy({ row => decomposeKey(row._1) }, numPartitions = raster.partitions.length)
        .map { case ((key, name, zoom), pairs) =>
          val outKey = Map(
            "key"  -> ByteBufferUtil.bytes(key),
            "name" -> ByteBufferUtil.bytes(name),
            "zoom" -> ByteBufferUtil.bytes(zoom)
          )

          val outVal = AvroEncoder.toBinary(pairs.toVector)(codec) :: Nil
          (outKey, outVal)
        }

    kvPairs.saveAsNewAPIHadoopFile(
      instance.keySpace,
      classOf[Map[String, ByteBuffer]],
      classOf[List[ByteBuffer]],
      classOf[CqlBulkOutputFormat],
      sc.hadoopConfiguration
    )
  }
}
