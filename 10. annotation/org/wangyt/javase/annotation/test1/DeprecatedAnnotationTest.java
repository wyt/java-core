package org.wangyt.javase.annotation.test1;

/**
 * Deprecated 注解用于标记不建议被使用的方法。
 * 
 * @author 王永涛
 * 
 * @since 2012-7-8 下午08:59:18
 * 
 */
public class DeprecatedAnnotationTest {
	
	@Deprecated
	public void doSomething() {
		System.out.println("I am doSomething Method!");
	}

	public static void main(String[] args) {
		DeprecatedAnnotationTest dat = new DeprecatedAnnotationTest();
		dat.doSomething();
	}
	
}
