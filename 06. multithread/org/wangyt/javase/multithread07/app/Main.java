package org.wangyt.javase.multithread07.app;

/**
 * 生产者和消费者模式
 * 
 * @author WANG YONG TAO
 * 
 * @date 2012-8-30 下午01:40:14
 * 
 */
public class Main {
	
	public static void main(String[] args) {
		/**
		 * 同步锁为当前的store对象
		 */
		Store store = new Store(5);

		Thread producer1 = new Producer(store);
		Thread producer2 = new Producer(store);
		producer1.setName("①号生产者");
		producer2.setName("②号生产者");

		Thread consumer1 = new Consumer(store);
		Thread consumer2 = new Consumer(store);
		consumer1.setName("①号消费者");
		consumer2.setName("②号消费者");

		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();
	}
}