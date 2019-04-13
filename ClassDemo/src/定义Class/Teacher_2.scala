package 定义Class

/**
  * 构造器私有化
  * 成员私有化
  *
  * 在 class 前加个private 表示是在同一包下可以访问
  * 默认 private[this] 子包下也无法访问 但是可见  其他包不可见不能import
  *
  * 当定义Teacher_2 访问权限是：private [定义Class]
  * 定义Class 包下所有都可以访问
  */
private [定义Class]class Teacher_2 (private var name: String, age: Int) {
  private var sex: String = _

  private def this(name: String, age: Int, sex: String) {
    this(name, age)
    this.sex = sex
  }

}
