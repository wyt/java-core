package org.wangyt.javase.reflection.test4;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 * 反射字段
 * 
 * @author WANG YONG TAO
 * 
 */
public class PersonTest {
	
	@Test
	public void testPerson() throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, InstantiationException {
		Class<Person> clazz = Person.class;

		// 获取Person类的name属性
		Field name_field = clazz.getDeclaredField("name");
		name_field.setAccessible(true);

		Person person = clazz.newInstance();
		name_field.set(person, "wangyongtao");

		// 得到字段的值
		String name = (String) name_field.get(person);
		System.out.println(name);
	}
	
}