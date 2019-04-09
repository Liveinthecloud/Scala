package 基本语法

object ScalaDef {
  class Count{
    //方法
    def add(a:Int,b:Int)={
      a+b
    }
    def sayHello =println("hello")
  }

  def main(args: Array[String]): Unit = {
    println(new Count().add(1,5))
    new Count().sayHello
  }
}
