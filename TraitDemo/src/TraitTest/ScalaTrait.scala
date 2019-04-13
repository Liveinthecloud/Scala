package TraitTest

/**
  * 类似java中的interface
  * 区别：
  * 1.用 extends实现trait
  * 2.trait 中方法可以实现，也可以不实现
  * 3.动态混入性 用 with连接 可以多个
  */
trait ScalaTrait {
  def hello(name:String)
  def hello_1(name:String): Unit ={
    println(s"$name 你好")
  }
}
