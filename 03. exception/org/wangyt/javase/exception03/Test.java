package org.wangyt.javase.exception03;

/**
 * 
 * @author wangyt
 *
 */
public class Test
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println(new TestBasicExecption().getFis());
		} catch (BusinessExecption e)
		{
			System.out.println(e.getMessage());
		}
	}
}
