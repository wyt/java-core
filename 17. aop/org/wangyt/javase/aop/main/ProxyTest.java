package org.wangyt.javase.aop.main;

import org.junit.Test;
import org.wangyt.javase.aop.proxy.CglibProxyFactory;
import org.wangyt.javase.aop.proxy.JDKProxyFactory;
import org.wangyt.javase.aop.service.PersonService;
import org.wangyt.javase.aop.service.impl.PersonServiceBean;

/**
 * @author 王永涛
 * 
 * @since 2012-7-21 上午10:02:18
 * 
 */
public class ProxyTest {

	@Test
	public void getProxyInstanceByJDK() {
		JDKProxyFactory factory = new JDKProxyFactory();
		PersonService personService = (PersonService) factory.getProxyInstance(new PersonServiceBean(null));

		/** 调用personService的各种接口方法，其实是调用JDKProxyFactory中的invoke方法 **/
		personService.save(null);
	}

	@Test
	public void getProxyInstanceByCglib() {
		CglibProxyFactory factory = new CglibProxyFactory();

		// 注意代理对象中需要有无参构造函数。
		PersonServiceBean bean = (PersonServiceBean) factory.createProxyIntance(new PersonServiceBean("wangyongtao"));
		bean.save(null);
	}

}