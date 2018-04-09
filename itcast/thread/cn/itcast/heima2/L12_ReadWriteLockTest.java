package cn.itcast.heima2;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试
 * 
 * @author wangyt
 *
 */
public class L12_ReadWriteLockTest {
  public static void main(String[] args) {
    final Queue3 q3 = new Queue3();

    /** 启动6个线程，3个不停的读，3个不停的写 **/
    for (int i = 0; i < 3; i++) {
      new Thread() {
        public void run() {
          while (true) {
            q3.get();
          }
        }
      }.start();

      new Thread() {
        public void run() {
          while (true) {
            q3.put(new Random().nextInt(10000));
          }
        }
      }.start();
    }
  }
}


class Queue3 {

  // 共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。
  private Object data = null;

  // 一个线程获取了rwl上的写锁，其他线程是不能同时获取rwl上的写锁和读锁的；一个线程获取了rwl上的读锁，其他线程可以再获得读锁，而不能获得写锁。
  ReadWriteLock rwl = new ReentrantReadWriteLock();

  public void get() {
    // 读操作，请求读锁
    rwl.readLock().lock();
    try {
      System.out.println(Thread.currentThread().getName() + " be ready to read data!");
      Thread.sleep((long) (Math.random() * 1000));
      System.out.println(Thread.currentThread().getName() + "have read data :" + data);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      // 释放读锁
      rwl.readLock().unlock();
    }
  }

  public void put(Object data) {
    // 写操作，请求写锁
    rwl.writeLock().lock();
    try {
      System.out.println(Thread.currentThread().getName() + " be ready to write data!");
      Thread.sleep((long) (Math.random() * 1000));
      this.data = data;
      System.out.println(Thread.currentThread().getName() + " have write data: " + data);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      rwl.writeLock().unlock();
    }
  }
}
