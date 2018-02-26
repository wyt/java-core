package org.wangyt.javase.multithread01.GT;

/**
 * 使用两个线程，一个用于计时(线程会休眠20秒然后设置一个主线程要检查的标志finished)，
 * 
 * 一个用于执行实际工作。在执行实际工作的线程启动前启动计时线程。 达到20秒钟主线程将停止。
 * 
 * @author wangyt
 *
 */
public class CalculatePrimes01 extends Thread {

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
      CalculatePrimes01 calculator = new CalculatePrimes01();
      calculator.start();
      
      try {
         System.out.println("执行Thread.sleep前，时间为：" + System.currentTimeMillis());
         Thread.sleep(SECONDS);
         System.out.println("执行Thread.sleep后，时间为：" + System.currentTimeMillis());
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      calculator.finished = true;
      System.out.println("执行完main()");
   }
}
