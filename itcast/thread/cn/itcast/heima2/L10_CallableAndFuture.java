package cn.itcast.heima2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 得到线程返回的结果,
 * 
 * Callable<Void>表示无返回值的任务.
 * 
 * @author WANG YONG TAO
 *
 */
@SuppressWarnings("all")
public class L10_CallableAndFuture {

  public static void main(String[] args) {

    /** 0. 创建一个线程池 **/
    ExecutorService threadPool = Executors.newSingleThreadExecutor();

    /** 1. 提交一个Callable线程任务 **/
    Future<String> future = threadPool.submit(new Callable<String>() {
      public String call() throws Exception {
        Thread.sleep(2000);
        return "hello";
      };
    });

    System.out.print("结果为: ");

    try {
      String result = future.get();
      System.out.print(result);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      throw new RuntimeException(e.getCause());
    }

    threadPool.shutdown();
  }
}
