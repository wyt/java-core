package org.wangyt.javase.grammar.logicaloperators;

/**
 * @author 王永涛
 * 
 * @date 2012-7-13 下午02:33:49
 * 
 * @version v1.0
 * 
 */
public class LogicOperatorsTest1
{
	public static void main(String[] args)
	{
		boolean a, b, c;
		a = true;
		b = false;

		c = a & b;
		System.out.println(c);

		c = a | b;
		System.out.println(c);

		c = a ^ b;
		System.out.println(c);

		c = !a && b;
		System.out.println(c);

		c = a && b;
		System.out.println(c);

		c = a || b;
		System.out.println(c);
	}
}