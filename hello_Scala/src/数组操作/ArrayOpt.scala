package 数组操作

object ArrayOpt {
  def main(args: Array[String]): Unit = {
    val arr =Array(1,2,5,6,7,8,9,10)
    //map映射
    val fun:Int =>Int=x=>x*10
    val array_1 = arr.map(fun)
    println(array_1.toBuffer)
    //简写
    val array_2 = arr.map(_ * 2)
    println(array_2.toBuffer)
    //数据扁平化
    val arr_1=Array("hello make kangkang jane","hello chongqing beijing shanghai")
    val stringses = arr_1.map(_.split(" "))
    println(stringses(0).toBuffer,stringses(1).toBuffer)
    val flatten = stringses.flatten//扁平化
    println(flatten.toBuffer)
    //快速实现扁平化
    val strings = arr_1.flatMap(_.split(" "))
    println(strings.toBuffer)

    //foreach
    arr_1.flatMap(_.split(" ")).foreach(println)
    //groupBy
    arr_1.flatMap(_.split(" ")).groupBy(x=>x).map(x=>x._2)
    arr_1.flatMap(_.split(" ")).groupBy(x=>x).mapValues(_.length).foreach(println)
    arr_1.flatMap(_.split(" ")).groupBy(x=>x).mapValues(_.length).toList.sortBy(x => - x._2).foreach(println)

  }

}
