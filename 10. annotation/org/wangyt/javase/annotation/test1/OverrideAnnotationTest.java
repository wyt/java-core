package org.wangyt.javase.annotation.test1;

/**
 * Override注解用于检查其所标记的方法有没有覆盖父类中的某一个方法,如果没有会提示错误！
 * 
 * @author 王永涛
 * 
 * @since 2012-7-8 下午08:59:38
 * 
 */
public class OverrideAnnotationTest {
	
	@Override
	public String toString() {
		return "This is OverrideAnnotionTest";
	}
	
}
