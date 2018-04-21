package org.wangyt.javase.multithread10.exception;

/**
 * 主线程捕获子线程异常演示
 * 
 * @author wangyongtao
 *
 */
@SuppressWarnings("all")
public class ThreadExceptionTest {

  public static void main(String[] args) {

    Thread.UncaughtExceptionHandler eh = new Thread.UncaughtExceptionHandler() {
      public void uncaughtException(Thread th, Throwable ex) {
        System.out.println("Uncaught exception: " + ex);
        ex.printStackTrace();
      }
    };

    Thread subThd = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Sleeping ...");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println("Interrupted.");
        }
        System.out.println("Throwing exception ...");
        throw new RuntimeException("子线程[ " + Thread.currentThread().getName() + " ]抛出异常异常.");
      }
    });

    subThd.setUncaughtExceptionHandler(eh);
    subThd.start();
  }


  public static void lambda() {

    // 匿名内部类
    Runnable anonCla01 = new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName());
      }
    };


    // 实际上是将匿名内部类转换成lambda表达式.
    Runnable anonCla02 = () -> {
      System.out.println(Thread.currentThread().getName());
    };

  }

}
