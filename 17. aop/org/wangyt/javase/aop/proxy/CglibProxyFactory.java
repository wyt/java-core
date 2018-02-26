package org.wangyt.javase.aop.proxy;

import java.lang.reflect.Method;

import org.wangyt.javase.aop.service.impl.PersonServiceBean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib实现动态代理
 * 
 * @author 王永涛
 * 
 * @since 2012-7-21 上午10:28:57
 * 
 */
public class CglibProxyFactory implements MethodInterceptor {

	// 目标对象
	private Object targetObject;

	// 返回目标对象的代理对象
	public Object createProxyIntance(Object targetObject) {
		this.targetObject = targetObject;
		Enhancer enhancer = new Enhancer();
		// 参数为目标对象的Class对象,cglib会让代理对象继承自目标对象
		enhancer.setSuperclass(this.targetObject.getClass());
		// 设置回调方法
		enhancer.setCallback(this);
		return enhancer.create();
	}

	/**
	 * 当对基于代理的方法调用时，在调用原对象的方法的之前会调用这个方法，如图3所示。 第一个参数是代理对像，第二和第三个参数分别 是拦截的方法和方法的参数。
	 * 
	 * 原来的方法可能通过使用java.lang.reflect.Method对象的一般反射调用， 或者使用
	 * net.sf.cglib.proxy.MethodProxy对象调用。
	 * 
	 * net.sf.cglib.proxy.MethodProxy通常被首选使 用，因为它更快。 在这个方法中，我们可以在调用原方法之前或之后注入自己的代码。
	 */
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		PersonServiceBean bean = (PersonServiceBean) this.targetObject;
		Object result = null;
		if (bean.getUser() != null) {
			System.out.println("aaa");
			result = methodProxy.invoke(targetObject, args);
		} else {
			System.out.println("您没有权限！");
		}
		return result;
	}
	
}