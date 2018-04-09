package org.wangyt.javase.multithread09.pause;

/**
 * synchronized的实例方法是用当前类实例的锁
 * 
 * @author WANG YONG TAO
 *
 */
class Common {
  public synchronized void synchronizedMethod1() {
    System.out.println("synchronizedMethod1 called");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("synchronizedMethod1 done");
  }

  public synchronized void synchronizedMethod2() {
    System.out.println("synchronizedMethod2 called");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("synchronizedMethod2 done");
  }
}


public class MyThread02 extends Thread {
  private int id = 0;
  private Common common;

  public MyThread02(String name, int no, Common object) {
    super(name);
    common = object;
    id = no;
  }

  public void run() {
    System.out.println("Running Thread" + this.getName());
    try {
      if (id == 0) {
        common.synchronizedMethod1();
      } else {
        common.synchronizedMethod2();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Common c = new Common();
    /** 多个线程调用同一个实实例的多个实例同步方法，因为只有一个锁，会造成阻塞。 **/
    MyThread02 t1 = new MyThread02("MyThread-1", 0, c);
    MyThread02 t2 = new MyThread02("MyThread-2", 1, c);
    t1.start();
    t2.start();
  }
}
