package per.zv.scalademo.Demo_Robot

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

/**
  * 服务端，用来回答客户端
  */
class
RobotServer extends Actor {
  override def receive: Receive = {
    case "start" => println("启动成功！")
    case ClientMessage(msg) => {
      println(s"Client：$msg")
      msg match {
        case "你是谁" => sender() ! ServerMessage("RobotServer")
        case "你是男是女" => sender() ! ServerMessage("我是一个机器")
        case "你多大了" => sender() ! ServerMessage("1岁")
        case _ => sender() ! ServerMessage("？？？？？？")
      }
    }
  }
}

object RobotServer extends App {
  //指定IP和端口
  val host: String = "127.0.0.1"
  val port: Int = 4555
  private val config: Config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
    """.stripMargin)
  private val server = ActorSystem("Server", config)
  private val serverActorRef = server.actorOf(Props[RobotServer], "server_1")
  serverActorRef ! "start"
}
