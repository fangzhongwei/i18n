/**
 * Generated by Scrooge
 *   version: 4.15.0
 *   rev: afb71130ca59bc14afcef7aea788ee179657a43b
 *   built at: 20170310-160841
 */
package com.jxjxgo.i18n.rpc.domain

import com.twitter.scrooge.{
  HasThriftStructCodec3,
  LazyTProtocol,
  TFieldBlob,
  ThriftException,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ThriftUtil
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport}
import java.nio.ByteBuffer
import java.util.Arrays
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}


object Resource extends ThriftStructCodec3[Resource] {
  private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("Resource")
  val IdField = new TField("id", TType.I64, 1)
  val IdFieldManifest = implicitly[Manifest[Long]]
  val TypeField = new TField("type", TType.I32, 2)
  val TypeFieldManifest = implicitly[Manifest[Int]]
  val CodeField = new TField("code", TType.STRING, 3)
  val CodeFieldManifest = implicitly[Manifest[String]]
  val LanField = new TField("lan", TType.STRING, 4)
  val LanFieldManifest = implicitly[Manifest[String]]
  val DescField = new TField("desc", TType.STRING, 5)
  val DescFieldManifest = implicitly[Manifest[String]]
  val VersionField = new TField("version", TType.I32, 6)
  val VersionFieldManifest = implicitly[Manifest[Int]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      IdField,
      false,
      false,
      IdFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      Some[Long](0L)
    ),
    new ThriftStructFieldInfo(
      TypeField,
      false,
      false,
      TypeFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      Some[Int](0)
    ),
    new ThriftStructFieldInfo(
      CodeField,
      false,
      false,
      CodeFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      Some[String]("")
    ),
    new ThriftStructFieldInfo(
      LanField,
      false,
      false,
      LanFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      Some[String]("")
    ),
    new ThriftStructFieldInfo(
      DescField,
      false,
      false,
      DescFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      Some[String]("")
    ),
    new ThriftStructFieldInfo(
      VersionField,
      false,
      false,
      VersionFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      Some[Int](0)
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: Resource): Unit = {
  }

  def withoutPassthroughFields(original: Resource): Resource =
    new Immutable(
      id =
        {
          val field = original.id
          field
        },
      `type` =
        {
          val field = original.`type`
          field
        },
      code =
        {
          val field = original.code
          field
        },
      lan =
        {
          val field = original.lan
          field
        },
      desc =
        {
          val field = original.desc
          field
        },
      version =
        {
          val field = original.version
          field
        }
    )

  override def encode(_item: Resource, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }

  private[this] def lazyDecode(_iprot: LazyTProtocol): Resource = {

    var id: Long = 0L
    var `type`: Int = 0
    var codeOffset: Int = -1
    var lanOffset: Int = -1
    var descOffset: Int = -1
    var version: Int = 0

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I64 =>
    
                id = readIdValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'id' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.I32 =>
    
                `type` = readTypeValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field '`type`' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRING =>
                codeOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'code' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 4 =>
            _field.`type` match {
              case TType.STRING =>
                lanOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'lan' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 5 =>
            _field.`type` match {
              case TType.STRING =>
                descOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'desc' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 6 =>
            _field.`type` match {
              case TType.I32 =>
    
                version = readVersionValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'version' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      id,
      `type`,
      codeOffset,
      lanOffset,
      descOffset,
      version,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): Resource =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[this] def eagerDecode(_iprot: TProtocol): Resource = {
    var id: Long = 0L
    var `type`: Int = 0
    var code: String = ""
    var lan: String = ""
    var desc: String = ""
    var version: Int = 0
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I64 =>
                id = readIdValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'id' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.I32 =>
                `type` = readTypeValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field '`type`' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRING =>
                code = readCodeValue(_iprot)
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'code' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 4 =>
            _field.`type` match {
              case TType.STRING =>
                lan = readLanValue(_iprot)
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'lan' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 5 =>
            _field.`type` match {
              case TType.STRING =>
                desc = readDescValue(_iprot)
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'desc' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 6 =>
            _field.`type` match {
              case TType.I32 =>
                version = readVersionValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'version' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    new Immutable(
      id,
      `type`,
      code,
      lan,
      desc,
      version,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    id: Long = 0L,
    `type`: Int = 0,
    code: String = "",
    lan: String = "",
    desc: String = "",
    version: Int = 0
  ): Resource =
    new Immutable(
      id,
      `type`,
      code,
      lan,
      desc,
      version
    )

  def unapply(_item: Resource): _root_.scala.Option[_root_.scala.Tuple6[Long, Int, String, String, String, Int]] = _root_.scala.Some(_item.toTuple)


  @inline private def readIdValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeIdField(id_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(IdField)
    writeIdValue(id_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeIdValue(id_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(id_item)
  }

  @inline private def readTypeValue(_iprot: TProtocol): Int = {
    _iprot.readI32()
  }

  @inline private def writeTypeField(type_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(TypeField)
    writeTypeValue(type_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeTypeValue(type_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeI32(type_item)
  }

  @inline private def readCodeValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeCodeField(code_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(CodeField)
    writeCodeValue(code_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeCodeValue(code_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(code_item)
  }

  @inline private def readLanValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeLanField(lan_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(LanField)
    writeLanValue(lan_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeLanValue(lan_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(lan_item)
  }

  @inline private def readDescValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeDescField(desc_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(DescField)
    writeDescValue(desc_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeDescValue(desc_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(desc_item)
  }

  @inline private def readVersionValue(_iprot: TProtocol): Int = {
    _iprot.readI32()
  }

  @inline private def writeVersionField(version_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(VersionField)
    writeVersionValue(version_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeVersionValue(version_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeI32(version_item)
  }


  object Immutable extends ThriftStructCodec3[Resource] {
    override def encode(_item: Resource, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): Resource = Resource.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[Resource] = Resource.metaData
  }

  /**
   * The default read-only implementation of Resource.  You typically should not need to
   * directly reference this class; instead, use the Resource.apply method to construct
   * new instances.
   */
  class Immutable(
      val id: Long,
      val `type`: Int,
      val code: String,
      val lan: String,
      val desc: String,
      val version: Int,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Resource {
    def this(
      id: Long = 0L,
      `type`: Int = 0,
      code: String = "",
      lan: String = "",
      desc: String = "",
      version: Int = 0
    ) = this(
      id,
      `type`,
      code,
      lan,
      desc,
      version,
      Map.empty
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      val id: Long,
      val `type`: Int,
      codeOffset: Int,
      lanOffset: Int,
      descOffset: Int,
      val version: Int,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Resource {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }

    lazy val code: String =
      if (codeOffset == -1)
        ""
      else {
        _proto.decodeString(_buf, codeOffset)
      }
    lazy val lan: String =
      if (lanOffset == -1)
        ""
      else {
        _proto.decodeString(_buf, lanOffset)
      }
    lazy val desc: String =
      if (descOffset == -1)
        ""
      else {
        _proto.decodeString(_buf, descOffset)
      }

    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the Resource trait with additional state or
   * behavior and implement the read-only methods from Resource using an underlying
   * instance.
   */
  trait Proxy extends Resource {
    protected def _underlying_Resource: Resource
    override def id: Long = _underlying_Resource.id
    override def `type`: Int = _underlying_Resource.`type`
    override def code: String = _underlying_Resource.code
    override def lan: String = _underlying_Resource.lan
    override def desc: String = _underlying_Resource.desc
    override def version: Int = _underlying_Resource.version
    override def _passthroughFields = _underlying_Resource._passthroughFields
  }
}

trait Resource
  extends ThriftStruct
  with _root_.scala.Product6[Long, Int, String, String, String, Int]
  with HasThriftStructCodec3[Resource]
  with java.io.Serializable
{
  import Resource._

  def id: Long
  def `type`: Int
  def code: String
  def lan: String
  def desc: String
  def version: Int

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = id
  def _2 = `type`
  def _3 = code
  def _4 = lan
  def _5 = desc
  def _6 = version

  def toTuple: _root_.scala.Tuple6[Long, Int, String, String, String, Int] = {
    (
      id,
      `type`,
      code,
      lan,
      desc,
      version
    )
  }


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (true) {
                writeIdValue(id, _oprot)
                _root_.scala.Some(Resource.IdField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (true) {
                writeTypeValue(`type`, _oprot)
                _root_.scala.Some(Resource.TypeField)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (code ne null) {
                writeCodeValue(code, _oprot)
                _root_.scala.Some(Resource.CodeField)
              } else {
                _root_.scala.None
              }
            case 4 =>
              if (lan ne null) {
                writeLanValue(lan, _oprot)
                _root_.scala.Some(Resource.LanField)
              } else {
                _root_.scala.None
              }
            case 5 =>
              if (desc ne null) {
                writeDescValue(desc, _oprot)
                _root_.scala.Some(Resource.DescField)
              } else {
                _root_.scala.None
              }
            case 6 =>
              if (true) {
                writeVersionValue(version, _oprot)
                _root_.scala.Some(Resource.VersionField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            val _data = Arrays.copyOfRange(_buff.getArray, 0, _buff.length)
            _root_.scala.Some(TFieldBlob(_field, _data))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): Resource = {
    var id: Long = this.id
    var `type`: Int = this.`type`
    var code: String = this.code
    var lan: String = this.lan
    var desc: String = this.desc
    var version: Int = this.version
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        id = readIdValue(_blob.read)
      case 2 =>
        `type` = readTypeValue(_blob.read)
      case 3 =>
        code = readCodeValue(_blob.read)
      case 4 =>
        lan = readLanValue(_blob.read)
      case 5 =>
        desc = readDescValue(_blob.read)
      case 6 =>
        version = readVersionValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      id,
      `type`,
      code,
      lan,
      desc,
      version,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): Resource = {
    var id: Long = this.id
    var `type`: Int = this.`type`
    var code: String = this.code
    var lan: String = this.lan
    var desc: String = this.desc
    var version: Int = this.version

    _fieldId match {
      case 1 =>
        id = 0L
      case 2 =>
        `type` = 0
      case 3 =>
        code = ""
      case 4 =>
        lan = ""
      case 5 =>
        desc = ""
      case 6 =>
        version = 0
      case _ =>
    }
    new Immutable(
      id,
      `type`,
      code,
      lan,
      desc,
      version,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetId: Resource = unsetField(1)

  def unsetType: Resource = unsetField(2)

  def unsetCode: Resource = unsetField(3)

  def unsetLan: Resource = unsetField(4)

  def unsetDesc: Resource = unsetField(5)

  def unsetVersion: Resource = unsetField(6)


  override def write(_oprot: TProtocol): Unit = {
    Resource.validate(this)
    _oprot.writeStructBegin(Struct)
    writeIdField(id, _oprot)
    writeTypeField(`type`, _oprot)
    if (code ne null) writeCodeField(code, _oprot)
    if (lan ne null) writeLanField(lan, _oprot)
    if (desc ne null) writeDescField(desc, _oprot)
    writeVersionField(version, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    id: Long = this.id,
    `type`: Int = this.`type`,
    code: String = this.code,
    lan: String = this.lan,
    desc: String = this.desc,
    version: Int = this.version,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): Resource =
    new Immutable(
      id,
      `type`,
      code,
      lan,
      desc,
      version,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Resource]

  private def _equals(x: Resource, y: Resource): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[Resource]) &&
      _passthroughFields == other.asInstanceOf[Resource]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 6

  override def productElement(n: Int): Any = n match {
    case 0 => this.id
    case 1 => this.`type`
    case 2 => this.code
    case 3 => this.lan
    case 4 => this.desc
    case 5 => this.version
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "Resource"

  def _codec: ThriftStructCodec3[Resource] = Resource
}