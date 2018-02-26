package org.wangyt.javase.jcf.map.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 迭代Map的几种方式。
 * 
 * @author 王永涛
 * 
 * @date 2012-7-23 上午09:22:29
 * 
 * @version v1.0
 * 
 */
@SuppressWarnings("all")
public class Test1
{
	@Test
	public void test1()
	{
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		
		System.out.println(map.get(4));

		/** 遍历Map的两种方式 keyset 和 entryset **/
		// 0. keyset: 将map中的key取出放到set中。
		Set<Integer> keys = map.keySet();
		Iterator<Integer> $it = keys.iterator();
		while ($it.hasNext())
		{
			int itg = $it.next();
			String value = map.get(itg);

			System.out.println("keyset方式迭代Map");
			System.out.println(itg + "," + value);
		}

		// 1. entryset: 把map中每条键值对取出封装成Map.Entry对象，并放到Set中。
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = set.iterator();
		while (it.hasNext())
		{
			Map.Entry<Integer, String> entry = it.next();
			int key = entry.getKey();
			String value = entry.getValue();

			System.out.println("entryset方式迭代Map");
			System.out.println(key + "," + value);
		}

		for (Map.Entry<Integer, String> entry : set)
		{
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("增强for方式迭代Map");
			System.out.println(key + "," + value);
		}
	}
}