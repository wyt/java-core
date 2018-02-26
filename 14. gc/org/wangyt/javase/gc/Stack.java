package org.wangyt.javase.gc;

import java.util.EmptyStackException;

/**
 * 内存泄露的例子
 * 
 * @author WANG YONG TAO
 *
 */
public class Stack {
	
	private Object[] elements = new Object[10];
	private int size = 0;

	/** 放入元素 */
	public void push(Object e) {
		ensureCapacity();
		// 使用size原来的值后自身再加1,++size在使用之前就加了1
		elements[size++] = e;
	}

	/** 弹出方法实际上会造成内存泄露 */
	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		return elements[--size];
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			Object[] oldElements = elements;
			elements = new Object[2 * elements.length + 1];
			System.arraycopy(oldElements, 0, elements, 0, size);
		}
	}
}
