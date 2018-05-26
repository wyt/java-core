package org.wangyt.javase.multithread01.GT;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程名称相同是否会有影响.
 * 
 * @author wangyongtao
 *
 */
public class MyThread03 {

  public static void main(String[] args) {
    for (int i = 0; i < 3; i++) {
      Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + ", " + new Random().nextInt(10));
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }, "MY-TEST-THD");
      t.start();
    }
  }

}
