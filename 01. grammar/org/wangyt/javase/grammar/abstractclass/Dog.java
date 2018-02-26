package org.wangyt.javase.grammar.abstractclass;

public class Dog extends Animal {
   private String name = "";

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   void abstractMethod() {
      System.out.println("I have implemented the medthod");
   }

}
