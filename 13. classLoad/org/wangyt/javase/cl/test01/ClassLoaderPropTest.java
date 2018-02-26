package org.wangyt.javase.cl.test01;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 各种类加载器
 * 
 * @author WANG YONG TAO
 * 
 */
public class ClassLoaderPropTest {

	public static void main(String[] args) throws IOException {
		// 得到该类的类加载器(普通类加载器) getResource("")只写空串,不写资源名,返回的是类加载器的加载路径部分(用URL类表示)。
		String path = ClassLoaderPropTest.class.getClassLoader()
				.getResource("org/wangyt/javase/cl/test01/res.properties").getPath();
		System.out.println("资源的路径为：" + path);

		// 得到系统类加载器 及其加载路径
		Enumeration<URL> enums = ClassLoader.getSystemClassLoader().getResources("");
		while (enums.hasMoreElements()) {
			System.out.println("系统类加载器的加载路径：" + enums.nextElement().getPath());
		}

		// 获取系统类加载器的父类加载器(扩展类加载器)
		// ClassLoader extenstionLoader =
		// ClassLoader.getSystemClassLoader().getParent();
		System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
	}

}