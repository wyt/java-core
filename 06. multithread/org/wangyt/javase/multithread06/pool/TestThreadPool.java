package org.wangyt.javase.multithread06.pool;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-8-30 下午01:59:00
 * 
 */
public class TestThreadPool {
	private static int sleepTime = 2000;

	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0, //
				TimeUnit.SECONDS, //
				new ArrayBlockingQueue<Runnable>(3), //
				new ThreadPoolExecutor.DiscardOldestPolicy());

		int i = 1;
		while (true) {
			try {
				Thread.sleep(sleepTime);
				String taskName = "task@" + i;
				System.out.println("put " + taskName);
				pool.execute(new ThreadPoolTask(taskName));
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadPoolTask implements Runnable, Serializable {
	private static final long serialVersionUID = 9180348119567693010L;

	private static int sleepTime = 2000;

	private String taskName;

	ThreadPoolTask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println("start..." + taskName);
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		taskName = null;
	}
}