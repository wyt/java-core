package org.wangyt.javase.aop.service.impl;

import org.wangyt.javase.aop.service.PersonService;

public class PersonServiceBean implements PersonService {
	
	private String user = null;

	public PersonServiceBean() {
	}

	public PersonServiceBean(String user) {
		this.user = user;
	}

	public String getPersonName(Integer personid) {
		System.out.println("I am getPersonName method!");
		return "I love you!";
	}

	public void save(String name) {
		System.out.println("I am save method!");
	}

	public void update(String name, Integer personid) {
		System.out.println("I am update method!");
	}

	public String getUser() {
		return user;
	}
}