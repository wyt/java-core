package org.wangyt.javase.enumeration.test4;

import org.junit.Test;
import org.wangyt.javase.enumeration.test3.Grade;

/**
 * 枚举(Enum)的常用方法,区别于Enumeration,Enum是JDK1.5之后才有的,而Enumeration自JDK1.0开始就有了,
 * 并且是用来迭代的,类似Iterator。
 * 
 * @author WANG YONG TAO
 * 
 */
public class EnumMethodsTest {

	@Test
	public void enumMethodsTest() {
		// valueOf()返回带指定名称(用字符串表示)、指定枚举类型的枚举常量。
		Grade eg = Grade.valueOf(Grade.class, "B");
		System.out.println("name: " + eg.name());

		// values()返回包含Grade的数组，该方法在api中没有。
		Grade[] grade = Grade.values();
		for (Grade g : grade) {
			System.out.println(g.name() + " " + g.ordinal() + " " + g.getValue() + " " + g.getValueLevel());
		}
	}

}
