// Generated by ScalaBuff, the Scala Protocol Buffers compiler. DO NOT EDIT!
// source: vector_tile.proto

package vector_tile

final case class Tile (
	layers: scala.collection.immutable.Seq[Tile.Layer] = Vector.empty[Tile.Layer]
) extends com.google.protobuf.GeneratedMessageLite.ExtendableMessage[Tile]
	with net.sandrogrzicic.scalabuff.ExtendableMessage[Tile]
	with net.sandrogrzicic.scalabuff.Parser[Tile] {

	def setLayers(_i: Int, _v: Tile.Layer) = copy(layers = layers.updated(_i, _v))
	def addLayers(_f: Tile.Layer) = copy(layers = layers :+ _f)
	def addAllLayers(_f: Tile.Layer*) = copy(layers = layers ++ _f)
	def addAllLayers(_f: TraversableOnce[Tile.Layer]) = copy(layers = layers ++ _f)

	def clearLayers = copy(layers = Vector.empty[Tile.Layer])

	def writeTo(output: com.google.protobuf.CodedOutputStream) {
		var index_layers = 0
		while (index_layers < layers.length) {
			output.writeMessage(3, layers(index_layers))
			index_layers += 1
		}
	}

	def getSerializedSize = {
		import com.google.protobuf.CodedOutputStream._
		var __size = 0
		var index_layers = 0
		while (index_layers < layers.length) {
			__size += computeMessageSize(3, layers(index_layers))
			index_layers += 1
		}

		__size
	}

	def mergeFrom(in: com.google.protobuf.CodedInputStream, extensionRegistry: com.google.protobuf.ExtensionRegistryLite): Tile = {
		import com.google.protobuf.ExtensionRegistryLite.{getEmptyRegistry => _emptyRegistry}
		val __layers: scala.collection.mutable.Buffer[Tile.Layer] = layers.toBuffer

		def __newMerged = Tile(
			Vector(__layers: _*)
		)
		while (true) in.readTag match {
			case 0 => return __newMerged
			case 26 => __layers += readMessage[Tile.Layer](in, Tile.Layer.defaultInstance, _emptyRegistry)
			case default => if (!in.skipField(default)) return __newMerged
		}
		null
	}

	def mergeFrom(m: Tile) = {
		Tile(
			layers ++ m.layers
		)
	}

	def getDefaultInstanceForType = Tile.defaultInstance
	def clear = getDefaultInstanceForType
	def isInitialized = true
	def build = this
	def buildPartial = this
	def parsePartialFrom(cis: com.google.protobuf.CodedInputStream, er: com.google.protobuf.ExtensionRegistryLite) = mergeFrom(cis, er)
	override def getParserForType = this
	def newBuilderForType = throw new RuntimeException("Method not available.")
	def toBuilder = throw new RuntimeException("Method not available.")
	def toJson(indent: Int = 0): String = "ScalaBuff JSON generation not enabled. Use --generate_json_method to enable."
}

object Tile {
	@scala.beans.BeanProperty val defaultInstance = new Tile()

	def parseFrom(data: Array[Byte]): Tile = defaultInstance.mergeFrom(data)
	def parseFrom(data: Array[Byte], offset: Int, length: Int): Tile = defaultInstance.mergeFrom(data, offset, length)
	def parseFrom(byteString: com.google.protobuf.ByteString): Tile = defaultInstance.mergeFrom(byteString)
	def parseFrom(stream: java.io.InputStream): Tile = defaultInstance.mergeFrom(stream)
	def parseDelimitedFrom(stream: java.io.InputStream): Option[Tile] = defaultInstance.mergeDelimitedFromStream(stream)

	val LAYERS_FIELD_NUMBER = 3

	def newBuilder = defaultInstance.newBuilderForType
	def newBuilder(prototype: Tile) = defaultInstance.mergeFrom(prototype)

	object GeomType extends net.sandrogrzicic.scalabuff.Enum {
		sealed trait EnumVal extends Value
		val _UNINITIALIZED = new EnumVal { val name = "UNINITIALIZED ENUM VALUE"; val id = -1 }

		val UNKNOWN = new EnumVal { val name = "UNKNOWN"; val id = 0 }
		val POINT = new EnumVal { val name = "POINT"; val id = 1 }
		val LINESTRING = new EnumVal { val name = "LINESTRING"; val id = 2 }
		val POLYGON = new EnumVal { val name = "POLYGON"; val id = 3 }

		val UNKNOWN_VALUE = 0
		val POINT_VALUE = 1
		val LINESTRING_VALUE = 2
		val POLYGON_VALUE = 3

		def valueOf(id: Int) = id match {
			case 0 => UNKNOWN
			case 1 => POINT
			case 2 => LINESTRING
			case 3 => POLYGON
			case _default => throw new net.sandrogrzicic.scalabuff.UnknownEnumException(_default)
		}
		val internalGetValueMap = new com.google.protobuf.Internal.EnumLiteMap[EnumVal] {
			def findValueByNumber(id: Int): EnumVal = valueOf(id)
		}
	}

	final case class Value (
		stringValue: Option[String] = None,
		floatValue: Option[Float] = None,
		doubleValue: Option[Double] = None,
		intValue: Option[Long] = None,
		uintValue: Option[Long] = None,
		sintValue: Option[Long] = None,
		boolValue: Option[Boolean] = None
	) extends com.google.protobuf.GeneratedMessageLite.ExtendableMessage[Value]
		with net.sandrogrzicic.scalabuff.ExtendableMessage[Value]
		with net.sandrogrzicic.scalabuff.Parser[Value] {

		def setStringValue(_f: String) = copy(stringValue = Some(_f))
		def setFloatValue(_f: Float) = copy(floatValue = Some(_f))
		def setDoubleValue(_f: Double) = copy(doubleValue = Some(_f))
		def setIntValue(_f: Long) = copy(intValue = Some(_f))
		def setUintValue(_f: Long) = copy(uintValue = Some(_f))
		def setSintValue(_f: Long) = copy(sintValue = Some(_f))
		def setBoolValue(_f: Boolean) = copy(boolValue = Some(_f))

		def clearStringValue = copy(stringValue = None)
		def clearFloatValue = copy(floatValue = None)
		def clearDoubleValue = copy(doubleValue = None)
		def clearIntValue = copy(intValue = None)
		def clearUintValue = copy(uintValue = None)
		def clearSintValue = copy(sintValue = None)
		def clearBoolValue = copy(boolValue = None)

		def writeTo(output: com.google.protobuf.CodedOutputStream) {
			if (stringValue.isDefined) output.writeString(1, stringValue.get)
			if (floatValue.isDefined) output.writeFloat(2, floatValue.get)
			if (doubleValue.isDefined) output.writeDouble(3, doubleValue.get)
			if (intValue.isDefined) output.writeInt64(4, intValue.get)
			if (uintValue.isDefined) output.writeUInt64(5, uintValue.get)
			if (sintValue.isDefined) output.writeSInt64(6, sintValue.get)
			if (boolValue.isDefined) output.writeBool(7, boolValue.get)
		}

		def getSerializedSize = {
			import com.google.protobuf.CodedOutputStream._
			var __size = 0
			if (stringValue.isDefined) __size += computeStringSize(1, stringValue.get)
			if (floatValue.isDefined) __size += computeFloatSize(2, floatValue.get)
			if (doubleValue.isDefined) __size += computeDoubleSize(3, doubleValue.get)
			if (intValue.isDefined) __size += computeInt64Size(4, intValue.get)
			if (uintValue.isDefined) __size += computeUInt64Size(5, uintValue.get)
			if (sintValue.isDefined) __size += computeSInt64Size(6, sintValue.get)
			if (boolValue.isDefined) __size += computeBoolSize(7, boolValue.get)

			__size
		}

		def mergeFrom(in: com.google.protobuf.CodedInputStream, extensionRegistry: com.google.protobuf.ExtensionRegistryLite): Value = {
			import com.google.protobuf.ExtensionRegistryLite.{getEmptyRegistry => _emptyRegistry}
			var __stringValue: Option[String] = stringValue
			var __floatValue: Option[Float] = floatValue
			var __doubleValue: Option[Double] = doubleValue
			var __intValue: Option[Long] = intValue
			var __uintValue: Option[Long] = uintValue
			var __sintValue: Option[Long] = sintValue
			var __boolValue: Option[Boolean] = boolValue

			def __newMerged = Value(
				__stringValue,
				__floatValue,
				__doubleValue,
				__intValue,
				__uintValue,
				__sintValue,
				__boolValue
			)
			while (true) in.readTag match {
				case 0 => return __newMerged
				case 10 => __stringValue = Some(in.readString())
				case 21 => __floatValue = Some(in.readFloat())
				case 25 => __doubleValue = Some(in.readDouble())
				case 32 => __intValue = Some(in.readInt64())
				case 40 => __uintValue = Some(in.readUInt64())
				case 48 => __sintValue = Some(in.readSInt64())
				case 56 => __boolValue = Some(in.readBool())
				case default => if (!in.skipField(default)) return __newMerged
			}
			null
		}

		def mergeFrom(m: Value) = {
			Value(
				m.stringValue.orElse(stringValue),
				m.floatValue.orElse(floatValue),
				m.doubleValue.orElse(doubleValue),
				m.intValue.orElse(intValue),
				m.uintValue.orElse(uintValue),
				m.sintValue.orElse(sintValue),
				m.boolValue.orElse(boolValue)
			)
		}

		def getDefaultInstanceForType = Value.defaultInstance
		def clear = getDefaultInstanceForType
		def isInitialized = true
		def build = this
		def buildPartial = this
		def parsePartialFrom(cis: com.google.protobuf.CodedInputStream, er: com.google.protobuf.ExtensionRegistryLite) = mergeFrom(cis, er)
		override def getParserForType = this
		def newBuilderForType = throw new RuntimeException("Method not available.")
		def toBuilder = throw new RuntimeException("Method not available.")
		def toJson(indent: Int = 0): String = "ScalaBuff JSON generation not enabled. Use --generate_json_method to enable."
	}

	object Value {
		@scala.beans.BeanProperty val defaultInstance = new Value()

		def parseFrom(data: Array[Byte]): Value = defaultInstance.mergeFrom(data)
		def parseFrom(data: Array[Byte], offset: Int, length: Int): Value = defaultInstance.mergeFrom(data, offset, length)
		def parseFrom(byteString: com.google.protobuf.ByteString): Value = defaultInstance.mergeFrom(byteString)
		def parseFrom(stream: java.io.InputStream): Value = defaultInstance.mergeFrom(stream)
		def parseDelimitedFrom(stream: java.io.InputStream): Option[Value] = defaultInstance.mergeDelimitedFromStream(stream)

		val STRING_VALUE_FIELD_NUMBER = 1
		val FLOAT_VALUE_FIELD_NUMBER = 2
		val DOUBLE_VALUE_FIELD_NUMBER = 3
		val INT_VALUE_FIELD_NUMBER = 4
		val UINT_VALUE_FIELD_NUMBER = 5
		val SINT_VALUE_FIELD_NUMBER = 6
		val BOOL_VALUE_FIELD_NUMBER = 7

		def newBuilder = defaultInstance.newBuilderForType
		def newBuilder(prototype: Value) = defaultInstance.mergeFrom(prototype)

	}
	final case class Feature (
		id: Option[Long] = Some(0),
		tags: scala.collection.immutable.Seq[Int] = Vector.empty[Int],
		`type`: Option[GeomType.EnumVal] = Some(GeomType.UNKNOWN),
		geometry: scala.collection.immutable.Seq[Int] = Vector.empty[Int]
	) extends com.google.protobuf.GeneratedMessageLite
		with com.google.protobuf.MessageLite.Builder
		with net.sandrogrzicic.scalabuff.Message[Feature]
		with net.sandrogrzicic.scalabuff.Parser[Feature] {

		def setId(_f: Long) = copy(id = Some(_f))
		def setTags(_i: Int, _v: Int) = copy(tags = tags.updated(_i, _v))
		def addTags(_f: Int) = copy(tags = tags :+ _f)
		def addAllTags(_f: Int*) = copy(tags = tags ++ _f)
		def addAllTags(_f: TraversableOnce[Int]) = copy(tags = tags ++ _f)
		def setType(_f: GeomType.EnumVal) = copy(`type` = Some(_f))
		def setGeometry(_i: Int, _v: Int) = copy(geometry = geometry.updated(_i, _v))
		def addGeometry(_f: Int) = copy(geometry = geometry :+ _f)
		def addAllGeometry(_f: Int*) = copy(geometry = geometry ++ _f)
		def addAllGeometry(_f: TraversableOnce[Int]) = copy(geometry = geometry ++ _f)

		def clearId = copy(id = None)
		def clearTags = copy(tags = Vector.empty[Int])
		def clearType = copy(`type` = None)
		def clearGeometry = copy(geometry = Vector.empty[Int])

		def writeTo(output: com.google.protobuf.CodedOutputStream) {
			if (id.isDefined) output.writeUInt64(1, id.get)
			// write field tags packed 
			if (!tags.isEmpty) {
				import com.google.protobuf.CodedOutputStream._
				val dataSize = tags.map(computeUInt32SizeNoTag(_)).sum 
				output.writeRawVarint32(18)
				output.writeRawVarint32(dataSize)
				var index_tags = 0
				while (index_tags < tags.length) {
					output.writeUInt32NoTag(tags(index_tags))
					index_tags += 1
				}
			}
			if (`type`.isDefined) output.writeEnum(3, `type`.get)
			// write field geometry packed 
			if (!geometry.isEmpty) {
				import com.google.protobuf.CodedOutputStream._
				val dataSize = geometry.map(computeUInt32SizeNoTag(_)).sum 
				output.writeRawVarint32(34)
				output.writeRawVarint32(dataSize)
				var index_geometry = 0
				while (index_geometry < geometry.length) {
					output.writeUInt32NoTag(geometry(index_geometry))
					index_geometry += 1
				}
			}
		}

		def getSerializedSize = {
			import com.google.protobuf.CodedOutputStream._
			var __size = 0
			if (id.isDefined) __size += computeUInt64Size(1, id.get)
			if (!tags.isEmpty) {
				val dataSize = tags.map(computeUInt32SizeNoTag(_)).sum 
				__size += 1 + computeInt32SizeNoTag(dataSize) + dataSize
			}
			if (`type`.isDefined) __size += computeEnumSize(3, `type`.get)
			if (!geometry.isEmpty) {
				val dataSize = geometry.map(computeUInt32SizeNoTag(_)).sum 
				__size += 1 + computeInt32SizeNoTag(dataSize) + dataSize
			}

			__size
		}

		def mergeFrom(in: com.google.protobuf.CodedInputStream, extensionRegistry: com.google.protobuf.ExtensionRegistryLite): Feature = {
			import com.google.protobuf.ExtensionRegistryLite.{getEmptyRegistry => _emptyRegistry}
			var __id: Option[Long] = id
			val __tags: scala.collection.mutable.Buffer[Int] = tags.toBuffer
			var __type: Option[GeomType.EnumVal] = `type`
			val __geometry: scala.collection.mutable.Buffer[Int] = geometry.toBuffer

			def __newMerged = Feature(
				__id,
				Vector(__tags: _*),
				__type,
				Vector(__geometry: _*)
			)
			while (true) in.readTag match {
				case 0 => return __newMerged
				case 8 => __id = Some(in.readUInt64())
				case 16 => __tags += in.readUInt32()
				case 18 => 
					val length = in.readRawVarint32()
					val limit = in.pushLimit(length)
					while (in.getBytesUntilLimit() > 0) {
							__tags += in.readUInt32()
					}
					in.popLimit(limit)
				case 24 => __type = Some(try { GeomType.valueOf(in.readEnum()) } catch { case e: Exception => Some(GeomType.UNKNOWN).get })
				case 32 => __geometry += in.readUInt32()
				case 34 => 
					val length = in.readRawVarint32()
					val limit = in.pushLimit(length)
					while (in.getBytesUntilLimit() > 0) {
							__geometry += in.readUInt32()
					}
					in.popLimit(limit)
				case default => if (!in.skipField(default)) return __newMerged
			}
			null
		}

		def mergeFrom(m: Feature) = {
			Feature(
				m.id.orElse(id),
				tags ++ m.tags,
				m.`type`.orElse(`type`),
				geometry ++ m.geometry
			)
		}

		def getDefaultInstanceForType = Feature.defaultInstance
		def clear = getDefaultInstanceForType
		def isInitialized = true
		def build = this
		def buildPartial = this
		def parsePartialFrom(cis: com.google.protobuf.CodedInputStream, er: com.google.protobuf.ExtensionRegistryLite) = mergeFrom(cis, er)
		override def getParserForType = this
		def newBuilderForType = getDefaultInstanceForType
		def toBuilder = this
		def toJson(indent: Int = 0): String = "ScalaBuff JSON generation not enabled. Use --generate_json_method to enable."
	}

	object Feature {
		@scala.beans.BeanProperty val defaultInstance = new Feature()

		def parseFrom(data: Array[Byte]): Feature = defaultInstance.mergeFrom(data)
		def parseFrom(data: Array[Byte], offset: Int, length: Int): Feature = defaultInstance.mergeFrom(data, offset, length)
		def parseFrom(byteString: com.google.protobuf.ByteString): Feature = defaultInstance.mergeFrom(byteString)
		def parseFrom(stream: java.io.InputStream): Feature = defaultInstance.mergeFrom(stream)
		def parseDelimitedFrom(stream: java.io.InputStream): Option[Feature] = defaultInstance.mergeDelimitedFromStream(stream)

		val ID_FIELD_NUMBER = 1
		val TAGS_FIELD_NUMBER = 2
		val TYPE_FIELD_NUMBER = 3
		val GEOMETRY_FIELD_NUMBER = 4

		def newBuilder = defaultInstance.newBuilderForType
		def newBuilder(prototype: Feature) = defaultInstance.mergeFrom(prototype)

	}
	final case class Layer (
		version: Int = 0,
		name: String = "",
		features: scala.collection.immutable.Seq[Feature] = Vector.empty[Feature],
		keys: scala.collection.immutable.Seq[String] = Vector.empty[String],
		values: scala.collection.immutable.Seq[Value] = Vector.empty[Value],
		extent: Option[Int] = Some(4096)
	) extends com.google.protobuf.GeneratedMessageLite.ExtendableMessage[Layer]
		with net.sandrogrzicic.scalabuff.ExtendableMessage[Layer]
		with net.sandrogrzicic.scalabuff.Parser[Layer] {

		def setFeatures(_i: Int, _v: Feature) = copy(features = features.updated(_i, _v))
		def addFeatures(_f: Feature) = copy(features = features :+ _f)
		def addAllFeatures(_f: Feature*) = copy(features = features ++ _f)
		def addAllFeatures(_f: TraversableOnce[Feature]) = copy(features = features ++ _f)
		def setKeys(_i: Int, _v: String) = copy(keys = keys.updated(_i, _v))
		def addKeys(_f: String) = copy(keys = keys :+ _f)
		def addAllKeys(_f: String*) = copy(keys = keys ++ _f)
		def addAllKeys(_f: TraversableOnce[String]) = copy(keys = keys ++ _f)
		def setValues(_i: Int, _v: Value) = copy(values = values.updated(_i, _v))
		def addValues(_f: Value) = copy(values = values :+ _f)
		def addAllValues(_f: Value*) = copy(values = values ++ _f)
		def addAllValues(_f: TraversableOnce[Value]) = copy(values = values ++ _f)
		def setExtent(_f: Int) = copy(extent = Some(_f))

		def clearFeatures = copy(features = Vector.empty[Feature])
		def clearKeys = copy(keys = Vector.empty[String])
		def clearValues = copy(values = Vector.empty[Value])
		def clearExtent = copy(extent = None)

		def writeTo(output: com.google.protobuf.CodedOutputStream) {
			output.writeUInt32(15, version)
			output.writeString(1, name)
			var index_features = 0
			while (index_features < features.length) {
				output.writeMessage(2, features(index_features))
				index_features += 1
			}
			var index_keys = 0
			while (index_keys < keys.length) {
				output.writeString(3, keys(index_keys))
				index_keys += 1
			}
			var index_values = 0
			while (index_values < values.length) {
				output.writeMessage(4, values(index_values))
				index_values += 1
			}
			if (extent.isDefined) output.writeUInt32(5, extent.get)
		}

		def getSerializedSize = {
			import com.google.protobuf.CodedOutputStream._
			var __size = 0
			__size += computeUInt32Size(15, version)
			__size += computeStringSize(1, name)
			var index_features = 0
			while (index_features < features.length) {
				__size += computeMessageSize(2, features(index_features))
				index_features += 1
			}
			var index_keys = 0
			while (index_keys < keys.length) {
				__size += computeStringSize(3, keys(index_keys))
				index_keys += 1
			}
			var index_values = 0
			while (index_values < values.length) {
				__size += computeMessageSize(4, values(index_values))
				index_values += 1
			}
			if (extent.isDefined) __size += computeUInt32Size(5, extent.get)

			__size
		}

		def mergeFrom(in: com.google.protobuf.CodedInputStream, extensionRegistry: com.google.protobuf.ExtensionRegistryLite): Layer = {
			import com.google.protobuf.ExtensionRegistryLite.{getEmptyRegistry => _emptyRegistry}
			var __version: Int = 0
			var __name: String = ""
			val __features: scala.collection.mutable.Buffer[Feature] = features.toBuffer
			val __keys: scala.collection.mutable.Buffer[String] = keys.toBuffer
			val __values: scala.collection.mutable.Buffer[Value] = values.toBuffer
			var __extent: Option[Int] = extent

			def __newMerged = Layer(
				__version,
				__name,
				Vector(__features: _*),
				Vector(__keys: _*),
				Vector(__values: _*),
				__extent
			)
			while (true) in.readTag match {
				case 0 => return __newMerged
				case 120 => __version = in.readUInt32()
				case 10 => __name = in.readString()
				case 18 => __features += readMessage[Feature](in, Feature.defaultInstance, _emptyRegistry)
				case 26 => __keys += in.readString()
				case 34 => __values += readMessage[Value](in, Value.defaultInstance, _emptyRegistry)
				case 40 => __extent = Some(in.readUInt32())
				case default => if (!in.skipField(default)) return __newMerged
			}
			null
		}

		def mergeFrom(m: Layer) = {
			Layer(
				m.version,
				m.name,
				features ++ m.features,
				keys ++ m.keys,
				values ++ m.values,
				m.extent.orElse(extent)
			)
		}

		def getDefaultInstanceForType = Layer.defaultInstance
		def clear = getDefaultInstanceForType
		def isInitialized = true
		def build = this
		def buildPartial = this
		def parsePartialFrom(cis: com.google.protobuf.CodedInputStream, er: com.google.protobuf.ExtensionRegistryLite) = mergeFrom(cis, er)
		override def getParserForType = this
		def newBuilderForType = throw new RuntimeException("Method not available.")
		def toBuilder = throw new RuntimeException("Method not available.")
		def toJson(indent: Int = 0): String = "ScalaBuff JSON generation not enabled. Use --generate_json_method to enable."
	}

	object Layer {
		@scala.beans.BeanProperty val defaultInstance = new Layer()

		def parseFrom(data: Array[Byte]): Layer = defaultInstance.mergeFrom(data)
		def parseFrom(data: Array[Byte], offset: Int, length: Int): Layer = defaultInstance.mergeFrom(data, offset, length)
		def parseFrom(byteString: com.google.protobuf.ByteString): Layer = defaultInstance.mergeFrom(byteString)
		def parseFrom(stream: java.io.InputStream): Layer = defaultInstance.mergeFrom(stream)
		def parseDelimitedFrom(stream: java.io.InputStream): Option[Layer] = defaultInstance.mergeDelimitedFromStream(stream)

		val VERSION_FIELD_NUMBER = 15
		val NAME_FIELD_NUMBER = 1
		val FEATURES_FIELD_NUMBER = 2
		val KEYS_FIELD_NUMBER = 3
		val VALUES_FIELD_NUMBER = 4
		val EXTENT_FIELD_NUMBER = 5

		def newBuilder = defaultInstance.newBuilderForType
		def newBuilder(prototype: Layer) = defaultInstance.mergeFrom(prototype)

	}
}

object VectorTile {
	def registerAllExtensions(registry: com.google.protobuf.ExtensionRegistryLite) {
	}

	private val fromBinaryHintMap = collection.immutable.HashMap[String, Array[Byte] ⇒ com.google.protobuf.GeneratedMessageLite](
		 "Tile" -> (bytes ⇒ Tile.parseFrom(bytes))
	)

	def deserializePayload(payload: Array[Byte], payloadType: String): com.google.protobuf.GeneratedMessageLite = {
		fromBinaryHintMap.get(payloadType) match {
			case Some(f) ⇒ f(payload)
			case None    ⇒ throw new IllegalArgumentException(s"unimplemented deserialization of message payload of type [${payloadType}]")
		}
	}
}
