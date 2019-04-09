package 部分参数函数

import java.util.Date

object PartParamFunction {
  def log(data: Date, message: String) = {
    println(s"$data,$message")
  }

  val date = new Date()
  //log方法中之传入了一个参数
  val logBoundData: String => Unit = log(date, _: String)

  def main(args: Array[String]): Unit = {
    logBoundData("你好！")
  }
}
