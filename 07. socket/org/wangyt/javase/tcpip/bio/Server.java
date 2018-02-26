package org.wangyt.javase.tcpip.bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("all")
public class Server {

  public static void main(String[] args) throws IOException {

    ServerSocket s_socket = new ServerSocket(8888);
    Socket socket = null;

    // 循环监听来自客户端的请求，accept是一个阻塞方法，如果没有接收到请求，它会阻断虚拟机的继续执行。
    while ((socket = s_socket.accept()) != null) {

      System.out.println("receive request from client " + socket.getInetAddress());

      // 从socket上得到一个输出流
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      out.print("how are you.");
      out.close();
    }
  }

}
