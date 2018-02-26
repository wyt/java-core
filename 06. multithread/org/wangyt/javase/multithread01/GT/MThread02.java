package org.wangyt.javase.multithread01.GT;

import java.util.Random;

public class MThread02 {
	public static void main(String[] args) {
		/**
		 * 注意这是匿名内部类的实现,不是按照代码顺序先执行run，而是先把线程start了
		 */
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						int sleepTime = new Random().nextInt(5000);
						System.out.println("sleepTime: " + sleepTime + " ");
						// Thread.sleep(sleepTime);

						System.out.println(Thread.currentThread().getName());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}) {
			}.start();
		}
	}
}
