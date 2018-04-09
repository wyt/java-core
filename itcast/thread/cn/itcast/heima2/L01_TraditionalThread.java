package cn.itcast.heima2;

/**
 * L01_表示 第一课
 * 
 * 传统线程技术回顾
 * 
 * @author WANG YONG TAO
 *
 */
public class L01_TraditionalThread {

  public static void main(String[] args) {

    Thread thread = new Thread() {
      @Override
      public void run() {
        while (true) {
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("1:" + Thread.currentThread().getName());
          System.out.println("2:" + this.getName());
        }
      }
    };
    thread.start();

    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("1:" + Thread.currentThread().getName());
        }
      }
    });
    thread2.start();

    // 轮廓 new Thread(Runnable r){...}.start();
    new Thread(new Runnable() {
      public void run() {
        while (true) {
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("runnable :" + Thread.currentThread().getName());
        }
      }
    }) {
      public void run() {
        while (true) {
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("thread :" + Thread.currentThread().getName());
        }
      }
    }.start();
  }
}
