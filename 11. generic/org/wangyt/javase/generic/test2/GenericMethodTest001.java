package org.wangyt.javase.generic.test2;

public class GenericMethodTest001 {

	private static <M> void showType(M m) {
		System.out.println(m.getClass().getName());
	}
	
	public static void main(String[] args) {
		showType("is Me!");
		showType(1);
	}

}
