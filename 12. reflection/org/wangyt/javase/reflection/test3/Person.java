package org.wangyt.javase.reflection.test3;

@SuppressWarnings("all")
public class Person {
	
	private String myname = "";
	
	public Person() {
	}

	public Person(String name) {
		this.myname = name;
	}

	public void PersonMethod() {
		System.out.println("I am PersonMethod1!");
	}

	private void PersonMethod(String name) {
		System.out.println("You input the parameter is: " + name + "and my name is: " + myname);
	}

	public int PersonMethod(int[] intArray) {
		int sum = 0;
		for (int i : intArray) {
			sum = sum + i;
		}
		return sum;
	}

	public static void PersonStaticMethod() {
		System.out.println("I am PersonStaticMethod!");
	}

	public static void main(String[] args) {
		System.out.println("I am main method!");
	}
}