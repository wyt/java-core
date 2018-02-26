package org.wangyt.javase.generic.test6;

/**
 * @author 王永涛
 * 
 * @since 2012-8-7 下午08:18:34
 * 
 */
public class UnUseGeneric {

	/** 定义一个通用类型成员 **/
	private Object ob;

	public UnUseGeneric(Object ob) {
		this.ob = ob;
	}

	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}

	public void showType() {
		System.out.println("T的实际类型是: " + ob.getClass().getName());
	}

}