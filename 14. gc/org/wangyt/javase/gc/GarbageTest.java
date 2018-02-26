package org.wangyt.javase.gc;

import java.io.IOException;

@SuppressWarnings("all")
public class GarbageTest {
	
	public static void main(String[] args) throws IOException {
		try {
			gcTest();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("has exited gc Test!");
		System.in.read();
		System.in.read();
		System.out.println("out begin gc!");
		for (int i = 0; i < 100; i++) {
			System.gc();
			System.in.read();
			System.in.read();
		}
	}

	private static void gcTest() throws IOException {
		System.in.read();
		System.in.read();
		Person p1 = new Person();
		System.in.read();
		System.in.read();
		Person p2 = new Person();
		p1.setMate(p2);
		p2.setMate(p1);
		System.out.println("before exit gc test!");
		System.in.read();
		System.in.read();
		System.gc();
		System.out.println("exit gc test!");
	}

	private static class Person {
		byte[] data = new byte[20000000];
		Person mate = null;

		public void setMate(Person other) {
			mate = other;
		}
	}
}
