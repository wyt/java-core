package org.wangyt.javase.jcf.map.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author 王永涛
 * 
 * @date 2012-9-4 下午09:18:47
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class SortStudent implements Comparable<SortStudent> {
    private String name;
    private int age;

    public SortStudent(String name) {
        this.name = name;
    }

    public SortStudent(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(SortStudent ss) {
        // 如果当期调用compareTo方法的对象大于参数对象，返回1
        if (this.age > ss.age)
            return 1;
        else if (this.age < ss.age)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return this.name + "_" + "age" + "_" + this.age;
    }

    public static void main(String[] args) {
        List<SortStudent> list = new ArrayList<SortStudent>();
        list.add(new SortStudent("student_01", 20));
        list.add(new SortStudent("student_02", 25));
        list.add(new SortStudent("student_03", 19));
        list.add(new SortStudent("student_04", 29));
        list.add(new SortStudent("student_05", 7));
        list.add(new SortStudent("student_06"));

        System.out.println("-------------------原始顺序--------------------");
        for (Iterator<SortStudent> it = list.iterator(); it.hasNext();) {
            SortStudent ss = it.next();
            System.out.println(ss);
        }

        System.out.println("-------------------自然顺序--------------------");
        Collections.sort(list);
        for (Iterator<SortStudent> it = list.iterator(); it.hasNext();) {
            SortStudent ss = it.next();
            System.out.println(ss);
        }

        System.out.println("-------------------降序排列--------------------");
        Comparator<SortStudent> com = Collections.reverseOrder();
        Collections.sort(list, com);
        for (Iterator<SortStudent> it = list.iterator(); it.hasNext();) {
            SortStudent ss = it.next();
            System.out.println(ss);
        }
    }
}
