object ScalaVarVal {
  def main(args: Array[String]): Unit = {
    /*
    变量的定义
    var修饰的变量可以更改
    val修饰的变量不可以改变

    var /arl  变量名：数据类型 = 赋值

    Unit 数据类型相当于Java的void   但它的表现形式是一对括号
    */

    //格式化输出9

    val name ="xiaoming"
    var age=18
    println("name:"+name,"age"+age)
    println("name:"+name+"  age"+age)
    println(f"name:$name  age:$age")
    printf("name:%s, age:%d",name,age)
  }

}
