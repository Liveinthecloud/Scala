package 柯里化

object Currying {
  def add(a:Int,b:Int)=a+b

  /**解析：
    *     def add_1(a:Int)(b:Int)=a+b
    *     def add_1(a:Int)={
    *       (b:Int)=>a+b //Int => Int = b =>a+b
    *     }
    *
    */
  def add_1(a:Int)(b:Int)=a+b


  def main(args: Array[String]): Unit = {
    println(add(4,5))
    println(add_1(4)(5))
  }
}
