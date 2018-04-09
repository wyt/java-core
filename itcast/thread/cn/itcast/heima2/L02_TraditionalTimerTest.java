package cn.itcast.heima2;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import org.junit.Test;

/**
 * 传统定时器技术回顾
 * 
 * @author WANG YONG TAO
 *
 */
public class L02_TraditionalTimerTest {

  private static int count = 0;

  @Test
  public void testTimer01() {
    /**
     * 面向对象的方式思考：一个定时器实例，拥有计划schedule方法，具体的任务由TimerTask实现.
     */
    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName() + " !!!bombing!!! ");
      }
    }, 5000, 3000);

    while (true) {
      System.out.println(
          Thread.currentThread().getName() + " " + Calendar.getInstance().get(Calendar.SECOND));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Test
  public void testTimer02() {
    /**
     * 面向对象的方式思考：一个定时器实例，拥有计划schedule方法，具体的任务有TimerTask实现
     */
    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println("bombing!");
      }
    }, 5000, 3000);

    while (true) {
      System.out.println(Calendar.getInstance().get(Calendar.SECOND));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Test
  public void testTimer03() {

    class MyTimerTask extends TimerTask {
      @Override
      public void run() {
        // count 1,0来回变化
        count = (count + 1) % 2;
        System.out.println(Thread.currentThread().getName() + " bombing!");
        new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);
      }
    }

    new Timer().schedule(new MyTimerTask(), 2000);

    while (true) {
      System.out.println(Calendar.getInstance().get(Calendar.SECOND));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
