package cn.itcast.heima2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。
 * 
线程pool-1-thread-3即将到达集合地点1，当前已有1个已经到达，正在等候
线程pool-1-thread-1即将到达集合地点1，当前已有2个已经到达，正在等候
线程pool-1-thread-2即将到达集合地点1，当前已有3个已经到达，都到齐了，继续走啊
线程pool-1-thread-3即将到达集合地点2，当前已有1个已经到达，正在等候
线程pool-1-thread-1即将到达集合地点2，当前已有2个已经到达，正在等候
线程pool-1-thread-2即将到达集合地点2，当前已有3个已经到达，都到齐了，继续走啊
线程pool-1-thread-2即将到达集合地点3，当前已有1个已经到达，正在等候
线程pool-1-thread-3即将到达集合地点3，当前已有2个已经到达，正在等候
线程pool-1-thread-1即将到达集合地点3，当前已有3个已经到达，都到齐了，继续走啊
 * 
 * @author wangyt
 *
 */
public class L15_CyclicBarrierTest {
  public static void main(String[] args) {
    ExecutorService service = Executors.newCachedThreadPool();
    final CyclicBarrier cb = new CyclicBarrier(3);
    for (int i = 0; i < 3; i++) {
      Runnable runnable = new Runnable() {
        public void run() {
          try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点1，当前已有"
                + (cb.getNumberWaiting() + 1) + "个已经到达，"
                + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊" : "正在等候"));
            cb.await();

            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点2，当前已有"
                + (cb.getNumberWaiting() + 1) + "个已经到达，"
                + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊" : "正在等候"));
            cb.await();

            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点3，当前已有"
                + (cb.getNumberWaiting() + 1) + "个已经到达，"
                + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊" : "正在等候"));
            cb.await();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      };
      service.execute(runnable);
    }
    service.shutdown();
  }
}
