package com.lawsofnature.i18n.repo

import com.jxjxgo.mysql.connection.MySQLDBImpl


/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables extends MySQLDBImpl {

  import profile.api._

  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = TmResource.schema ++ TmResourceConfig.schema

  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table TmResource
    *
    * @param id        Database column id SqlType(BIGINT), AutoInc, PrimaryKey
    * @param `type`    Database column type SqlType(TINYINT)
    * @param code      Database column code SqlType(VARCHAR), Length(32,true)
    * @param lan       Database column lan SqlType(VARCHAR), Length(8,true)
    * @param desc      Database column desc SqlType(VARCHAR), Length(64,true)
    * @param version   Database column version SqlType(INT)
    * @param gmtCreate Database column gmt_create SqlType(TIMESTAMP)
    * @param gmtUpdate Database column gmt_update SqlType(TIMESTAMP) */
  case class TmResourceRow(id: Long, `type`: Byte, code: String, lan: String, desc: String, version: Int, gmtCreate: java.sql.Timestamp, gmtUpdate: java.sql.Timestamp)

  /** GetResult implicit for fetching TmResourceRow objects using plain SQL queries */
  implicit def GetResultTmResourceRow(implicit e0: GR[Long], e1: GR[Byte], e2: GR[String], e3: GR[Int], e4: GR[java.sql.Timestamp]): GR[TmResourceRow] = GR {
    prs => import prs._
      TmResourceRow.tupled((<<[Long], <<[Byte], <<[String], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }

  /** Table description of table tm_resource. Objects of this class serve as prototypes for rows in queries.
    * NOTE: The following names collided with Scala keywords and were escaped: type */
  class TmResource(_tableTag: Tag) extends profile.api.Table[TmResourceRow](_tableTag, Some("i18n"), "tm_resource") {
    def * = (id, `type`, code, lan, desc, version, gmtCreate, gmtUpdate) <> (TmResourceRow.tupled, TmResourceRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(`type`), Rep.Some(code), Rep.Some(lan), Rep.Some(desc), Rep.Some(version), Rep.Some(gmtCreate), Rep.Some(gmtUpdate)).shaped.<>({ r => import r._; _1.map(_ => TmResourceRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column type SqlType(TINYINT)
      * NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Byte] = column[Byte]("type")
    /** Database column code SqlType(VARCHAR), Length(32,true) */
    val code: Rep[String] = column[String]("code", O.Length(32, varying = true))
    /** Database column lan SqlType(VARCHAR), Length(8,true) */
    val lan: Rep[String] = column[String]("lan", O.Length(8, varying = true))
    /** Database column desc SqlType(VARCHAR), Length(64,true) */
    val desc: Rep[String] = column[String]("desc", O.Length(64, varying = true))
    /** Database column version SqlType(INT) */
    val version: Rep[Int] = column[Int]("version")
    /** Database column gmt_create SqlType(TIMESTAMP) */
    val gmtCreate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("gmt_create")
    /** Database column gmt_update SqlType(TIMESTAMP) */
    val gmtUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("gmt_update")

    /** Index over (version) (database name idx_v) */
    val index1 = index("idx_v", version)
    /** Uniqueness Index over (code,lan,version) (database name uq_ec) */
    val index2 = index("uq_ec", (code, lan, version), unique = true)
  }

  /** Collection-like TableQuery object for table TmResource */
  lazy val TmResource = new TableQuery(tag => new TmResource(tag))

  /** Entity class storing rows of table TmResourceConfig
    *
    * @param id            Database column id SqlType(INT), PrimaryKey
    * @param lan           Database column lan SqlType(VARCHAR), Length(16,true)
    * @param latestVersion Database column latest_version SqlType(INT)
    * @param gmtCreate     Database column gmt_create SqlType(TIMESTAMP)
    * @param gmtUpdate     Database column gmt_update SqlType(TIMESTAMP) */
  case class TmResourceConfigRow(id: Int, lan: String, latestVersion: Int, gmtCreate: java.sql.Timestamp, gmtUpdate: java.sql.Timestamp)

  /** GetResult implicit for fetching TmResourceConfigRow objects using plain SQL queries */
  implicit def GetResultTmResourceConfigRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TmResourceConfigRow] = GR {
    prs => import prs._
      TmResourceConfigRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }

  /** Table description of table tm_resource_config. Objects of this class serve as prototypes for rows in queries. */
  class TmResourceConfig(_tableTag: Tag) extends profile.api.Table[TmResourceConfigRow](_tableTag, Some("i18n"), "tm_resource_config") {
    def * = (id, lan, latestVersion, gmtCreate, gmtUpdate) <> (TmResourceConfigRow.tupled, TmResourceConfigRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(lan), Rep.Some(latestVersion), Rep.Some(gmtCreate), Rep.Some(gmtUpdate)).shaped.<>({ r => import r._; _1.map(_ => TmResourceConfigRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column lan SqlType(VARCHAR), Length(16,true) */
    val lan: Rep[String] = column[String]("lan", O.Length(16, varying = true))
    /** Database column latest_version SqlType(INT) */
    val latestVersion: Rep[Int] = column[Int]("latest_version")
    /** Database column gmt_create SqlType(TIMESTAMP) */
    val gmtCreate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("gmt_create")
    /** Database column gmt_update SqlType(TIMESTAMP) */
    val gmtUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("gmt_update")

    /** Uniqueness Index over (lan) (database name idx_lan) */
    val index1 = index("idx_lan", lan, unique = true)
  }

  /** Collection-like TableQuery object for table TmResourceConfig */
  lazy val TmResourceConfig = new TableQuery(tag => new TmResourceConfig(tag))
}
