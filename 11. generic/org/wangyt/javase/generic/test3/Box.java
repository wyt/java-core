package org.wangyt.javase.generic.test3;

import java.util.List;

/**
 * 此版本引进带泛型的方法
 * 
 * @author WANG YONG TAO
 * 
 * @param <T>
 */
public class Box<T> {

	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	/**
	 * 把集合中所有元素的字段U都设置为相同的。
	 * 
	 * @param <U>
	 *            表示声明一下
	 * @param u
	 * @param boxes
	 */
	public static <U> void fillBoxes(U u, List<Box<U>> boxes) {
		for (Box<U> box : boxes) {
			box.set(u);
		}
	}

}