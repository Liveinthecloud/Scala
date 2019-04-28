package FileDemo

import java.io.{BufferedReader, File, FileReader}


class RichFile(file:File){
  def conutLine():Int={
    var linecount = 0
    val fileReader = new FileReader(file)
    val bufferedReader = new BufferedReader(fileReader)
    try {
      while ((bufferedReader.readLine()) != null) {
        linecount += 1
      }
    } catch {
      case _:Exception => linecount
    }finally {
      if (fileReader!=null){
        fileReader.close()
      }
      if(bufferedReader!=null){
        bufferedReader.close()
      }
    }
    linecount
  }
}



object FileLineCount {
  //隐式转换 把flie隐式的转换成RichFile
  implicit def fileToRichFile(file:File)=new RichFile(file)

  def main(args: Array[String]): Unit = {
    val file=new File("C:\\WiFi_Log.txt")
    println(file.conutLine())
  }
}
