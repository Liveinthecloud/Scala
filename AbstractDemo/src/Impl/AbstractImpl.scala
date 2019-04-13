package Impl

import TestAbstract.AbstractClass

class AbstractImpl extends AbstractClass{
  override def eat(food: String): String = {
    "吃的是："+food
  }
}
