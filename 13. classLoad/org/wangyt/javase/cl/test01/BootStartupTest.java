package org.wangyt.javase.cl.test01;

import java.net.URL;

/**
 * 查看根类加载器加载了哪些核心类库
 * 
 * @author WANG YONG TAO
 * 
 */
@SuppressWarnings("all")
public class BootStartupTest {
	
	public static void main(String[] args) {
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();

		for (URL url : urls) {
			System.out.println(url.toExternalForm());
		}
	}
	
}
