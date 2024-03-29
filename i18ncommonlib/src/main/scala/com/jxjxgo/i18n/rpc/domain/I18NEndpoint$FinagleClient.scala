/**
 * Generated by Scrooge
 *   version: 4.15.0
 *   rev: afb71130ca59bc14afcef7aea788ee179657a43b
 *   built at: 20170310-160841
 */
package com.jxjxgo.i18n.rpc.domain

import com.twitter.finagle.SourcedException
import com.twitter.finagle.{service => ctfs}
import com.twitter.finagle.stats.{NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.{Protocols, ThriftClientRequest}
import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec}
import com.twitter.util.{Future, Return, Throw, Throwables}
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.{TMemoryBuffer, TMemoryInputTransport}
import scala.collection.{Map, Set}
import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
class I18NEndpoint$FinagleClient(
    val service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
    val protocolFactory: TProtocolFactory,
    val serviceName: String,
    stats: StatsReceiver,
    responseClassifier: ctfs.ResponseClassifier)
  extends I18NEndpoint[Future] {

  def this(
    service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
    protocolFactory: TProtocolFactory = Protocols.binaryFactory(),
    serviceName: String = "I18NEndpoint",
    stats: StatsReceiver = NullStatsReceiver
  ) = this(
    service,
    protocolFactory,
    serviceName,
    stats,
    ctfs.ResponseClassifier.Default
  )

  import I18NEndpoint._

  protected def encodeRequest(name: String, args: ThriftStruct) = {
    val buf = new TMemoryBuffer(512)
    val oprot = protocolFactory.getProtocol(buf)

    oprot.writeMessageBegin(new TMessage(name, TMessageType.CALL, 0))
    args.write(oprot)
    oprot.writeMessageEnd()

    val bytes = Arrays.copyOfRange(buf.getArray, 0, buf.length)
    new ThriftClientRequest(bytes, false)
  }

  protected def decodeResponse[T <: ThriftStruct](resBytes: Array[Byte], codec: ThriftStructCodec[T]) = {
    val iprot = protocolFactory.getProtocol(new TMemoryInputTransport(resBytes))
    val msg = iprot.readMessageBegin()
    try {
      if (msg.`type` == TMessageType.EXCEPTION) {
        val exception = TApplicationException.readFrom(iprot) match {
          case sourced: SourcedException =>
            if (serviceName != "") sourced.serviceName = serviceName
            sourced
          case e => e
        }
        throw exception
      } else {
        codec.decode(iprot)
      }
    } finally {
      iprot.readMessageEnd()
    }
  }

  protected def missingResult(name: String) = {
    new TApplicationException(
      TApplicationException.MISSING_RESULT,
      name + " failed: unknown result"
    )
  }

  protected def setServiceName(ex: Throwable): Throwable =
    if (this.serviceName == "") ex
    else {
      ex match {
        case se: SourcedException =>
          se.serviceName = this.serviceName
          se
        case _ => ex
      }
    }

  // ----- end boilerplate.

  private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
  private[this] object __stats_getLatest {
    val RequestsCounter = scopedStats.scope("getLatest").counter("requests")
    val SuccessCounter = scopedStats.scope("getLatest").counter("success")
    val FailuresCounter = scopedStats.scope("getLatest").counter("failures")
    val FailuresScope = scopedStats.scope("getLatest").scope("failures")
  }
  
  def getLatest(traceId: String, lan: String): Future[com.jxjxgo.i18n.rpc.domain.ResourceResponse] = {
    __stats_getLatest.RequestsCounter.incr()
    val inputArgs = GetLatest.Args(traceId, lan)
    val replyDeserializer: Array[Byte] => _root_.com.twitter.util.Try[com.jxjxgo.i18n.rpc.domain.ResourceResponse] =
      response => {
        val result = decodeResponse(response, GetLatest.Result)
        val exception: Throwable =
        null
  
        if (result.success.isDefined)
          _root_.com.twitter.util.Return(result.success.get)
        else if (exception != null)
          _root_.com.twitter.util.Throw(exception)
        else
          _root_.com.twitter.util.Throw(missingResult("getLatest"))
      }
  
    val serdeCtx = new _root_.com.twitter.finagle.thrift.DeserializeCtx[com.jxjxgo.i18n.rpc.domain.ResourceResponse](inputArgs, replyDeserializer)
    _root_.com.twitter.finagle.context.Contexts.local.let(
      _root_.com.twitter.finagle.thrift.DeserializeCtx.Key,
      serdeCtx
    ) {
      val serialized = encodeRequest("getLatest", inputArgs)
      this.service(serialized).flatMap { response =>
        Future.const(serdeCtx.deserialize(response))
      }.respond { response =>
        val responseClass = responseClassifier.applyOrElse(
          ctfs.ReqRep(inputArgs, response),
          ctfs.ResponseClassifier.Default)
        responseClass match {
          case ctfs.ResponseClass.Successful(_) =>
            __stats_getLatest.SuccessCounter.incr()
          case ctfs.ResponseClass.Failed(_) =>
            __stats_getLatest.FailuresCounter.incr()
            response match {
              case Throw(ex) =>
                setServiceName(ex)
                __stats_getLatest.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
              case _ =>
            }
        }
      }
    }
  }
  private[this] object __stats_pullLatest {
    val RequestsCounter = scopedStats.scope("pullLatest").counter("requests")
    val SuccessCounter = scopedStats.scope("pullLatest").counter("success")
    val FailuresCounter = scopedStats.scope("pullLatest").counter("failures")
    val FailuresScope = scopedStats.scope("pullLatest").scope("failures")
  }
  
  def pullLatest(traceId: String, request: com.jxjxgo.i18n.rpc.domain.PullResourceRequest): Future[com.jxjxgo.i18n.rpc.domain.ResourceResponse] = {
    __stats_pullLatest.RequestsCounter.incr()
    val inputArgs = PullLatest.Args(traceId, request)
    val replyDeserializer: Array[Byte] => _root_.com.twitter.util.Try[com.jxjxgo.i18n.rpc.domain.ResourceResponse] =
      response => {
        val result = decodeResponse(response, PullLatest.Result)
        val exception: Throwable =
        null
  
        if (result.success.isDefined)
          _root_.com.twitter.util.Return(result.success.get)
        else if (exception != null)
          _root_.com.twitter.util.Throw(exception)
        else
          _root_.com.twitter.util.Throw(missingResult("pullLatest"))
      }
  
    val serdeCtx = new _root_.com.twitter.finagle.thrift.DeserializeCtx[com.jxjxgo.i18n.rpc.domain.ResourceResponse](inputArgs, replyDeserializer)
    _root_.com.twitter.finagle.context.Contexts.local.let(
      _root_.com.twitter.finagle.thrift.DeserializeCtx.Key,
      serdeCtx
    ) {
      val serialized = encodeRequest("pullLatest", inputArgs)
      this.service(serialized).flatMap { response =>
        Future.const(serdeCtx.deserialize(response))
      }.respond { response =>
        val responseClass = responseClassifier.applyOrElse(
          ctfs.ReqRep(inputArgs, response),
          ctfs.ResponseClassifier.Default)
        responseClass match {
          case ctfs.ResponseClass.Successful(_) =>
            __stats_pullLatest.SuccessCounter.incr()
          case ctfs.ResponseClass.Failed(_) =>
            __stats_pullLatest.FailuresCounter.incr()
            response match {
              case Throw(ex) =>
                setServiceName(ex)
                __stats_pullLatest.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
              case _ =>
            }
        }
      }
    }
  }
}
