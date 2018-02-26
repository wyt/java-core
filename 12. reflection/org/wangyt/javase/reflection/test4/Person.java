package org.wangyt.javase.reflection.test4;

import java.util.ArrayList;

@SuppressWarnings("all")
public class Person {
	
	private String name;
	private int age;
	private ArrayList<String> list;

	public Person() {
	}

	private Person(String name, int age, ArrayList<String> list) {
		super();
		this.name = name;
		this.age = age;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}
}