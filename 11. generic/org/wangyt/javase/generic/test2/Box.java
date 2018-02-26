package org.wangyt.javase.generic.test2;

/**
 * 带泛型的方法
 * 
 * @author WANG YONG TAO
 * 
 * @param <T>
 */
public class Box<T> {
	
	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	/**
	 * 定义了带泛型的方法
	 * 
	 * 应用于希望将方法的参数的数据类型参数化的情景
	 * 
	 * 可以为inspect方法传入多种类型的参数
	 * 
	 * 泛型应该是只修改了编译器的校验规则，泛型信息在运行时全部被擦除
	 * 
	 * @param <U>
	 * @param u
	 */
	public <U> void inspect(U u) {
		System.out.println("T: " + t.getClass().getName());
		System.out.println("U: " + u.getClass().getName());
	}
}

class BoxTest {
	public static void main(String[] args) {
		new Box<String>().inspect(new StringBuffer());
	}
}