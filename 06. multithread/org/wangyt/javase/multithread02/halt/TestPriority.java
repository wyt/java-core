package org.wangyt.javase.multithread02.halt;

/**
 * 改变线程优先级(Priority)
 * 
 * @author 王永涛
 * 
 * @since 2012-8-30 下午05:28:59
 * 
 */
class TestPriority extends Thread {
	public TestPriority() {
	}

	public TestPriority(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + ",其优先级是: " + this.getPriority() + ",循环变量的值为： " + i);
		}
	}

	public static void main(String[] args) {
		// 改变main的优先级
		Thread.currentThread().setPriority(6);

		for (int i = 0; i < 30; i++) {
			if (i == 10) {
				// low线程的优先级默认和创建它的父线程main-thread相同。
				Thread low_thread = new TestPriority("low-thread");

				low_thread.start();
				System.out.println("low-thread,创建之初的优先级: " + low_thread.getPriority());
				low_thread.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20) {
				// high线程的优先级默认和创建它的父线程main-thread相同。
				Thread high_thread = new TestPriority("high-thread");
				high_thread.start();
				System.out.println("high-thread,创建之初的优先级: " + high_thread.getPriority());
				high_thread.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}