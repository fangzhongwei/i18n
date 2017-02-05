package com.lawsofnature.i18n.service

import javax.inject.Inject

import com.jxjxgo.common.exception.ErrorCode
import com.jxjxgo.i18n.rpc.domain.{PullResourceRequest, Resource, ResourceResponse}
import com.lawsofnature.i18n.repo.I18NRepository

/**
  * Created by fangzhongwei on 2017/1/13.
  */
trait I18NService {
  def pullLatest(traceId: String, pullResourceRequest: PullResourceRequest): ResourceResponse

  def getLatest(traceId: String, lan: String): ResourceResponse
}

class I18NServiceImpl @Inject()(i18NRepository: I18NRepository) extends I18NService {
  implicit def rawSeq2RpcArray(seq: Seq[i18NRepository.TmResourceRow]): Seq[Resource] = {
    seq.map {
      r => Resource(r.id, r.`type`, r.code, r.lan, r.desc, r.version)
    }
  }

  override def pullLatest(traceId: String, request: PullResourceRequest): ResourceResponse = {
    val maybeLatestVersion: Option[Int] = i18NRepository.getLatestVersion(request.lan)
    maybeLatestVersion match {
      case Some(latestVersion) =>
        val tmResourceRows: Seq[i18NRepository.TmResourceRow] = i18NRepository.pullResources(request.lan, request.version)
        ResourceResponse("0", latestVersion, tmResourceRows)
      case None => ResourceResponse(code = ErrorCode.EC_I18N_LAN_NOT_EXIST.getCode)
    }
  }

  override def getLatest(traceId: String, lan: String): ResourceResponse = {
    val maybeLatestVersion: Option[Int] = i18NRepository.getLatestVersion(lan)
    maybeLatestVersion match {
      case Some(latestVersion) =>
        val tmResourceRows: Seq[i18NRepository.TmResourceRow] = i18NRepository.selectAllResources(lan)
        ResourceResponse("0", latestVersion, tmResourceRows)
      case None => ResourceResponse(code = ErrorCode.EC_I18N_LAN_NOT_EXIST.getCode)
    }
  }
}
