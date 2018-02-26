package cn.itcast.heima2;

/**
 * 多个线程之间共享数据的方式探讨
 * 
 * @author WANG YONG TAO
 *
 */
public class L07_MultiThreadShareData {
	
	public static void main(String[] args) {
		
        /*
        ShareData1 data2 = new ShareData1();
        
        new Thread(new MyRunnable1(data2)).start();
        new Thread(new MyRunnable2(data2)).start();
        */
		
		/** 创建一个共享数据对象，业务操作在该对象中执行 **/
		final ShareData1 data1 = new ShareData1();

		new Thread(new Runnable() {
			@Override
			public void run() {
				data1.decrement();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				data1.increment();
			}
		}).start();
	}
}

class MyRunnable1 implements Runnable {
	private ShareData1 data1;

	public MyRunnable1(ShareData1 data1) {
		this.data1 = data1;
	}

	public void run() {
		data1.decrement();

	}
}

class MyRunnable2 implements Runnable {
	private ShareData1 data1;

	public MyRunnable2(ShareData1 data1) {
		this.data1 = data1;
	}

	public void run() {
		data1.increment();
	}
}

/**
 * 共享数据对象
 * 
 * @author wangyt
 *
 */
@SuppressWarnings("all")
class ShareData1 {
	
	private int j = 0;

	public synchronized void increment() {
		j++;
	}

	public synchronized void decrement() {
		j--;
	}
}
