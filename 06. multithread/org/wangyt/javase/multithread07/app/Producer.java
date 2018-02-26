package org.wangyt.javase.multithread07.app;

/**
 * 生产者线程 -- 负责添加货物(调用Store的add方法)
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-8-30 下午01:40:59
 * 
 */
public class Producer extends Thread {
	private Store store;

	public Producer(Store store) {
		this.store = store;
	}

	@Override
	public void run() {
		while (true) {
			try {
				store.add();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}