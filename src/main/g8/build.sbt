name := """$name$"""
organization := "$organization$"
version := "1.0.0-SNAPSHOT"
scalaVersion := "$scala_version$"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(Javascript.buildUiSettings)

libraryDependencies ++= Seq(
  ws,
  cache,
  filters,
  "com.github.etaty" %% "rediscala" % "1.8.0",
  "org.reactivecouchbase" %% "good-old-play-framework" % "1.0.2",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers += "bintray" at "http://jcenter.bintray.com"
resolvers += "good-old-play-framework repository" at "https://raw.githubusercontent.com/mathieuancelin/good-old-play-framework/master/repository/releases"
resolvers += "reactivecouchbase-repo" at "https://raw.github.com/ReactiveCouchbase/repository/master/snapshots/"

PlayKeys.devSettings := Seq("play.server.http.port" -> "$scala_port$")
routesGenerator := StaticRoutesGenerator
sources in (Compile, doc) := Seq.empty
publishArtifact in (Compile, packageDoc) := false
