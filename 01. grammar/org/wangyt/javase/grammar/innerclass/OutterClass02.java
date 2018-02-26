package org.wangyt.javase.grammar.innerclass;

/**
 * 成员内部类,没有static修饰
 * 
 * @author wangyt
 * 
 */
class OutterClass02
{
	/**
	 * 定义一个内部类，
	 * 
	 * 内部类里定义了sayHello方法
	 * 
	 * sayHello方法调用了外部类的realSayHello方法
	 */
	class InnerClass02
	{
		private void sayHello()
		{
			System.out.println("我要调用外部类的realSayHello方法了！");
			realSayHello();
		}
	}

	private void realSayHello()
	{
		System.out.println("hello,world!");
	}

	public static void main(String[] args)
	{
		// 创建外部类实例
		OutterClass02 oc2 = new OutterClass02();

		// 创建内部类实例
		OutterClass02.InnerClass02 oc2I = oc2.new InnerClass02();

		// 调用成员内部类的方法
		oc2I.sayHello();
	}

}
