package per.zv.scalademo.Demo_1

import akka.actor.{ActorRef, ActorSystem, Props}

object App extends App {
  //创建工厂
  private val pingPongActor = ActorSystem("PingPongActor")
  //通过ActorSystem创建ActorRef
  private val two: ActorRef = pingPongActor.actorOf(Props[TwoActor],"Two")
  //通过ActorSystem创建ActorRef 并传入Two的ActorRef
  private val one: ActorRef = pingPongActor.actorOf(Props(new OneActor(two)),"One")

  two ! "start"
  one ! "start"
}
