package FialTest

trait Person {
  final var id:Int=11
  var  age:Int=_
  final def eat(food:String): Unit ={
    println(s"吃的是：$food")
  }
  def color(c:String)
}
