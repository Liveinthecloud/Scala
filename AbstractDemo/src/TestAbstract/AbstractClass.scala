package TestAbstract

/**
  * 抽象类
  * 可以又具体实现的方法
  * 也可以又抽象方法
  * 可以用witch 拓展多个
  */
abstract class AbstractClass {
  def eat(food: String): String

  def swimming(style: String): Unit = {
    println(s"$style 方式游泳")
  }
}
