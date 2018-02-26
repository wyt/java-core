package org.wangyt.javase.annotation.test4;

/**
 * @author 王永涛
 * 
 * @since 2012-7-8 下午09:25:11
 * 
 */
public class MyAnnotationTest {
	
	// @MyAnnotation 不可以修饰字段
	private String wife_name = "";

	@MyAnnotation
	public String getWife_name() {
		return wife_name;
	}

	public void setWife_name(String wife_name) {
		this.wife_name = wife_name;
	}
	
}