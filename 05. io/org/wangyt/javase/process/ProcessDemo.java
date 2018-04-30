package org.wangyt.javase.process;

import java.io.InputStream;

public class ProcessDemo {

  public static void main(String[] args) {
    try {
      // create a new process
      System.out.println("Creating Process...");
//      Process p = Runtime.getRuntime().exec("ping  127.0.0.1");
      Process p = Runtime.getRuntime().exec("notepad.exe");

      // get the input stream of the process and print it
      InputStream in = p.getInputStream();
      for (int i = 0; i < in.available(); i++) {
        System.out.println("" + in.read());
      }
      // wait for 10 seconds and then destroy the process
      System.out.println("等待10s...");
      Thread.sleep(10000);
      System.out.println("等待结束");
      // p.destroy();
      System.out.println("等待子进程结束...");
      p.waitFor();
      System.out.println("子进程结束");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
