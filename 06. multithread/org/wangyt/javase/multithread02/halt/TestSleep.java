package org.wangyt.javase.multithread02.halt;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 线程睡眠1s.
 * 
 * @author 王永涛
 * 
 * @since 2012-8-30 下午05:23:48
 * 
 */
public class TestSleep {
  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      System.out.println("当前时间: " + new Date());
      TimeUnit.MILLISECONDS.sleep(1000); // Thread.sleep(1000);
    }
  }
}
