package 参数

object ManyParams {
  def add(ints:Int*)  ={
    var sum=0
    for (v <-ints){
      sum+=v
    }
    sum
  }
  def sub(int:Int,o:Int*){}
  //def subb(o:Int*,int:Int){}
  //def subb(o:String*,int:Int){}

  def main(args: Array[String]): Unit = {
    println(add(1,5,3,5,5))
    println(add(1,56,6))
  }
}
