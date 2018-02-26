package org.wangyt.javase.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * @author 王永涛
 * 
 * @date 2012-8-29 下午10:49:49
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class SerialStudent
{
	/**
	 * 序列化Student实例
	 */
	@Test
	public void test01()
	{
		Student student = new Student();
		student.setAge(10);
		student.setName("Jim");

		try
		{
			// 序列化student对象到student.obj文件
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("GenFiles/student.obj"));
			oos.writeObject(student);
			oos.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 反序列化student实例
	 */
	@Test
	public void test02()
	{
		ObjectInputStream ois;
		try
		{
			// 反序列化
			ois = new ObjectInputStream(new FileInputStream(
					"GenFiles/student.obj"));
			Student stuBak = (Student) ois.readObject();
			// print
			System.out.println("name: " + stuBak.getName() + ",age: "
					+ stuBak.getAge());
			ois.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}