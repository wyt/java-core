package org.wangyt.javase.reflection.test3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class PersonTest {

	/**
	 * 反射无参数普通方法 public void PersonMethod()
	 */
	@Test
	public void testPerson1() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<Person> clazz = Person.class;
		Method method = clazz.getMethod("PersonMethod", new Class<?>[] {});
		method.invoke(clazz.newInstance(), new Object[] {});
	}

	/**
	 * 反射私有有参数普通方法 private void PersonMethod(String name)
	 */
	@Test
	public void testPerson2() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<Person> clazz = Person.class;
		Method method = clazz.getDeclaredMethod("PersonMethod", new Class<?>[] { String.class });
		method.setAccessible(true);
		// method.invoke(clazz.newInstance(), new Object[] { "hello,world!" });

		Constructor<Person> constructor = clazz.getDeclaredConstructor((new Class<?>[] { String.class }));
		constructor.setAccessible(true);
		method.invoke(constructor.newInstance("wangyongtao"), new Object[] { "hello,world!" });

	}

	/**
	 * 反射有返回值的方法 public int PersonMethod(int[] intArray)
	 */
	@Test
	public void testPesson3() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<Person> clazz = Person.class;
		Method method = clazz.getMethod("PersonMethod", new Class<?>[] { int[].class });
		int sum = (Integer) method.invoke(clazz.newInstance(), new int[] { 1, 2 });
		System.out.println(sum);
	}

	/**
	 * 反射静态方法 public static void PersonStaticMethod()
	 */
	@Test
	public void testPerson4() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Class<Person> clazz = Person.class;
		Method method = clazz.getMethod("PersonStaticMethod", new Class<?>[] {});
		// 静态方法不需要传递实例
		method.invoke(null, new Object[] {});
	}

	/**
	 * 反射main方法
	 */
	@Test
	public void testPerson5() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<Person> clazz = Person.class;
		Method method = clazz.getMethod("main", new Class<?>[] { String[].class });
		method.invoke(clazz.newInstance(), new Object[] { new String[] {} });
	}
	
}