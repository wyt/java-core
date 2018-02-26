package org.wangyt.javase.grammar.innerclass;

/**
 * 局部内部类,也叫方法内部类
 * 
 * @author wangyt
 * 
 */
public class OutterClass03
{
	static int a = 1;

	public static void main(String[] args)
	{
		int b = 2;

		class InnerBase
		{
			int c;
		}

		class InnerSub extends InnerBase
		{
			int d;
		}
		InnerSub is = new InnerSub();
		is.c = 3;
		is.d = 4;

		System.out.println(a + "," + b + "," + is.c + "," + is.d);
	}
}
