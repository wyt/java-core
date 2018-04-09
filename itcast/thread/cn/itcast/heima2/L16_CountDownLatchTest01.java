package cn.itcast.heima2;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 允许一个或多个线程等待其他线程完成操作,类似于join
 * 
 * @author wangyt
 *
 */
public class L16_CountDownLatchTest01 {
  /** 0. 计数器从2开始倒计时 **/
  static CountDownLatch counter = new CountDownLatch(2);

  public static void main(String[] args) throws InterruptedException {
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println(1);
        /** 2. 倒计时1下 **/
        counter.countDown();
        System.out.println(2);
        counter.countDown();
      }
    }).start();

    /** 1. 引起当前线程(main)等待，直到counter,倒计时到0，再继续执行。 **/
    counter.await();
    System.out.println("3");
  }
}
