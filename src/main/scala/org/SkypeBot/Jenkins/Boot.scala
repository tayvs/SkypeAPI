package org.SkypeBot.Jenkins

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import scala.io.StdIn
import scala.util.{Failure, Success}

object Boot extends App {
  
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher
  
  val route =
    path("hello") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    } ~ path("/") {
      post {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, """{text: "post earned"}"""))
      }
    }
  
  val bindingFuture = Http().bindAndHandle(route, Config.AppConfig.interface, Config.AppConfig.port)
    .andThen {
      case Success(_) => println("Bind Successfully")
      case Failure(ex) =>
        println("Bind Failed")
        ex.printStackTrace()
    }
  
  println(s"Server online at http://${Config.AppConfig.interface}:${Config.AppConfig.port}/\nPress RETURN to stop...")
//  StdIn.readLine() // let it run until user presses return
//  bindingFuture
//    .flatMap(_.unbind()) // trigger unbinding from the port
//    .onComplete(_ => system.terminate()) // and shutdown when done
  
}
