package org.wangyt.javase.jcf.map.test;

/**
 * 比较器
 * 
 * @author 王永涛
 * 
 * @date 2012-9-4 下午07:59:30
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class ComparableUser implements Comparable<ComparableUser>
{
    private String id;

    private String name;

    public ComparableUser(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ComparableUser other = (ComparableUser) obj;
        if (id == null)
        {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int compareTo(ComparableUser o)
    {
        if (o.equals(this.id))
        {
            return 0;
        } else if (id.compareTo(o.id) > 0)
        {
            return 1;
        } else
        {
            return -1;
        }
    }

    public static void main(String[] args)
    {
        ComparableUser cu_01 = new ComparableUser("cu1001", "user_001");
        ComparableUser cu_02 = new ComparableUser("cu1002", "user_002");

        System.out.println(cu_01.compareTo(cu_02));
    }
}