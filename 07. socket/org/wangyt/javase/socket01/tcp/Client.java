package org.wangyt.javase.socket01.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端(也可以在浏览器输入http://127.0.0.1:8888/ 访问服务端)
 * 
 * 客户端会带着一个临时端口发送数据到服务端指定的端口，如果服务端有数据返回客户端就是通过这个临时端口
 * 
 * @author 王永涛
 * 
 * @since 2012-8-31 下午01:20:59
 * 
 * @version v1.0
 * 
 *          Copyright (c) 2012,WANG YONG TAO. All Rights Reserved.
 */
@SuppressWarnings("all")
public class Client {
  public static void main(String[] args)
      throws UnknownHostException, IOException, InterruptedException {

    /** 用ip地址和端口创建socket对象 */
    Socket c_socket = new Socket("localhost", 8888);

    /** 获得输入流 */
    InputStream is = c_socket.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));

    String msg = br.readLine();
    System.out.println(msg);
    Thread.sleep(60 * 1000);
  }
}
