package com.jxjxgo.i18n.rpc

import java.util

import com.google.inject.name.Names
import com.google.inject.{AbstractModule, Guice}
import com.jxjxgo.common.helper.ConfigHelper
import com.jxjxgo.scrooge.thrift.template.{ScroogeThriftServerTemplate, ScroogeThriftServerTemplateImpl}
import com.jxjxgo.i18n.repo.{I18NRepository, I18NRepositoryImpl}
import com.jxjxgo.i18n.service.{I18NEndpointImpl, I18NService, I18NServiceImpl}
import com.twitter.scrooge.ThriftService
import org.slf4j.LoggerFactory

object RpcService extends App {
  private[this] var logger = LoggerFactory.getLogger(this.getClass)

  private[this] val injector = Guice.createInjector(new AbstractModule() {
    override def configure() {
      val map: util.HashMap[String, String] = ConfigHelper.configMap
      Names.bindProperties(binder(), map)
      bind(classOf[I18NRepository]).to(classOf[I18NRepositoryImpl]).asEagerSingleton()
      bind(classOf[I18NService]).to(classOf[I18NServiceImpl]).asEagerSingleton()
      bind(classOf[ThriftService]).to(classOf[I18NEndpointImpl]).asEagerSingleton()
      bind(classOf[ScroogeThriftServerTemplate]).to(classOf[ScroogeThriftServerTemplateImpl]).asEagerSingleton()
    }
  })

  injector.getInstance(classOf[ScroogeThriftServerTemplate]).init
}
