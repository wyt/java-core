package org.wangyt.javase.multithread03.join;

/**
 * 守护线程(后台线程、精灵线程)
 * 
 * 如果所有前台线程都死亡，守护线程会自动死亡，不一定会执行完线程任务。
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-8-30 下午05:09:54
 * 
 */
class DaemonThread extends Thread {
	
	public DaemonThread(String name) {
		super(name);
	}

	public void run() {
		// 因为是精灵线程，实际的执行结果大大小于10000
		for (int i = 0; i < 10000; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		Thread t = new DaemonThread("Thread-daemon");
		t.setDaemon(true); // 将t设置为守护线程、
		t.start();
		for (int i = 0; i < 2; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}