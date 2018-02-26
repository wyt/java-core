package org.wangyt.javase.grammar.method;

/**
 * 基本类型作为参数传递
 * 
 * 基本类型作为参数传递时，是传递值的拷贝，无论你怎么改变这个拷贝，原值是不会改变的
 * 
 * @author wangyt
 *
 */
public class Test01 {
	public static void main(String[] args) {
		int n = 3;
		System.out.println("Before change, n = " + n);

		// 这里n是实参
		changeData(n);
		System.out.println("After changeData(n), n = " + n);
	}

	// 这里n是形参
	public static void changeData(int n) {
		n = 10;
	}
}