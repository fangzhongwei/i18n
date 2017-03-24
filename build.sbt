lazy val commonSettings = Seq(
  javacOptions ++= Seq("-encoding", "UTF-8"),
  organization := "com.jxjxgo.i18n",
  version := "1.1",
  scalaVersion := "2.12.1",
  libraryDependencies ++= Seq(
    "net.codingwell" % "scala-guice_2.12" % "4.1.0",
    "com.jxjxgo.common" % "common-finagle-thrift_2.12" % "1.1"
  )
)

lazy val i18ncommonlib = (project in file("i18ncommonlib")).settings(commonSettings: _*).settings(
  name := """i18ncommonlib""",
  libraryDependencies ++= Seq(
  )
)

lazy val i18nserver = (project in file("i18nserver")).settings(commonSettings: _*).settings(
  name := """i18nserver""",
  mainClass in (Compile, run) := Some("com.jxjxgo.i18n.rpc.RpcService"),
  libraryDependencies ++= Seq(
    "com.jxjxgo.i18n" % "i18ncommonlib_2.12" % "1.1",
    "com.jxjxgo.common" % "common-utils_2.12" % "1.1",
    "com.jxjxgo.common" % "common-error_2.12" % "1.1",
    "com.jxjxgo.common" % "common-db_2.12" % "1.1"
  )
)