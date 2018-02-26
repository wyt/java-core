package org.wangyt.javase.generic.test4;

import java.io.Serializable;

/**
 * 此版本引进一个限定类型参数
 * 
 * @author WANG YONG TAO
 * 
 * @param <T>
 */
// @SuppressWarnings("all")
public class Box<T> {

	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	/**
	 * 限定U只能为String或其子类类型(当然String没有派生类,也不能派生类),
	 * 
	 * 也就是指定U的上限. & 符号后面表示U指定的类型还必须要实现的接口. <p>
	 * 
	 * @param <U>
	 * @param u
	 */
	public <U extends String & Serializable> void inspect(U u) {
		System.out.println("T: " + t.getClass().getName());
		System.out.println("U: " + u.getClass().getName());
	}

}