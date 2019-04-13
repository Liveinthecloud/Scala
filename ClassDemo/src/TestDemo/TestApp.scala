package TestDemo

import 定义Class.{Teacher, Teacher_1}

object TestApp extends App {
  private val teacher = new Teacher()
  teacher.age = 11
  teacher.name = "小明"
  println(teacher.toString)

  private val p2 = new Teacher_1("小红",15,"女")
  println(p2.toString)
  println(p2.sex)
  p2.name="小黄"
  println(p2.name)  //添加了 var 无法访问
  //println(p2.age) //未添加 var无法访问
  println(p2.toString)

}
