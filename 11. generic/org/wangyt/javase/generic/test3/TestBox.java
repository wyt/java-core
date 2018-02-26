package org.wangyt.javase.generic.test3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestBox {

	@Test
	public void testBox() {

		String boxColor = "black";
		List<Box<String>> boxes = new ArrayList<Box<String>>();

		Box<String> box1 = new Box<String>();
		boxes.add(box1);

		Box<String> box2 = new Box<String>();
		boxes.add(box2);

		// 把集合中所有的盒子都设置为为黑色的。
		// Box.<String> fillBoxes(boxColor, boxes);
		// 上面一行中的<String> fillBoxes指定其在定义时指定的<U>,此处也可以不写,写的话叫做类型推断。

		System.out.println(box1.get() + "\n" + box2.get());
		Box.fillBoxes(boxColor, boxes);
		System.out.println(box1.get() + "\n" + box2.get());
	}

}