package 定义Class.Test

import 定义Class.Teacher_2

/**
  * 无法访问Teacher_2
  * Teacher_2 只可提供同一包下的访问权限
  *
  *
  * 当定义Teacher_2 访问权限是：private [定义Class]
  * 定义Class 包下所有都可以访问
  */
object Test extends App {
  new Teacher_2("x",14)

}
