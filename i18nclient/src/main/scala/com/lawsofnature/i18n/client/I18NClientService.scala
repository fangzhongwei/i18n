package com.lawsofnature.i18n.client

import javax.inject.{Inject, Named}

import RpcI18N.{CheckResourceVersionRequest, I18NEndpointPrx, I18NEndpointPrxHelper}
import com.lawsofnatrue.common.ice.IcePrxFactory
import org.slf4j.LoggerFactory

/**
  * Created by fangzhongwei on 2017/1/12.
  */
trait I18NClientService {
  def initClient

  def getLatest(traceId: String, lan: String)

  def check(traceId: String, request: CheckResourceVersionRequest)
}

class I18NClientServiceImpl @Inject()(@Named("i18n.ice.client.init.config") iceInitConfig: String,
                                      @Named("i18n.ice.client.init.size") iceInitSizeConfig: String,
                                      @Named("i18n.ice.client.init.size-max") iceInitSizeMaxConfig: String,
                                      @Named("i18n.ice.client.init.size-warn") iceInitSizeWarnConfig: String,
                                      @Named("i18n.ice.client.proxy.config") proxyConfig: String,
                                      icePrxFactory: IcePrxFactory) extends I18NClientService {
  val logger = LoggerFactory.getLogger(this.getClass)

  var i18nEndpoint: I18NEndpointPrx = _

  override def initClient = i18nEndpoint = icePrxFactory.make[I18NEndpointPrx](Array[String](iceInitConfig, iceInitSizeConfig, iceInitSizeMaxConfig, iceInitSizeWarnConfig), proxyConfig, I18NEndpointPrxHelper.checkedCast)

  override def getLatest(traceId: String, lan: String): Unit = i18nEndpoint.getLatest(traceId, lan)

  override def check(traceId: String, request: CheckResourceVersionRequest): Unit = i18nEndpoint.check(traceId, request)
}
