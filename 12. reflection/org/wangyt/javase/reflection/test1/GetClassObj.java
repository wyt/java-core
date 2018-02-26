package org.wangyt.javase.reflection.test1;

/**
 * 类加载器在将 *.class文件加载进虚拟机的时候,会为该字节码文件创建一个Class类型的对象。
 * 
 * 获得一个类Class对象的三种方式。
 * 
 * @author WANG YONG TAO
 * 
 */
public class GetClassObj {
	
	public static void main(String[] args) throws ClassNotFoundException {
		// 1. 只通过类名得到Class(只有字符串类名的情况下想得到Class的最佳方式)
		Class<?> clazz1 = Class.forName("org.wangyt.javase.reflection.test1.GetClassObj");

		// 2.
		Class<?> clazz2 = new GetClassObj().getClass();

		// 3.
		Class<?> clazz3 = GetClassObj.class;

		System.out.println(clazz1 + "\n" + clazz2 + "\n" + clazz3);
	}
	
}