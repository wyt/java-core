package org.wangyt.javase.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.wangyt.javase.aop.service.impl.PersonServiceBean;

/**
 * jdk 自带的api实现动态代理要求目标对象必须实现了接口
 * 
 * 代理对象是动态生成的，所谓动态生成是指：Proxy.newProxyInstance方法根据目标对象的类加载器和
 * 
 * 其所实现的接口在jvm内存中动态生成一个代理类的Class对象，期间并不会有.class文件物理生成，然后根据该Class
 * 
 * 对象生成代理对象，该代理对象中保存着一个InvocationHandler对象的引用，当调用(进入)代理对象的方法时，得到
 * 
 * 当前运行的方法名，作为参数，传入Invo，并接着实例化出对应在接口中的Method对象cationHandler.invoke中。
 * 
 * @author 王永涛
 * 
 * @since 2012-7-19 下午03:08:22
 * 
 */
public class JDKProxyFactory implements InvocationHandler {

	private Object targetObject;

	public Object getProxyInstance(Object targerObject) {
		this.targetObject = targerObject;
		return Proxy.newProxyInstance(targerObject.getClass().getClassLoader(), targerObject.getClass().getInterfaces(),
				this);
	}

	/** 只要是回调函数，被调用时，参数都是已经传入好的。 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PersonServiceBean bean = (PersonServiceBean) this.targetObject;
		Object result = null;
		if (bean.getUser() != null) {
			// method 为接口中的方法对象，可以被其实现实例调用。
			result = method.invoke(targetObject, args);
		} else {
			System.out.println("你没有权限！");
		}
		return result;
	}
	
}