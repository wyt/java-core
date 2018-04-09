package org.wangyt.javase.multithread04.sysc;

import org.junit.Test;

public class SyscThread01 {

  /**
   * 非同步线程类
   */
  private static class Thread01 extends Thread {
    public static int index;

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println(getName() + ":" + index++);
      }
    }
  }

  /**
   * 同步线程类
   */
  private static class Thread02 extends Thread {
    public static int index;
    public static Object obj_locker = new Object();

    @Override
    public void run() {
      synchronized (obj_locker) {
        for (int i = 0; i < 100; i++) {
          System.out.println(getName() + ":" + index++);
        }
      }
    }
  }

  @Test
  public void testThread01() {
    new SyscThread01.Thread01().start();
    new SyscThread01.Thread01().start();
    new SyscThread01.Thread01().start();
  }

  @Test
  public void testThread02() {
    new SyscThread01.Thread02().start();
    new SyscThread01.Thread02().start();
    new SyscThread01.Thread02().start();
  }
}
