package cn.itcast.heima2;

/**
 * <P>
 * 传统线程互斥技术
 * 
 * 1. 非静态同步方法用的都是同一把锁——实例对象本身. 
 * 2. 静态同步方法用的也是同一把锁——类对象本身 
 * 3. 同步代码块可以用实例对象本身(this);也可以用类对象本身T.class 4.
 * 只有用同一把锁的方法或者代码块之间,才会相互构成锁竞争条件.
 * 
 * </P>
 * 
 * @author WANG YONG TAO
 *
 */
@SuppressWarnings("all")
public class L03_TraditionalThreadSynchronized {

  public static void main(String[] args) {
    new L03_TraditionalThreadSynchronized().init();
  }

  private void init() {

    final Outputer outputer = new Outputer();

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          outputer.output2("zhangxiaoxiang");
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          outputer.output("lihuoming");
        }

      }
    }).start();

  }

  static class Outputer {

    public void output(String name) {
      int len = name.length();

      /** 相当于静态的同步方法 */
      // synchronized (Outputer.class) {
      /** 相当于非静态的同步方法 */
      synchronized (this) {
        for (int i = 0; i < len; i++) {
          System.out.print(name.charAt(i));
        }
        System.out.println();
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
