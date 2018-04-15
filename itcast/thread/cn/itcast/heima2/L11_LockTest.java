package cn.itcast.heima2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程锁 Lock的使用
 * 
 * @author wangyt
 *
 */
public class L11_LockTest {

  public static void main(String[] args) {
    new L11_LockTest().init();
  }

  private void init() {

    final Outputer outputer = new Outputer();

    new Thread(() -> {
      while (true) {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        outputer.output("zhangxiaoxiang");
      }
    }).start();

    new Thread(() -> {
      while (true) {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        outputer.output("lihuoming");
      }
    }).start();

  }

  static class Outputer {

    // 使用重入锁
    Lock lock = new ReentrantLock();

    public void output(String name) {
      int len = name.length();
      lock.lock();
      try {
        for (int i = 0; i < len; i++) {
          System.out.print(name.charAt(i));
        }
        System.out.println();
      } finally {
        lock.unlock();
      }
    }

    public synchronized void output2(String name) {
      int len = name.length();
      for (int i = 0; i < len; i++) {
        System.out.print(name.charAt(i));
      }
      System.out.println();
    }

    public static synchronized void output3(String name) {
      int len = name.length();
      for (int i = 0; i < len; i++) {
        System.out.print(name.charAt(i));
      }
      System.out.println();
    }
  }

}
