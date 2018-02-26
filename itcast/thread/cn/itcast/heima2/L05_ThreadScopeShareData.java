package cn.itcast.heima2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内共享变量的概念与作用. <P>
 * 
 * @author WANG YONG TAO
 *
 */
public class L05_ThreadScopeShareData {

	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

	public static void main(String[] args) {
	    
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
				    
					/** 线程范围内的变量 data **/
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + " has put data :" + data);
					threadData.put(Thread.currentThread(), data);

					/** 以下两段模块需要共享data **/
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName()+ " get data :" + data);
		}
	}

	static class B {
		public void get() {
			int data = threadData.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName()+ " get data :" + data);
		}
	}
	
}
