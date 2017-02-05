/**
 * Generated by Scrooge
 *   version: 4.5.0
 *   rev: 014664de600267b36809bbc85225e26aec286216
 *   built at: 20160203-205352
 */
package com.jxjxgo.i18n.rpc.domain

import com.twitter.finagle.Thrift
import com.twitter.finagle.stats.{NullStatsReceiver, StatsReceiver}
import com.twitter.scrooge.{ThriftStruct, TReusableMemoryTransport}
import com.twitter.util.{Future, Return, Throw, Throwables}
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.TMemoryInputTransport
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, HashMap => mutable$HashMap}
import scala.collection.{Map, Set}

import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
class I18NEndpoint$FinagleService(
  iface: I18NEndpoint[Future],
  protocolFactory: TProtocolFactory,
  stats: StatsReceiver,
  maxThriftBufferSize: Int,
  serviceName: String
) extends com.twitter.finagle.Service[Array[Byte], Array[Byte]] {
  import I18NEndpoint._

  def this(
    iface: I18NEndpoint[Future],
    protocolFactory: TProtocolFactory,
    stats: StatsReceiver,
    maxThriftBufferSize: Int
  ) = this(iface, protocolFactory, stats, maxThriftBufferSize, "I18NEndpoint")

  def this(
    iface: I18NEndpoint[Future],
    protocolFactory: TProtocolFactory
  ) = this(iface, protocolFactory, NullStatsReceiver, Thrift.maxThriftBufferSize)

  private[this] val tlReusableBuffer = new ThreadLocal[TReusableMemoryTransport] {
    override def initialValue() = TReusableMemoryTransport(512)
  }

  private[this] def reusableBuffer: TReusableMemoryTransport = {
    val buf = tlReusableBuffer.get()
    buf.reset()
    buf
  }

  private[this] val resetCounter = stats.scope("buffer").counter("resetCount")

  private[this] def resetBuffer(trans: TReusableMemoryTransport): Unit = {
    if (trans.currentCapacity > maxThriftBufferSize) {
      resetCounter.incr()
      tlReusableBuffer.remove()
    }
  }

  protected val functionMap = new mutable$HashMap[String, (TProtocol, Int) => Future[Array[Byte]]]()

  protected def addFunction(name: String, f: (TProtocol, Int) => Future[Array[Byte]]) {
    functionMap(name) = f
  }

  protected def exception(name: String, seqid: Int, code: Int, message: String): Future[Array[Byte]] = {
    try {
      val x = new TApplicationException(code, message)
      val memoryBuffer = reusableBuffer
      try {
        val oprot = protocolFactory.getProtocol(memoryBuffer)

        oprot.writeMessageBegin(new TMessage(name, TMessageType.EXCEPTION, seqid))
        x.write(oprot)
        oprot.writeMessageEnd()
        oprot.getTransport().flush()
        Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()))
      } finally {
        resetBuffer(memoryBuffer)
      }
    } catch {
      case e: Exception => Future.exception(e)
    }
  }

  protected def reply(name: String, seqid: Int, result: ThriftStruct): Future[Array[Byte]] = {
    try {
      val memoryBuffer = reusableBuffer
      try {
        val oprot = protocolFactory.getProtocol(memoryBuffer)

        oprot.writeMessageBegin(new TMessage(name, TMessageType.REPLY, seqid))
        result.write(oprot)
        oprot.writeMessageEnd()

        Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()))
      } finally {
        resetBuffer(memoryBuffer)
      }
    } catch {
      case e: Exception => Future.exception(e)
    }
  }

  final def apply(request: Array[Byte]): Future[Array[Byte]] = {
    val inputTransport = new TMemoryInputTransport(request)
    val iprot = protocolFactory.getProtocol(inputTransport)

    try {
      val msg = iprot.readMessageBegin()
      val func = functionMap.get(msg.name)
      func match {
        case _root_.scala.Some(fn) =>
          fn(iprot, msg.seqid)
        case _ =>
          TProtocolUtil.skip(iprot, TType.STRUCT)
          exception(msg.name, msg.seqid, TApplicationException.UNKNOWN_METHOD,
            "Invalid method name: '" + msg.name + "'")
      }
    } catch {
      case e: Exception => Future.exception(e)
    }
  }

  // ---- end boilerplate.

  private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
  private[this] object __stats_getLatest {
    val RequestsCounter = scopedStats.scope("getLatest").counter("requests")
    val SuccessCounter = scopedStats.scope("getLatest").counter("success")
    val FailuresCounter = scopedStats.scope("getLatest").counter("failures")
    val FailuresScope = scopedStats.scope("getLatest").scope("failures")
  }
  addFunction("getLatest", { (iprot: TProtocol, seqid: Int) =>
    try {
      __stats_getLatest.RequestsCounter.incr()
      val args = GetLatest.Args.decode(iprot)
      iprot.readMessageEnd()
      (try {
        iface.getLatest(args.traceId, args.lan)
      } catch {
        case e: Exception => Future.exception(e)
      }).flatMap { value: com.jxjxgo.i18n.rpc.domain.ResourceResponse =>
        reply("getLatest", seqid, GetLatest.Result(success = Some(value)))
      }.rescue {
        case e => Future.exception(e)
      }.respond {
        case Return(_) =>
          __stats_getLatest.SuccessCounter.incr()
        case Throw(ex) =>
          __stats_getLatest.FailuresCounter.incr()
          __stats_getLatest.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
      }
    } catch {
      case e: TProtocolException => {
        iprot.readMessageEnd()
        exception("getLatest", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
      }
      case e: Exception => Future.exception(e)
    }
  })
  private[this] object __stats_pullLatest {
    val RequestsCounter = scopedStats.scope("pullLatest").counter("requests")
    val SuccessCounter = scopedStats.scope("pullLatest").counter("success")
    val FailuresCounter = scopedStats.scope("pullLatest").counter("failures")
    val FailuresScope = scopedStats.scope("pullLatest").scope("failures")
  }
  addFunction("pullLatest", { (iprot: TProtocol, seqid: Int) =>
    try {
      __stats_pullLatest.RequestsCounter.incr()
      val args = PullLatest.Args.decode(iprot)
      iprot.readMessageEnd()
      (try {
        iface.pullLatest(args.traceId, args.request)
      } catch {
        case e: Exception => Future.exception(e)
      }).flatMap { value: com.jxjxgo.i18n.rpc.domain.ResourceResponse =>
        reply("pullLatest", seqid, PullLatest.Result(success = Some(value)))
      }.rescue {
        case e => Future.exception(e)
      }.respond {
        case Return(_) =>
          __stats_pullLatest.SuccessCounter.incr()
        case Throw(ex) =>
          __stats_pullLatest.FailuresCounter.incr()
          __stats_pullLatest.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
      }
    } catch {
      case e: TProtocolException => {
        iprot.readMessageEnd()
        exception("pullLatest", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
      }
      case e: Exception => Future.exception(e)
    }
  })
}