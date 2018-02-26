package org.wangyt.javase.annotation.test1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * SuppressWarnings(args) 注解用于压制各种警告。
 * 
 * @author 王永涛
 * 
 * @since 2012-7-8 下午08:59:53
 * 
 */
@SuppressWarnings("all")
public class SuppressWarningsAnnotationTest {
	
	/**
	 * SuppressWarnings("unchecked", "deprecation") 注解分别压制住了
	 * 
	 * JDK1.5及之后的版本集合不使用泛型的unchecked警告
	 * 
	 * 方法不再被建议使用的deprecation警告
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void testSuppressWarningsAnnotation() {
		Map map = new HashMap();
		map.put("today", new Date());
		System.out.println(((Date) map.get("today")).toLocaleString());
	}
	
}
