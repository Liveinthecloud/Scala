package 基本语法

object Calculate {
  //函数
  val fun=(a:Int,b:Int)=>a+b
  //方法
  def add(a: Int, b: Int) = {
    a + b
  }

  def add2(f: (Int, Int) => Int, a: Int, b: Int) = {
    println(f(a, b))
  }

  def main(args: Array[String]): Unit = {
    val f1 = add(1, 2)
    add2(fun, 3, 4)
  }

}
