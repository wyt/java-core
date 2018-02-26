package org.wangyt.javase.multithread07.app;

/**
 * 仓库类
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-8-30 下午01:23:43
 * 
 */
class Store {
	/**
	 * 仓库最大容量
	 */
	private final int MAX_SIZE;
	/**
	 * 当前的货物数量
	 */
	private int count;

	public Store(int n) {
		MAX_SIZE = n;
		count = 0;
	}

	/**
	 * 往仓库加货物的方法
	 */
	public synchronized void add() throws InterruptedException {
		while (count >= MAX_SIZE) {
			System.out.println("\n仓库已满," + Thread.currentThread().getName() + "进入【等待】状态,并释放同步锁.\n");
			/**
			 * 导致当前线程等待，并且当前线程会释放此监视器this的所有权(当前线程释放锁).
			 */
			this.wait();
		}

		count++;

		System.out.println(Thread.currentThread().getName() + " +1 , 剩余库存为: " + count);

		/**
		 * 唤醒在当前同步锁上等待的所有线程。
		 */
		this.notifyAll();
	}

	/**
	 * 从仓库拿走货物的方法
	 */
	public synchronized void remove() throws InterruptedException {
		while (count <= 0) {
			System.out.println("\n仓库已空," + Thread.currentThread().getName() + "进入【等待】状态,并释放同步锁.\n");
			/**
			 * 导致当前线程等待，并且当前线程会释放此监视器this的所有权(当前线程释放锁).
			 */
			this.wait();
		}

		count--;

		System.out.println(Thread.currentThread().getName() + " -1 , 剩余库存为: " + count);

		/**
		 * 唤醒在当前监视器上等待的某个线程。
		 */

		this.notify();
	}
}