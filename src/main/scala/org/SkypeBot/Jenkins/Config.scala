package org.SkypeBot.Jenkins

import com.typesafe.config.ConfigFactory

object Config {
  
  private val configApp = ConfigFactory.load().getConfig("app")
  
  object AppConfig {
    val port = configApp.getInt("port")
    val interface = configApp.getString("interface")
  }
  
}
