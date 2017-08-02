name := "SkypeAPI"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= {
  Seq(
    "org.scalaj" %% "scalaj-http" % "2.3.0",
    "com.typesafe.akka" %% "akka-http" % "10.0.9"
  )
}