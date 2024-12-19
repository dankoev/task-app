val scala3Version = "3.5.2"
val circeVersion = "0.14.10"

lazy val root = project
  .in(file("."))
  .settings(
    name := ".",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test

      libraryDependencies ++= Seq (
        "io.circe" %% "circe-core",
        "io.circe" %% "circe-generic",
        "io.circe" %% "circe-parser"
      ).map(_ % circeVersion)
  )
