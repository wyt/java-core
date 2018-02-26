package org.wangyt.javase.enumeration.test2;

/**
 * 一个枚举也可以有构造方法，字段，和普通方法。
 * 
 * @author WANG YONG TAO
 * 
 */
public enum Grade {
	
	/**
	 * 以下相当于实现定义好的Grade对象.
	 */
	A("[100,90]"), B("(90,80]"), C("(80,70]"), D("(70,60]"), E("(60,0]");

	private String value;

	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
}