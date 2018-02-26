package org.wangyt.javase.jcf.equals.test;

import java.util.HashMap;

/**
 * 元素放入hash表实现的集合中的时候，重写equals的同时，必须也要重写hashcode<br/>
 * 
 * <a href="http://www.cnblogs.com/dolphin0520/p/3681042.html">浅谈Java中的hashcode方法</a>
 * 
 * @author wangyt
 *
 */
class People {
   private String name;
   private int age;

   public People(String name, int age) {
      this.name = name;
      this.age = age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + age;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      People other = (People) obj;
      if (age != other.age) return false;
      if (name == null) {
         if (other.name != null) return false;
      } else if (!name.equals(other.name)) return false;
      return true;
   }

/*   @Override
   public boolean equals(Object obj) {
      return this.name.equals(((People) obj).name) && this.age == ((People) obj).age;
   }

   @Override
   public int hashCode() {
      return name.hashCode() * 37 + age;
   }*/
}


public class Main {

   public static void main(String[] args) {
      People p1 = new People("Jack", 12);
      System.out.println(p1.hashCode());

      HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
      hashMap.put(p1, 1);

      System.out.println(hashMap.get(new People("Jack", 12)));
   }
}
