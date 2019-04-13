package Main

import Impl.AbstractImpl

object TestMain  extends App {
  private val impl = new AbstractImpl()
  println(  impl.eat("稀饭"))
  impl.swimming("狗刨")

}
