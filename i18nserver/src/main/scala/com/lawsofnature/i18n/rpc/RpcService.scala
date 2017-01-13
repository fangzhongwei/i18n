package com.lawsofnature.i18n.rpc

import java.util

import Ice.ObjectImpl
import com.google.inject.name.Names
import com.google.inject.{AbstractModule, Guice}
import com.lawsofnatrue.common.ice._
import com.lawsofnature.i18n.repo.{I18NRepository, I18NRepositoryImpl}
import com.lawsofnature.i18n.service.{I18NEndpointImpl, I18NService, I18NServiceImpl}
import org.slf4j.LoggerFactory

object RpcService extends App {
  var logger = LoggerFactory.getLogger(this.getClass)

  private val injector = Guice.createInjector(new AbstractModule() {
    override def configure() {
      val map: util.HashMap[String, String] = ConfigHelper.configMap
      Names.bindProperties(binder(), map)
      bind(classOf[I18NRepository]).to(classOf[I18NRepositoryImpl]).asEagerSingleton()
      bind(classOf[I18NService]).to(classOf[I18NServiceImpl]).asEagerSingleton()
      bind(classOf[ObjectImpl]).to(classOf[I18NEndpointImpl]).asEagerSingleton()
      bind(classOf[IceServerTemplate]).to(classOf[IceServerTemplateImpl]).asEagerSingleton()
      bind(classOf[IcePrxFactory]).to(classOf[IcePrxFactoryImpl]).asEagerSingleton()
    }
  })

  injector.getInstance(classOf[IceServerTemplate]).startServer
}
