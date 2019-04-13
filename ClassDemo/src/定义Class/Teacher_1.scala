package 定义Class

/**
  * 主构造器
  * 主构造器内的参数会自动在类中生成成员变量
  *
  * 主构造生成的变量默认对外放过是关闭的 但在主构造方法参数前加个  var 可以修改对外访问权限
  * var 提供了 get 和  set  方法
  * val 提供了 get 方法
  * @param name
  * @param age
  */
class Teacher_1 (var name:String,age:Int) {
  //var name:String=_   会出错   主构造器会自动生成 name这个成员变量
  var sex:String=_
  /**
    * 辅助构造器
    */
  def this(name:String,age:Int,sex:String)={
    this(name,age)//必须调用主构造器
    this.sex=sex
  }

  override def toString: String = name+"\t"+age+"\t"+sex
}
