package org.wangyt.javase.tcpip.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

@SuppressWarnings("all")
public class Client {

  public static void main(String[] args)
      throws UnknownHostException, IOException, InterruptedException {

    Socket socket = new Socket("localhost", 8888);

    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    String msg = in.readLine();
    System.out.println(msg);
    Thread.sleep(60 * 1000);
  }
}
