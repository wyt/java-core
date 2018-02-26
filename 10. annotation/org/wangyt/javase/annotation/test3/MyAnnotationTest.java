package org.wangyt.javase.annotation.test3;

/**
 * @author 王永涛
 *
 * @since 2012-7-8 下午09:13:13
 *
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAnnotationTest {
	
	@MyAnnotation(hello = "beijing", world = "shanghai")
	public void output() {
		System.out.println("I am output method!");
	}

	// 分析被注解修饰对象的工具方法
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		MyAnnotationTest mt = new MyAnnotationTest();

		// 0. 先将类的方法反射出来
		Class<MyAnnotationTest> clazz = MyAnnotationTest.class;
		Method method = clazz.getMethod("output", new Class[] {});

		// 1. 判断该方法是否被类型为MyAnnotation的注解修饰
		if (method.isAnnotationPresent(MyAnnotation.class)) {
			// 反射方法调用
			method.invoke(mt, new Object[] {});

			// 得到方法上的注解
			MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);

			// 得到注解属性
			String hello = myAnnotation.hello();
			String world = myAnnotation.world();

			System.out.println(hello + "\n" + world);
		}

		Annotation[] annotations = method.getAnnotations();

		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType().getName());
		}
	}
}