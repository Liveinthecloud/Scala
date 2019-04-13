package FialTest

class Student extends Person {
  val name:String= ""


  override def color(c: String):Unit ={
    println(s"$c")

  }

  final def say(talk:String): Unit ={
    println(s"$talk")
  }
  /*无法重写
  def eat(food:String): Unit ={
    println(s"吃的是：$food")
  }
  */

}
