package 参数

object DefaultParams {
  /**
    * 默认参数设置
    * @param a
    * @param b
    * @return
    */
  def add(a:Int =6,b:Int =7)={
    a+b
  }
  def main(args: Array[String]): Unit = {
    println("默认参数"+add())
    println("给的参数"+add(42,55))
    println("一个参数"+add(55))
    println("指定覆盖参数"+add(b=55))
    //    println("给的参数"+add(c=55)) c 是无法识别的参数名
  }
}
