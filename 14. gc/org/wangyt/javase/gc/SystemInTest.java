package org.wangyt.javase.gc;

import java.io.IOException;

/**
 * 输入一个字符后，就执行完毕，实际上是3个字符，回车、换行
 * 
 * @author WANG YONG TAO
 *
 */
public class SystemInTest {
	
	public static void main(String[] args) throws IOException {
		int a = System.in.read();
		System.out.println("a: " + a);
		int b = System.in.read();
		System.out.println("b: " + b);
		int c = System.in.read();
		System.out.println("c: " + c);
	}
	
}
