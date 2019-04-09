package 基本语法

object ScalaFunction {
  var money = 100

  //自减5
  def subMoney(): Unit = {
    money -= 5
  }

  def priMoney(): Int = {
    subMoney
    money
  }

  //方法
  def printByValue(x: Int) = {
    for (a <- 0 until 3) {
      println(s"${x}")
    }
  }

  //x: => Int   无参数  返回值是Int的一个方法
  def printByName(x: => Int) = {
    for (a <- 0 to 3) {
      println(s"${x}")//隐式的吧方法转换为函数
    }
  }

  /**
    *函数的创建
    */

  val f=(a:Int,b:Int)=>a+b

  val f2:(Int,Int) => Int =(a,b)=>a+b

  def main(args: Array[String]): Unit = {
    //传值调用
    printByValue(priMoney())
    //传名调用
    printByName(priMoney())
  }
}
