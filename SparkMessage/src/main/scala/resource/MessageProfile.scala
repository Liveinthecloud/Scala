package resource

/**
  *worker -> master
  */
case class RegisterWorkerInfo(id:String ,core:Int ,ram:Int)//worker想master注册信息
case object SendHearBeat    //worker发送给自己的消息类型   周期性的（定时完成要向master发送心跳指示）
case class HearBeat(id:String)//worker给master发送心跳信息，携带自己的id


/**
  * master -> worker
  */
case object RegisteredWorkerInfo//worker注册成消息类型
case class WorkerInfo(var id:String,core:Int,ram:Int) { //master存储worker的类型
  var lastHearBeatTime:Long=_ //最近一次的心跳时间
}

/**
  * master -> master
  */
case object  CheckTimeOutWorker  //启动检查超时worker的信息类型
case object RemoveTimeOutWorker //启动删除超时worker的信息类型