package org.wangyt.javase.generic.test6;

import org.junit.Test;

/**
 * @author 王永涛
 * 
 * @since 2012-8-7 下午08:21:41
 * 
 */
public class TestGeneric {

	@Test
	public void testUseGeneric() {
		// 定义泛型类UseGeneric的一个Integer版本
		UseGeneric<Integer> intOb = new UseGeneric<Integer>(88);
		intOb.showType();

		// 使用泛型可以避免强制类型转换
		int i = intOb.getOb();
		System.out.println("value= " + i);

		// 定义泛型类UseGeneric的一个String版本
		UseGeneric<String> strOb = new UseGeneric<String>("Hello Gen!");
		strOb.showType();

		String s = strOb.getOb();
		System.out.println("value= " + s);
	}

	@Test
	public void testUnUseGeneric() {
		// 定义类UnUseGeneric的一个Integer版本
		UnUseGeneric intOb = new UnUseGeneric(new Integer(88));
		intOb.showType();

		// 强制类型转换
		int i = (Integer) intOb.getOb();
		System.out.println("value= " + i);

		// 定义类UnUseGeneric的一个String版本
		UnUseGeneric strOb = new UnUseGeneric("Hello Gen!");
		strOb.showType();

		String s = (String) strOb.getOb();
		System.out.println("value= " + s);
	}

}