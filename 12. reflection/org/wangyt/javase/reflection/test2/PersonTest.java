package org.wangyt.javase.reflection.test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.junit.Test;

public class PersonTest {
	
	/**
	 * 反射无参构造方法
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@Test
	public void testPerson() throws Exception {
		// class属性会引用到将该类加载到虚拟后为其创建的Class对象。
		Class<Person> clazz = Person.class;
		System.out.println(clazz);
		Constructor<Person> consttructor = clazz.getConstructor(new Class<?>[] {});
		// 我们也可以直接使用下面的方式直接调用该类的无参构造方法创建实例对象。
		// clazz.newInstance();

		Person person = consttructor.newInstance(new Object[] {});
		System.out.println(person);
	}

	/**
	 * 反射私有的有参构造方法
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@Test
	public void testPerson1() throws Exception {
		Class<Person> clazz = Person.class;
		Constructor<Person> constructor = clazz
				.getDeclaredConstructor(new Class<?>[] { String.class, int.class, ArrayList.class });
		// Constructor<Person> constructor = clazz.getConstructor(new Class<?>[] {
		// String.class, int.class, ArrayList.class });

		// 设置可以访问私有的构造方法
		constructor.setAccessible(true);
		Person person = constructor.newInstance("sunwukong", 1000, new ArrayList<String>());

		System.out.println(person.getName() + " " + person.getAge());
	}
}