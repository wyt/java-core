package org.wangyt.javase.io.serializable;

import java.io.Serializable;

/**
 * 实现可序列化接口的Student Object
 * 
 * @author 王永涛
 * 
 * @date 2012-8-29 下午10:46:59
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class Student implements Serializable
{
	private static final long serialVersionUID = 6308182853974098701L;

	private String name;

	private int age;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}