object ScalaYield {
  def main(args: Array[String]): Unit = {
    val arr=Array(1,2,3,4,5,6,7,8,9)
    val temp=for(i <- arr if i%2==0) yield  i
    for (i<-temp ) print(i+"\t")
  }

}
