package cn.itcast.heima2;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 得到线程返回的结果
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

    System.out.println("等待结果");

    try {
      /** 2. 得到线程返回的结果 **/
      System.out.println("拿到结果：" + future.get());
      System.out.println("can you see me?");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    /** 批量的任务 **/
    ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
    CompletionService<Integer> completionService =
        new ExecutorCompletionService<Integer>(threadPool2);

    for (int i = 1; i <= 10; i++) {
      final int seq = i;
      completionService.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
          int sleepTime = new Random().nextInt(5000);
          System.out.println("sleepTime: " + sleepTime + " ");
          Thread.sleep(sleepTime);
          return seq;
        }
      });
    }

    for (int i = 0; i < 10; i++) {
      try {
        /** take阻塞，poll非阻塞 **/
        System.out.println(completionService.take().get());
        // System.out.println(completionService.poll().get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
  }
}
