package org.wangyt.javase.multithread05.lock;

/**
 * 多线程死锁演示
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-8-30 下午06:19:21
 * 
 */
public class DeadLock implements Runnable {

  A a = new A();
  B b = new B();

  public void init() {
    // Thread.currentThread().setName("主线程");
    Thread.currentThread().setName(Thread.currentThread().getName());
    /**
     * foo 是同步方法，用的是对象 a 的锁。
     */
    a.foo(b);
    // System.out.println("进入了主线程之后");
  }

  @Override
  public void run() {
    // Thread.currentThread().setName("副线程");
    Thread.currentThread().setName(Thread.currentThread().getName());
    /**
     * bar 是同步方法，用的是对象 b 的锁。
     */
    b.bar(a);
    // System.out.println("进入了副线程之后");
  }

  public static void main(String[] args) {
    DeadLock dl = new DeadLock();
    new Thread(dl).start();

    // main线程中执行的
    dl.init();
  }

}
