package 基本语法

object ScalaFor {
  def main(args: Array[String]): Unit = {
    for(i <- 1 to 9 ;j<- i to 9){
      print(i+"*"+j+"="+i*j+"\t")
      if(j==9)println()
    }
  }

}
