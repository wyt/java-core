package org.wangyt.javase.grammar.method;

/**
 * 值传递，引用传递
 * 
 * @author wangyt
 *
 */
public class Example {
	// str 内存地址 0adf
	String str = new String("good"); //①
	char[] ch = { 'a', 'b', 'c' };

	public static void main(String[] args) {
		Example ex = new Example();
		ex.change(ex.str, ex.ch);
		System.out.print(ex.str + "and");
		System.out.print(ex.ch);
	}

	// 形参虽然也叫str，是加上是①处值的副本
	public void change(String str, char ch[]) {
		// "test ok" 存储在常量池中，内存地址为0daf，赋值给该方法中的str并未影响到①处的str引用值
		str = "test ok";
		// str = new String("test ok");
		ch[0] = 'g';
	}
}