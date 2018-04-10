package cn.itcast.heima2;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletionService批量任务.
 * 
 * @author WANG YONG TAO
 *
 */
@SuppressWarnings("all")
public class L10_CompletionService {

  public static void main(String[] args) {

    ExecutorService threadPool = Executors.newFixedThreadPool(10);

    CompletionService<Integer> completionService =
        new ExecutorCompletionService<Integer>(threadPool);

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
