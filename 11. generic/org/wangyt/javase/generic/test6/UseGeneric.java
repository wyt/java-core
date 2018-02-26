package org.wangyt.javase.generic.test6;

/**
 * @author 王永涛
 * 
 * @since 2012-8-7 下午08:18:12
 * 
 */
public class UseGeneric<T> {
	
	/** 定义泛型成员变量 **/
	private T ob;

	public UseGeneric(T ob) {
		this.ob = ob;
	}

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	public void showType() {
		System.out.println("T的实际类型是: " + ob.getClass().getName());
	}
	
}