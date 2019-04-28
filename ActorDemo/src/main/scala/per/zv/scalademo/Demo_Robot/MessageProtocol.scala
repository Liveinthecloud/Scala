package per.zv.scalademo.Demo_Robot

case class ServerMessage(msg:String)//服务端发送给客户端的消息类
case class ClientMessage(msg:String)//客户端发送给服务端的消息类
