package org.wangyt.javase.multithread09.pause;

/**
 * wait() notifyAll 实现线程暂停
 * 
 * @author WANG YONG TAO
 *
 */
public abstract class MyThread01 extends Thread {

	private boolean suspend = false;

	private String control = ""; // 只是需要一个对象而已，这个对象没有实际意义

	public void setSuspend(boolean suspend) {
		if (!suspend) {
			synchronized (control) {
				control.notifyAll();
			}
		}
		this.suspend = suspend;
	}

	public boolean isSuspend() {
		return this.suspend;
	}

	public void run() {
		while (true) {
			synchronized (control) {
				if (suspend) {
					try {
						control.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			this.runPersonelLogic();
		}
	}

	protected abstract void runPersonelLogic();

	public static void main(String[] args) throws Exception {
		MyThread01 myThread = new MyThread01() {
			protected void runPersonelLogic() {
				System.out.println("myThead is running");
			}
		};
		myThread.start();
		Thread.sleep(3000);
		myThread.setSuspend(true);

		System.out.println("myThread has stopped");
		Thread.sleep(3000);

		myThread.setSuspend(false);

	}
}
