package org.wangyt.javase.grammar.polymorphic;

class A {
	public String name = "A类";

	public void testM() {
		System.out.println("hahaha");
	}
}

class B extends A {
	public String name = "B类";

	@Override
	public void testM() {
		System.out.println(this.name + "," + super.name);

		// 不管是this.getClass()还是super.getClass(),最终都指向了Object对象的getClass(),这个方法是final的
		// 不能被子类重写。根据API定义,getClass()返回对象在运行时的类型,运行时的类型是B,所以返回类型也是B。
		System.out.println(this.getClass().getSimpleName() + "\n"
				+ super.getClass().getSimpleName());
	}
}

class ThisSuper {
	public static void main(String[] args) {
		A b = new B();
		b.testM();
	}
}
