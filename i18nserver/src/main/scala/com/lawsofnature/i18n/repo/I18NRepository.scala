package com.lawsofnature.i18n.repo

import com.lawsofnature.connection.DBComponent

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by fangzhongwei on 2017/1/13.
  */
trait I18NRepository extends Tables {
  this: DBComponent =>

  import profile.api._

  def selectAllResources(lan: String): Seq[TmResourceRow] = {
    Await.result(db.run {
      TmResource.sortBy(_.id).filter(_.lan === lan).result
    }, Duration.Inf)
  }

  def pullResources(lan: String, version: Int): Seq[TmResourceRow] = {
    Await.result(db.run {
      TmResource.filter {
        r => r.version > version && r.lan === lan
      }.result
    }, Duration.Inf)
  }

  def getLatestVersion(lan: String): Int = {
    Await.result(db.run {
      TmResourceConfig.filter(_.lan === lan).map(_.latestVersion).result.head
    }, Duration.Inf)
  }
}

class I18NRepositoryImpl extends I18NRepository with DBComponent
