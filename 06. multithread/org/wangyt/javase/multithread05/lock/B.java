package org.wangyt.javase.multithread05.lock;

/**
 * @author WANG YONG TAO
 * 
 * @since 2012-8-30 下午06:20:51
 * 
 */
public class B {
	
	public synchronized void bar(A a) {
		System.out.println(Thread.currentThread().getName() + ",进入了B实例的bar(A)方法");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ",企图调用A实例的last方法");
		a.last();
	}

	public synchronized void last() {
		System.out.println("进入了B类的last方法内部");
	}
	
}