lazy val commonSettings = Seq(
  javacOptions ++= Seq("-encoding", "UTF-8"),
  organization := "com.jxjxgo.i18n",
  version := "1.0",
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
    "net.codingwell" % "scala-guice_2.11" % "4.1.0",
    "org.scala-lang" % "scala-library" % "2.11.8",
    "com.jxjxgo.common" % "common-finagle-thrift_2.11" % "1.0"
  )
)

lazy val i18ncommonlib = (project in file("i18ncommonlib")).settings(commonSettings: _*).settings(
  name := """i18ncommonlib""",
  libraryDependencies ++= Seq(
  )
)

lazy val i18nserver = (project in file("i18nserver")).settings(commonSettings: _*).settings(
  name := """i18nserver""",
  libraryDependencies ++= Seq(
    "com.jxjxgo.i18n" % "i18ncommonlib_2.11" % "1.0",
    "com.jxjxgo.common" % "common-utils_2.11" % "1.0",
    "com.jxjxgo.common" % "common-error_2.11" % "1.0",
    "com.jxjxgo.common" % "common-db_2.11" % "1.0"
  )
)