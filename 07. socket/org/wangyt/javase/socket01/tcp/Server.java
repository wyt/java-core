package org.wangyt.javase.socket01.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 向客户端输出服务器端的时间,可配合Process Explorer 查看工具,查看启动的jvm.
 * 
 * @author 王永涛
 * 
 * @since 2012-8-31 下午01:20:51
 * 
 * @version v1.0
 * 
 *          Copyright (c) 2012, WANG YONG TAO. All Rights Reserved.
 */
@SuppressWarnings("all")
public class Server extends Thread {

  private static ServerSocket s_socket = null;
  private static Socket socket = null;

  public static void main(String[] args) throws IOException {

    s_socket = new ServerSocket(8888);
    System.out.println("the server has started.");

    // 循环监听来自客户端的请求，accept是一个阻塞方法，如果没有接收到请求，它会阻断虚拟机的继续执行。
    while ((socket = s_socket.accept()) != null) {
      System.out.println("receive request from client " + socket.getInetAddress());
      new Server().start();
    }

    s_socket.close();
  }

  @Override
  public void run() {
    try {
      // 从socket上得到一个输出流
      OutputStream os = socket.getOutputStream();
      PrintWriter pw = new PrintWriter(os);

      pw.print("now server time is " + new Date().toLocaleString());
      pw.flush();
      pw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
