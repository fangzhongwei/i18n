package com.jxjxgo.i18n.service

import javax.inject.Inject

import com.jxjxgo.i18n.rpc.domain.{I18NEndpoint, PullResourceRequest, ResourceResponse}
import com.twitter.util.Future

/**
  * Created by fangzhongwei on 2017/1/13.
  */
class I18NEndpointImpl @Inject()(i18NService: I18NService) extends I18NEndpoint[Future] {
  override def pullLatest(traceId: String, pullResourceRequest: PullResourceRequest): Future[ResourceResponse] = {
    Future.value(i18NService.pullLatest(traceId, pullResourceRequest))
  }

  override def getLatest(traceId: String, lan: String): Future[ResourceResponse] = {
    Future.value(i18NService.getLatest(traceId, lan))
  }
}
