package org.wangyt.javase.multithread02.halt;

import java.util.Date;

/**
 * @author 王永涛
 * 
 * @since 2012-8-30 下午05:23:48
 * 
 */
public class TestSleep {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println("当前时间: " + new Date());
			// 让当前线程暂停1s
			Thread.sleep(1000);
		}
	}
}