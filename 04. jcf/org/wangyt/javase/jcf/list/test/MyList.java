package org.wangyt.javase.jcf.list.test;

/**
 * 自己实现一个链表(需要对链表的结构有所了解)
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午10:17:37
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class MyList {
	private static class Node {
		Object data;
		Node next;

		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;

	public MyList() {
		head = null;
	}

	public void clear() {
		head = null;
	}

	/** 遍历打印链表 */
	public void travel() {
		Node p = head;
		while (p != null) {
			System.out.println(p.data);
			p = p.next;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		Node p = head;
		int sum = 0;
		while (p != null) {
			sum++;
			p = p.next;
		}
		return sum;
	}

	public void insert(Object obj, int pos) {
		if (pos < 0 || pos > size())
			throw new RuntimeException("下标出错!");

		/** 每当在MyList中插入一个新元素，就新构建一个Node节点 */
		Node newNode = new Node(obj);

		// 如果在链表的头部插入，新节点需要next需要指向原来的head
		if (pos == 0) {
			newNode.next = head;
			head = newNode;
		} else if (pos >= size() - 1)// 如果在链表尾部插入
		{
			get(size() - 1).next = newNode;
		}
		// 其他情况就是在链表中间位置插入
		else {
			newNode.next = get(pos);
			get(pos - 1).next = newNode;
		}
	}

	public Node get(int pos) {
		if (pos < 0 || pos > size()) {
			throw new RuntimeException("下标出错!");
		}
		if (pos == 0)
			return head;

		Node p = head;

		for (int i = 0; i < pos; i++)
			p = p.next;

		return p;
	}

	public static void main(String[] args) {
		MyList list = new MyList();
		list.insert(10, 0);
		list.insert(20, 1);
		list.insert(30, 0);
		list.insert(40, 1);
		list.travel();
	}
}