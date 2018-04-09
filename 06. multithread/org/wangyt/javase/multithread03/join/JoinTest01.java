package org.wangyt.javase.multithread03.join;

/**
 * join造成死锁的例子
 * 
 * @author WANG YONG TAO
 *
 */
public class JoinTest01 extends Thread {

  public JoinTest01(String name) {
    super(name);
  }

  public static void main(String[] args) {
    new JoinTest01("Thread0").start();
    System.out.println("for cycle is over.");
  }

  @Override
  public void run() {
    try {
      // 这样写是会死锁的，因为Thread0线程在等待自己结束。
      this.join();
      System.out.println("aaa");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " be runing!");
  }
}
