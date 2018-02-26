package org.wangyt.javase.generic.test1;

/**
 * 泛型应用于希望将 数据类型(基本和对象数据类型)参数化的地方
 * 
 * 相当于为类定义了参数,比较方法参数理解。 另外在泛型编译过程中,字节码文件中的泛型信息都会被去掉。LVTT中会保留。
 * 
 * @author WANG YONG TAO
 * 
 * @param <T>
 */
public class Box<T> {

	private T t;

	public T getT() {
		return t;
	}

	public void add(T t) {
		this.t = t;
	}

}