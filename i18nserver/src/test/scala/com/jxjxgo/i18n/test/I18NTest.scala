package com.jxjxgo.i18n.test

import com.jxjxgo.i18n.rpc.domain.I18NEndpoint
import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}
import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by fangzhongwei on 2017/2/5.
  */
object I18NTest {

  def main(args: Array[String]): Unit = {
    val config: Config = ConfigFactory.load()
    val endpoint: I18NEndpoint[Future] = Thrift.client.newIface[I18NEndpoint[Future]](config.getString("finagle.thrift.host.port"))
    println(Await.result(endpoint.getLatest("aaa", "abc")))
  }

}
