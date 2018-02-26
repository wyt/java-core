package org.wangyt.javase.annotation.test2;

/**
 * 自定义注解的使用方式
 * 
 * @author 王永涛
 * 
 * @since 2012-7-9 上午11:40:19
 * 
 */
public class MyAnnotationTest {

	@MyAnnotation1({ "Yongtao", "Wang" })
	public void method() {
	}

	@MyAnnotation2({ Grade.A, Grade.B })
	public void method2() {
	}
}