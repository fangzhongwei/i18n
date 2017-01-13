package com.lawsofnature.i18n.service

import javax.inject.Inject

import Ice.Current
import RpcI18N.{PullResourceRequest, ResourceResponse, _I18NEndpointDisp}

/**
  * Created by fangzhongwei on 2017/1/13.
  */
class I18NEndpointImpl @Inject()(i18NService: I18NService) extends _I18NEndpointDisp{
  override def pullLatest(traceId: String, pullResourceRequest: PullResourceRequest, current: Current): ResourceResponse = i18NService.pullLatest(traceId, pullResourceRequest)

  override def getLatest(traceId: String, lan: String, current: Current): ResourceResponse = i18NService.getLatest(traceId, lan)
}
