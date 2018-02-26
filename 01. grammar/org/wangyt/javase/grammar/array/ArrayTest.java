package org.wangyt.javase.grammar.array;

@SuppressWarnings("all")
public class ArrayTest
{
	public static void main(String[] args)
	{
		String[] strArr = new String[] { "锄禾", "日", "当午" };

		String[] strArr01 = { "01", "02", "03" };

		printArrayContent(strArr01);
		printArrayContent(strArr);

		String[][] strArr02 = new String[][] { strArr01 };
		String[][] strArr03 = { {}, {}, {} };
		
		// 数据类型可以为父类，内容可以为子类
		Number[] nums = new Number[]{new Long(1111111),new Float(1.222f)};
		
		System.out.println(nums.hashCode());
	}

	private static void printArrayContent(Object[] arr)
	{
		for (byte i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
}
