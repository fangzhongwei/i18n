package com.jxjxgo.i18n.repo

import com.jxjxgo.mysql.connection.DBImpl

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables extends DBImpl {

  import profile.api._

  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** Entity class storing rows of table TmResource
    *
    * @param id        Database column id SqlType(int8), PrimaryKey
    * @param `type`    Database column type SqlType(int2)
    * @param code      Database column code SqlType(varchar), Length(32,true)
    * @param lan       Database column lan SqlType(varchar), Length(8,true)
    * @param desc      Database column desc SqlType(varchar), Length(64,true)
    * @param version   Database column version SqlType(int4)
    * @param gmtCreate Database column gmt_create SqlType(timestamp)
    * @param gmtUpdate Database column gmt_update SqlType(timestamp) */
  case class TmResourceRow(id: Long, `type`: Short, code: String, lan: String, desc: String, version: Int, gmtCreate: java.sql.Timestamp, gmtUpdate: java.sql.Timestamp)

  /** GetResult implicit for fetching TmResourceRow objects using plain SQL queries */
  implicit def GetResultTmResourceRow(implicit e0: GR[Long], e1: GR[Short], e2: GR[String], e3: GR[Int], e4: GR[java.sql.Timestamp]): GR[TmResourceRow] = GR {
    prs => import prs._
      TmResourceRow.tupled((<<[Long], <<[Short], <<[String], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }

  /** Table description of table tm_resource. Objects of this class serve as prototypes for rows in queries.
    * NOTE: The following names collided with Scala keywords and were escaped: type */
  class TmResource(_tableTag: Tag) extends profile.api.Table[TmResourceRow](_tableTag, "tm_resource") {
    def * = (id, `type`, code, lan, desc, version, gmtCreate, gmtUpdate) <> (TmResourceRow.tupled, TmResourceRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(`type`), Rep.Some(code), Rep.Some(lan), Rep.Some(desc), Rep.Some(version), Rep.Some(gmtCreate), Rep.Some(gmtUpdate)).shaped.<>({ r => import r._; _1.map(_ => TmResourceRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int8), PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.PrimaryKey)
    /** Database column type SqlType(int2)
      * NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Short] = column[Short]("type")
    /** Database column code SqlType(varchar), Length(32,true) */
    val code: Rep[String] = column[String]("code", O.Length(32, varying = true))
    /** Database column lan SqlType(varchar), Length(8,true) */
    val lan: Rep[String] = column[String]("lan", O.Length(8, varying = true))
    /** Database column desc SqlType(varchar), Length(64,true) */
    val desc: Rep[String] = column[String]("desc", O.Length(64, varying = true))
    /** Database column version SqlType(int4) */
    val version: Rep[Int] = column[Int]("version")
    /** Database column gmt_create SqlType(timestamp) */
    val gmtCreate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("gmt_create")
    /** Database column gmt_update SqlType(timestamp) */
    val gmtUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("gmt_update")
  }

  /** Collection-like TableQuery object for table TmResource */
  lazy val TmResource = new TableQuery(tag => new TmResource(tag))

  /** Entity class storing rows of table TmResourceConfig
    *
    * @param id            Database column id SqlType(int4), PrimaryKey
    * @param lan           Database column lan SqlType(varchar), Length(16,true)
    * @param latestVersion Database column latest_version SqlType(int4)
    * @param gmtCreate     Database column gmt_create SqlType(timestamp)
    * @param gmtUpdate     Database column gmt_update SqlType(timestamp) */
  case class TmResourceConfigRow(id: Int, lan: String, latestVersion: Int, gmtCreate: java.sql.Timestamp, gmtUpdate: java.sql.Timestamp)

  /** GetResult implicit for fetching TmResourceConfigRow objects using plain SQL queries */
  implicit def GetResultTmResourceConfigRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TmResourceConfigRow] = GR {
    prs => import prs._
      TmResourceConfigRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }

  /** Table description of table tm_resource_config. Objects of this class serve as prototypes for rows in queries. */
  class TmResourceConfig(_tableTag: Tag) extends profile.api.Table[TmResourceConfigRow](_tableTag, "tm_resource_config") {
    def * = (id, lan, latestVersion, gmtCreate, gmtUpdate) <> (TmResourceConfigRow.tupled, TmResourceConfigRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(lan), Rep.Some(latestVersion), Rep.Some(gmtCreate), Rep.Some(gmtUpdate)).shaped.<>({ r => import r._; _1.map(_ => TmResourceConfigRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int4), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column lan SqlType(varchar), Length(16,true) */
    val lan: Rep[String] = column[String]("lan", O.Length(16, varying = true))
    /** Database column latest_version SqlType(int4) */
    val latestVersion: Rep[Int] = column[Int]("latest_version")
    /** Database column gmt_create SqlType(timestamp) */
    val gmtCreate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("gmt_create")
    /** Database column gmt_update SqlType(timestamp) */
    val gmtUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("gmt_update")
  }

  /** Collection-like TableQuery object for table TmResourceConfig */
  lazy val TmResourceConfig = new TableQuery(tag => new TmResourceConfig(tag))
}
