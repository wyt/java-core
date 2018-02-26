package org.wangyt.javase.grammar.method;

/**
 * http://6924918.blog.51cto.com/6914918/1283761
 * 
 * @author wangyt
 *
 */
public class Test02 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello ");
		System.out.println("Before change, sb = " + sb);
		changeData(sb);
		System.out.println("After changeData(n), sb = " + sb);
	}

	public static void changeData(StringBuffer strBuf) {
		strBuf.append("World!");
	}
}