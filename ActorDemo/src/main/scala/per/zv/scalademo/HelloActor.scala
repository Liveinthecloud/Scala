package per.zv.scalademo

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class HelloActor extends Actor{
  //接收消息
  override def receive: Receive = {
    case "你好帅" =>print("说的好")
    case "你好丑" =>print("滚")
    case "stop" =>
      context.stop(self)
      context.system.terminate()//关闭Actor
  }
}
object HelloActor {
  //工厂
  private val nBFactory = ActorSystem("NBFactory")
  private val helloactor: ActorRef = nBFactory.actorOf(Props[HelloActor],"helloactor")

  def main(args: Array[String]): Unit = {
    //给自己发送消息
  helloactor ! "你好帅"
  helloactor ! "你好丑"
  helloactor ! "stop"

  }

}
