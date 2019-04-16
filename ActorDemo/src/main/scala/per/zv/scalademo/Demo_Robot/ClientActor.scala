package per.zv.scalademo.Demo_Robot

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

import scala.io.StdIn

class ClientActor extends Actor {
  var serverActorRef: ActorSelection = _

  //在启动前先执行该方法
  override def preStart(): Unit = {
    serverActorRef = context.actorSelection("akka.tcp://Server@127.0.0.1:4555/user/server_1")
  }

  override def receive: Receive = {
    case "start" => println("Client_1 启动成功")
    case msg: String => {
      serverActorRef ! ClientMessage(msg)
    }
    case ServerMessage(msg) => {
      println(s"Server:$msg")
    }
  }
}

object ClientActor extends App {
  val host: String = "127.0.0.1"
  val port: Int = 4556
  private val config: Config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
    """.stripMargin)
  private val client = ActorSystem("Client", config)
  private val actorRef = client.actorOf(Props[ClientActor], "client_1")
  actorRef ! "start"
  while (true) {
    val str = StdIn.readLine()
    actorRef ! str
  }
}