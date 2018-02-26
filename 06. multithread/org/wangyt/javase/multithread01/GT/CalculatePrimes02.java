package org.wangyt.javase.multithread01.GT;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用两个线程，一个用于计时(线程会休眠10秒然后设置一个主线程要检查的标志finished)，
 * 
 * 一个用于执行实际工作。在执行实际工作的线程启动之前，启动计时线程。达到10秒钟主线程将停止。
 * 
 * @author wangyt
 *
 */
public class CalculatePrimes02 extends Thread {

   public static final int SECONDS = 5000;
   public volatile boolean finished = false;

   public void run() {
      System.out.println("开始执行实际工作啦");
      for (long i = 0l; i < Long.MAX_VALUE; i++) {
         if (finished) {
            break;
         }
         if (i % 100000000 == 0) {
            System.out.println("i:" + i);
         }
      }
      System.out.println("结束执行实际工作啦");
   }

   public static void main(String[] args) {
      final CalculatePrimes02 calculator = new CalculatePrimes02();
      calculator.start();

      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
         public void run() {
            calculator.finished = true;
         }
      }, SECONDS);
   }
}
