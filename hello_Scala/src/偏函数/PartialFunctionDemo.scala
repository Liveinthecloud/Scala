package 偏函数

object PartialFunctionDemo {
  //String 为参数  Int 为返回值
  def fun1: PartialFunction[String, Int] = {
    case "one" => 1
    case "two" => 2
    case _ => 0
  }
  def fun2:PartialFunction[Int,Int]={
    case i:Int=>i*10
  }
  def main(args: Array[String]): Unit = {
    println(fun1("one"))
    val arr=Array(1,2,3)
    val arr2 = arr.collect(fun2)
    println(arr2.toBuffer)
  }
}
