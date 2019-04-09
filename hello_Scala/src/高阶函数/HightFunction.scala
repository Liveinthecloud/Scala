package 高阶函数

object HightFunction {
  //定义一个方法，返回值是一个函数
  def apply (a:Int)=(b:Int)=>a*b
  //解析
  def app(a:Int)={
    val fun=(b:Int)=>{
      b*a
    }
    fun
  }

  def apply_2 (f:Int=>String,a:Int)=f(a)

  //定义符合 apply 参数的方法
  def layout(x:Int)={
    "["+x.toString+"]"
  }
  //定义符合 apply 参数的函数
  val layout_2:Int=>String=str=>"["+str.toString+"]"

  def main(args: Array[String]): Unit = {
    val fun= apply(10)
    println(fun(2))

    println(apply_2(layout,10))
  }

}
