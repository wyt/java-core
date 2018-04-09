package org.wangyt.javase.multithread02.halt;

/**
 * yield只是让当前线程暂停一下，让系统的线程调度器重新调度一次，完全可能的情况是：
 * 
 * 当某个线程调用了yield方法暂停后，线程调度器又将其调度出来重新执行。
 * 
 * 在某些计算机环境下，yield产生的结果的比较随机。
 * 
 * @author 王永涛
 * 
 * @since 2012-8-30 下午05:45:15
 * 
 */
public class TestYield extends Thread {

  public TestYield() {}

  public TestYield(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(getName() + "\t" + i);
      if (i == 20) {
        Thread.yield();
      }
    }
  }

  public static void main(String[] args) {
    Thread t1 = new TestYield("high-thread");
    Thread t2 = new TestYield("low-thread");
    t1.setPriority(Thread.NORM_PRIORITY);
    t2.setPriority(Thread.NORM_PRIORITY);
    t1.start();
    t2.start();
  }
}
