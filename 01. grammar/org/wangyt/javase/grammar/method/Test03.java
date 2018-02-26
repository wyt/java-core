package org.wangyt.javase.grammar.method;

public class Test03 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello ");
		System.out.println("Before change, sb = " + sb);
		// 假设sb引用的地址为0ac
		changeData(sb);
		System.out.println("After changeData(n), sb = " + sb);
	}

	// 调用到changeDate，此时strBuf引用地址为strBuf
	public static void changeData(StringBuffer strBuf) {
		// 此处new新开辟了内存空间，假设首地址为0de,将其赋给strBuf
		strBuf = new StringBuffer("Hi ");
		strBuf.append("World!");
	}
}