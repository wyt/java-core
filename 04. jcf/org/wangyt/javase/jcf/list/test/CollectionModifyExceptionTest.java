package org.wangyt.javase.jcf.list.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionModifyExceptionTest
{
	public static void main(String[] args)
	{
		Collection users = new ArrayList();
		// Collection users = new CopyOnWriteArrayList();
		users.add(new User("张三", 28));
		users.add(new User("李四", 25));
		users.add(new User("王五", 31));

		Iterator itrUsers = users.iterator();
		while (itrUsers.hasNext())
		{
			User user = (User) itrUsers.next();
			if ("张三".equals(user.getName()))
			{
				// users.remove(user);
				itrUsers.remove();
			} else
			{
				System.out.println(user);
			}
		}

/*		for (Object user : users)
		{
			User u01 = (User) user;
			if ("张三".equals(u01.getName()))
			{
				users.remove(u01);
			} else
			{
				System.out.println(u01);
			}
		}*/
	}
}
