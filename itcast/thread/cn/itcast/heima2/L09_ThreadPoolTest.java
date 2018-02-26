package cn.itcast.heima2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Executors
 * 
 * @author WANG YONG TAO
 *
 */
public class L09_ThreadPoolTest {
	
	public static void main(String[] args) {
		
		/** 三种不同的线程池 **/
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		// ExecutorService threadPool = Executors.newCachedThreadPool();
		// ExecutorService threadPool = Executors.newSingleThreadExecutor();

		for (int i = 1; i <= 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 1; j <= 10; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ " is looping of " + j + " for  task of "
								+ task);
					}
				}
			});
		}

		// 用于测试上面循环已经完成
		System.out.println("all of 10 tasks have committed! ");
		// threadPool.shutdownNow();
		// 任务执行完了，关闭线程池，退出虚拟机
		threadPool.shutdown();
	}

	/**
	 * 线程池启动定时器
	 */
	public static void testScheduledThreadPool() {
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("bombing!");
			}
		}, 6, 2, TimeUnit.SECONDS);
	}
}
