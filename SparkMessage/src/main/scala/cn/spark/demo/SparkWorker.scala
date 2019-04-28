package cn.spark.demo

import java.text.SimpleDateFormat
import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import resource.{HearBeat, RegisterWorkerInfo, RegisteredWorkerInfo, SendHearBeat}

import scala.concurrent.duration._

class SparkWorker(masterURL: String) extends Actor {
  //生成一个id
  val workerid: String = UUID.randomUUID().toString
  var masterProxy: ActorSelection = _

  //获取master的代理对象
  override def preStart(): Unit = {
    masterProxy = context.actorSelection(masterURL)
  }

  override def receive: Receive = {
    //启动成功
    case "started" => {
      println("启动成功")
      //worker向master注册自己的信息 id core memory
      masterProxy ! RegisterWorkerInfo(workerid, 2, 2048)
      masterProxy ! "我来了"
    }
    //master发送给自己注册成功的消息
    case RegisteredWorkerInfo => {
      import context.dispatcher //使用调度器必须导入的类
      //worker启动一个定时器，定时想master发送心跳
      context.system.scheduler.schedule(0 millis, 1500 millis, self, SendHearBeat)
    }
    case SendHearBeat => {
      //向master发送心跳
      masterProxy ! HearBeat(workerid)
      println(  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())
                + s"  $workerid: 向Master发送心跳")
    }
  }
}

object SparkWorker {
  def main(args: Array[String]): Unit = {
    //校验参数
    if (args.length != 4) {
      println(
        """
          |请输入参数：<host> <port> <workerName> <masterURL>
        """.stripMargin)
      sys.exit() //参数不合格推出程序
    }

    val host = args(0) //获取ip
    val port = args(1) //获取端口
    val workerName = args(2)
    val masterURL = args(3) //master的ip 和port等


    //Actor工厂的配置属性
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=$host
         |akka.remote.netty.tcp.port=$port
      """.stripMargin)
    //获取工厂实例
    val worker = ActorSystem("Worker", config)
    //创建一个SparkWorker的代理对象 ActorRef
    val workerRef = worker.actorOf(Props(new SparkWorker(masterURL)), workerName)
    //给自己发送启动命令
    workerRef ! "started"
  }
}