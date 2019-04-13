package Test

import TraitTest._

object Test extends ScalaTrait {
  override def hello(name: String): Unit = {
    println(s"hello $name")
  }

  override def hello_1(name: String): Unit = super.hello_1(name)//可以重新

  def main(args: Array[String]): Unit = {
    Test.hello("小明")
    Test.hello_1("小红")
    //动态混入特质
    val impl = new TraitImpl with ScalaTrait_1
    impl.fly("小东")

  }
}
