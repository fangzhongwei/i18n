package com.lawsofnature.i18n.service

import javax.inject.Inject

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

  implicit def rawSeq2RpcArray(seq: Seq[i18NRepository.TmResourceRow]): Array[Resource] = {
    seq.map {
      r => Resource(r.id, r.`type`, r.code, r.lan, r.desc, r.version)
    }.toArray
  }

  override def pullLatest(traceId: String, request: PullResourceRequest): ResourceResponse = {
    val latestVersion: Int = i18NRepository.getLatestVersion(request.lan)
    val tmResourceRows: Seq[i18NRepository.TmResourceRow] = i18NRepository.pullResources(request.lan, request.version)
    val seq: Seq[Resource] = tmResourceRows.map {
      r => Resource(r.id, r.`type`, r.code, r.lan, r.desc, r.version)
    }
    ResourceResponse("0", latestVersion, seq)
  }

  override def getLatest(traceId: String, lan: String): ResourceResponse = {
    val latestVersion: Int = i18NRepository.getLatestVersion(lan)
    val tmResourceRows: Seq[i18NRepository.TmResourceRow] = i18NRepository.selectAllResources(lan)
    val seq: Seq[Resource] = tmResourceRows.map {
      r => Resource(r.id, r.`type`, r.code, r.lan, r.desc, r.version)
    }
    ResourceResponse("0", latestVersion, seq)
  }
}
