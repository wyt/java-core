package cn.itcast.heima2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 允许一个或多个线程等待其他线程完成操作,类似于join
 * 
线程pool-1-thread-2正准备接受命令
线程pool-1-thread-1正准备接受命令
线程pool-1-thread-3正准备接受命令
线程main即将发布命令
线程main已发送命令，正在等待结果
线程pool-1-thread-3已接受命令
线程pool-1-thread-1已接受命令
线程pool-1-thread-2已接受命令
线程pool-1-thread-3回应命令处理结果
线程pool-1-thread-2回应命令处理结果
线程pool-1-thread-1回应命令处理结果
线程main已收到所有响应结果
 * 
 * @author wangyt
 */
public class L16_CountdownLatchTest {

  public static void main(String[] args) throws Exception {
    ExecutorService service = Executors.newCachedThreadPool();

    final CountDownLatch cdOrder = new CountDownLatch(1);
    final CountDownLatch cdAnswer = new CountDownLatch(3);

    for (int i = 0; i < 3; i++) {
      Runnable runnable = new Runnable() {
        public void run() {
          try {
            System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令");
            cdOrder.await();

            System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");
            Thread.sleep((long) (Math.random() * 10000));

            System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");
            cdAnswer.countDown();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      };
      service.execute(runnable);
    }

    Thread.sleep((long) (Math.random() * 10000));

    System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
    cdOrder.countDown();

    System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待结果");
    cdAnswer.await();

    System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");

    service.shutdown();
  }
}
