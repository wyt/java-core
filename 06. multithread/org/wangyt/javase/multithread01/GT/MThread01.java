package org.wangyt.javase.multithread01.GT;

/**
 * 0. 如何让一个类成为线程类
 * 
 * 1. 如何启动一个线程
 */
class MThread01
{
	public static void main(String[] args) throws InterruptedException
	{
		// 创建线程实例
		Thread t01 = new Thread(new MThread01.Thread01());
		Thread t02 = new MThread01.Thread02();

		// 启动一个线程
		t01.start();
		Thread.sleep(3000);
		t02.start();
	}

	/**
	 * 实现java.lang.Runnable的方式让一个类成为线程类
	 */
	static class Thread01 implements Runnable
	{
		@Override
		public void run()
		{
			System.out.println(Thread.currentThread().getName());
		}
	}

	/**
	 * 继承java.lang.Thread的方式让一个类成为线程类
	 */
	static class Thread02 extends Thread
	{
		@Override
		public void run()
		{
			System.out.println(Thread.currentThread().getName());
		}
	}
}