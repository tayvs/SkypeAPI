name := "SkypeAPI"

scalaVersion := "2.12.1"

libraryDependencies ++= {
  Seq(
    "org.scalaj" %% "scalaj-http" % "2.3.0",
    "com.typesafe.akka" %% "akka-http" % "10.0.9",
    "com.github.fomkin" %% "pushka-json" % "0.8.0"
  )
}


assemblyJarName in assembly := s"${normalizedName.value}.jar"
assemblyMergeStrategy in assembly := {
  case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
  case "index.js" => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

mainClass in assembly := Some("org.SkypeBot.Jenkins.Boot")
mainClass in Compile := Some("org.SkypeBot.Jenkins.Boot")
test in assembly := {}