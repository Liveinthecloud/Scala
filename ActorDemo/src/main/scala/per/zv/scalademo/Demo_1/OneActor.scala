package per.zv.scalademo.Demo_1

import akka.actor.{Actor, ActorRef}

/**
  * 模拟两个actor通讯
  */
class OneActor(per: ActorRef) extends Actor{
  override def receive: Receive = {
    case "start" =>
      println("One:我准备好了!")
      per ! "发球"
    case "ping" =>
      println("One:ping")
      Thread.sleep(2000)
      per ! "pong"

  }
}
