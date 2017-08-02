/**
  * This file contains options for building rpm package
  *
  * @note Make sure that build machine has installed rpm-build tools
  * @note Otherwise install it before running
  * @usecase CentOS 7. Under root or sudo type the following <code>yum install rpm-build</code>
  */
import com.typesafe.sbt.packager.archetypes.ServerLoader
enablePlugins(JavaServerAppPackaging)
enablePlugins(RpmPlugin)
enablePlugins(RpmDeployPlugin)

rpmVendor := "org.emis.service"
rpmLicense := Some("Apache 2")
rpmRelease := "1"
packageName in Rpm := normalizedName.value
packageArchitecture in Rpm := "x86_64"
packageSummary := "E-mail campaign creation service"
packageDescription := "This package contains e-mail campaign creation service with dependencies and configuration"
rpmBrpJavaRepackJars := false
daemonUser in Linux := "jenkins"
daemonGroup in Linux := "jenkins"
serverLoading := ServerLoader.Systemd

mappings in Universal <++= (packageBin in Compile, sourceDirectory) map { (_, src) =>
  val confApp = src / "main" / "resources" / "application.conf"
  val confLog = src / "main" / "resources" / "logback.xml"
  Seq(confApp -> "conf/application.conf", confLog -> "conf/logback.xml")
}

bashScriptExtraDefines ++= Seq(
  """addJava "-Dconfig.file=${app_home}/../conf/application.conf"""",
  """addJava "-Dlogback.configurationFile=${app_home}/../conf/logback.xml""""
)

pomIncludeRepository := { _ => false }
publishMavenStyle := true
publishArtifact in Test := false

publishTo <<= version { v: String =>
  val nexusHost = "http://10.34.0.5:8081"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexusHost + "/nexus/content/repositories/snapshots")
  else
    Some("releases" at nexusHost + "/nexus/content/repositories/releases")
}