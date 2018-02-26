package org.wangyt.javase.exception01;

import org.junit.Test;

/**
 * @author 王永涛
 * 
 * @date 2012-7-8 下午02:27:58
 * 
 * @version v1.0
 * 
 */
public class ExceptionTest1
{
	public int div(int a, int b)
	{
		int[] arr = new int[a];

		System.out.println("array length is: " + arr.length);

		arr[0] = 1;

		return a / b;
	}

	/**
	 * 处理多异常 如果方法可能抛出几个checked异常,就对应有几个catch块
	 * 如果多个catch块的异常出现继承关系,父类异常catch块放在最下面
	 */
	@Test
	public void testDiv()
	{
		try
		{
			div(0, 0);
		} catch (ArithmeticException e)
		{
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
	}
}