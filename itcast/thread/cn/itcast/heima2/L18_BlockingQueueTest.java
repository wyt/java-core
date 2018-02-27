package cn.itcast.heima2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列 (Blocking Queue)
 * 
 * @author WANG YONG TAO
 *
 */
@SuppressWarnings("all")
public class L18_BlockingQueueTest {

  public static void main(String[] args) {

    /** 创建一个阻塞队列，容量为3 **/
    // final BlockingQueue<Double> queue = new ArrayBlockingQueue<Double>(3);

    // fair为false 好像不是按照FIFO的顺序
    final BlockingQueue<Double> queue = new ArrayBlockingQueue<Double>(3, false);

    for (int i = 0; i < 2; i++) {
      new Thread() {
        public void run() {
          while (true) {
            try {
              Thread.sleep((long) (Math.random() * 1000));
              Double data = Math.random();

              // put添加一个元素，如果队列满，则阻塞
              // queue.put(data);

              // offer添加一个元素并返回true，如果队列已满，则返回false
              boolean r = queue.offer(data, 1000, TimeUnit.MILLISECONDS);
              // boolean r = queue.offer(data);
              System.out.println(Thread.currentThread().getName() + " have put data " + data + " "
                  + r + ", the Queue size is " + queue.size());
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }.start();
    }

    new Thread() {
      public void run() {
        while (true) {
          try {
            // 将此处的睡眠时间分别改为100和1000，观察运行结果
            Thread.sleep(1000);

            // 移除并返回队列头部的元素，如果队列为空，则阻塞
            // Double result = queue.take();

            // 移除并返问队列头部的元素，如果队列为空，则返回null
            Double result = queue.poll();

            System.out.println(Thread.currentThread().getName() + " have take data " + result
                + ", the Queue size is " + queue.size());
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();
  }
}
