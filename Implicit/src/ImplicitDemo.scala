import java.io.File

import scala.io.Source



/**
  * 隐式转换
  *
  *   隐式参数
  *   隐式的类型转换
  *   隐式类
  */
object ImplicitDemo {

  /*隐式参数*/
  def say(content:String)=println(content)
  def say_1(implicit content:String)=println(content)
  def add(a:Int)(implicit b:Int)=a+b

  /*隐式的类型转换*/
  implicit def double2Int(double: Double)=double.toInt
  implicit val double2Int_1=(double:Double)=>double.toInt

/*隐式类*/
  implicit class FileRead(file:File){
  def read = Source.fromFile(file)("GBK").mkString
}
  def main(args: Array[String]): Unit = {

    implicit val content="你好帅啊" //隐式参数
    say("你好啊")
    //say() 错误没有参数
    say_1 //未指定参数  编译器在编译的时候会自动的在上下代码中找一个隐式值（符合方法参数的隐式值）
    say_1("我是谁？")


    implicit val num=12
    println(add(12))
    println(add(12)(20))

    //隐式类型转换
    /**
      * age 是一个Int但是赋值一个Double类型的参数没报错
      * 应为它会去找是否有一个满足把浮点型改变成整数型的隐式方法或隐式函数(优先找函数)
      */
  //  val age:Int=22.5
    //println(age)
    val file=new File("C:\\WiFi_Log.txt")
    println(s"FileContent=${file.read}")
  }
}
