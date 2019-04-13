package Test

import TraitTest.ScalaTrait

class TraitImpl extends ScalaTrait {
  override def hello(name: String): Unit = {
    println(s"$name  我是TraitImpl")
  }
}
