
packageOptions <+= (name, version, organization) map { (title, version, vendor) =>
  Package.ManifestAttributes(
    "Created-By" -> "Simple Build Tool",
    "Built-By" -> System.getProperty("user.name"),
    "Build-Jdk" -> System.getProperty("java.version"),
    "Specification-Title" -> title,
    "Specification-Version" -> version,
    "Specification-Vendor" -> vendor,
    "Implementation-Title" -> title,
    "Implementation-Version" -> version,
    "Implementation-Vendor-Id" -> vendor,
    "Implementation-Vendor" -> vendor
  )
}

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

startYear := Some(2016)

licenses := Seq(("Apache 2", new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")))

publishMavenStyle := true

publishTo <<= version { v: String =>
  val nexusHost = "http://10.34.0.5:8081"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexusHost + "/nexus/content/repositories/snapshots")
  else
    Some("releases" at nexusHost + "/nexus/content/repositories/releases")
}

publishArtifact in Test := false
  
pomIncludeRepository := { _ => false }

overridePublishBothSettings