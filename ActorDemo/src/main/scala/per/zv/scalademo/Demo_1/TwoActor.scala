package per.zv.scalademo.Demo_1

import akka.actor.Actor

class TwoActor extends Actor{
  override def receive: Receive = {
    case "start" =>println("Two:OK!")
    case "发球" =>{
      sender() ! "ping"
    }
    case "pong" =>
      println("Two:pong")
      Thread.sleep(2000)
      sender() ! "ping"
  }
}
