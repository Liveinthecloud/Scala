package cn.spark.demo

import scala.concurrent.duration._
import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import resource.{CheckTimeOutWorker, HearBeat, RegisterWorkerInfo, RegisteredWorkerInfo, RemoveTimeOutWorker, WorkerInfo}

class SparkMaster extends Actor {
  //存储注册worker的HashMap
  val idWorkerInfo = collection.mutable.HashMap[String, WorkerInfo]()

  override def receive: Receive = {
    case "我来了" => {
      println("你找到了我")
    }

    //接收Worker发送来的消息
    case RegisterWorkerInfo(workID, core, ram) => {
      //存储worker的信息
      if (!idWorkerInfo.contains(workID)) {
        val info = new WorkerInfo(workID, core, ram)
        idWorkerInfo += ((workID, info))
        //注册成功 返回消息给worker
        sender() ! RegisteredWorkerInfo
      }
    }

    //master 收到worker的心跳信息
    case HearBeat(msg: String) => {
      val info = idWorkerInfo(msg)
      val currentTime = System.currentTimeMillis() //获取接收到心跳的时间
      info.lastHearBeatTime = currentTime
    }
    //周期性的启动RemoveTimeOutWorker
    case CheckTimeOutWorker => {
      import context.dispatcher
      context.system.scheduler.schedule(0 millis, 6000 millis, self, RemoveTimeOutWorker)
    }

    //删除心跳超时的worke  当lastHearBeatTime与currentTime相差3000判断worker死亡
    case RemoveTimeOutWorker => {
      val currentTime = System.currentTimeMillis() //获取当前时间
      val workerInfos = idWorkerInfo.values
      workerInfos
        .filter(wkInfo => currentTime - wkInfo.lastHearBeatTime > 3000) //过滤超时worker
        .foreach(wk => idWorkerInfo.remove(wk.id)) //通过超时id删除worker

      println(s"剩余 ${idWorkerInfo.size} Worker ")
    }
  }
}

object SparkMaster {
  def main(args: Array[String]): Unit = {
    //校验参数
    if (args.length != 3) {
      println(
        """
          |请输入参数：<host> <port>
        """.stripMargin)
      sys.exit() //参数不合格推出程序
    }

    val host = args(0) //获取ip
    val port = args(1) //获取端口
    val masterName = args(2)
    //Actor工厂的配置属性
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=$host
         |akka.remote.netty.tcp.port=$port
      """.stripMargin)
    //获取工厂实例
    val worker = ActorSystem("Master", config)
    val masterRef = worker.actorOf(Props[SparkMaster], masterName)

    //给自己发送一个消息，启动一个调度器，定期去检查HashMap中的worker的情况
    masterRef ! CheckTimeOutWorker
  }

}