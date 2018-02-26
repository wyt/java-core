package org.wangyt.javase.generic.test5;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 泛型使用通配符的场合.
 * <P>
 * 
 * @author WANG YONG TAO
 * 
 */
public class TestWildcards {

	/**
	 * 定义遍历集合元素的方法 只能传递List<Object>类型的,
	 * 
	 * 例如List<String>就不行 因为List<String>不是List<Object>的子类,
	 * 
	 * 但是List<String>是List的继承者
	 * 
	 * @param element
	 */
	public static void foreachList(List<Object> element) {
		for (int i = 0; i < element.size(); i++) {
			System.out.println(element.get(i).getClass().getName());
		}
	}

	@Test
	public void testForeacheList() {
		List<Object> objList = new ArrayList<Object>();
		Object obj = new Object();
		objList.add(obj);
		foreachList(objList);

		// List<String> strList = new ArrayList<String>();
		// String str = "I am a chinese!";
		// strList.add(str);
		// // 下面编译会报错定义，因为定义foreachList()方法的时候只接收List<Object>类型的方法
		// foreachList(strList);
	}

	/**
	 * List<?>使用通配符,表示它是各种泛型list的父类。
	 * 
	 * (注意直接使用这种方式不能向其中添加元素)
	 * 
	 * @param element
	 */
	public static void foreachListUseWildcards(List<?> element) {
		for (int i = 0; i < element.size(); i++) {
			System.out.println(element.get(i).getClass().getName());
		}
	}

	@Test
	public void testForeachListUseWildcards() {

		List<Object> objList = new ArrayList<Object>();
		Object obj = new Object();
		objList.add(obj);

		List<String> strList = new ArrayList<String>();
		String str = "I am a chinese!";
		strList.add(str);

		// 使用通配符消除了只能接受List<Object>类型的参数的局限性。
		foreachListUseWildcards(objList);
		foreachListUseWildcards(strList);
	}

	/**
	 * 使用extends设定通配符的上限 List<? extends Number> 表示该泛型List的元素只能是Number或其派生类
	 * 
	 * @param list
	 */
	public static void foreachListUseWildcards1(List<? extends Number> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getClass().getName());
		}
	}

	/**
	 * 使用super设定通配符的下限 List<? super Integer> 表示该泛型List的元素只能是Integer或其祖先类
	 * 
	 * @param list
	 */
	public static void foreachListUseWildcards2(List<? super Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getClass().getName());
		}
	}

	@Test
	public void testForeachListUseWildcards2() {

		Integer itg = new Integer(10);
		List<Integer> itgList = new ArrayList<Integer>();
		itgList.add(itg);
		
		foreachListUseWildcards1(itgList);
		foreachListUseWildcards2(itgList);
	}

}