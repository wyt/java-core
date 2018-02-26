package org.wangyt.javase.reflection.test5;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 用反射API来操作javabean过于繁琐,于是sun公司提供一套专门用来反射javabean的API,称之为introspector(内省)
 * 
 * @author WANG YONG TAO
 * 
 */
public class PersonTest {
	
	/**
	 * 内省遍历bean的属性
	 * 
	 * @throws IntrospectionException
	 */
	@Test
	public void testPerson() throws IntrospectionException {
		BeanInfo bInfo = Introspector.getBeanInfo(Person.class);
		// BeanInfo bInfo = Introspector.getBeanInfo(Person.class,Object.class);
		// 此重载的方法去除从Object中继承而来的属性。
		// 得到属性描述器
		PropertyDescriptor[] pds = bInfo.getPropertyDescriptors();
		// 得到bean中有哪些属性(注意属性和字段的区别,属性由set和get方法决定,字段是类的成员变量)
		for (PropertyDescriptor pd : pds) {
			System.out.println("-" + pd.getName());
		}
	}

	@Test
	public void testPerson2()
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Person person = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("name", Person.class);

		// 得到属性的set方法
		Method setMethod = pd.getWriteMethod();
		setMethod.invoke(person, new Object[] { "wangyongtao" });

		// 得到属性的get方法
		Method getMethod = pd.getReadMethod();
		String name = (String) getMethod.invoke(person, new Object[] {});
		System.out.println(name);

		System.out.println("属性类型：" + pd.getPropertyType());
	}
}