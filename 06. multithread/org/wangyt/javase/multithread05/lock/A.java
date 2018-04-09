package org.wangyt.javase.multithread05.lock;

/**
 * @author WANG YONG TAO
 * 
 * @since 2012-8-30 下午06:20:03
 * 
 */
public class A {

  public synchronized void foo(B b) {
    System.out.println(Thread.currentThread().getName() + ",进入了A实例的foo(B)方法");
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + ",企图调用B实例的last方法");
    b.last();
  }

  public synchronized void last() {
    System.out.println("进入了A类的last方法内部");
  }

}
