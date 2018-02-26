package org.wangyt.javase.grammar.switchcase;

public class SwitchTest {
   public static void main(String[] args) {
      System.out.print(switchIt(2));
      
      Integer i1 = 124;
      Integer i2 = 124;
      Integer i3 = 129;
      Integer i4 = 129;
      System.out.println(i1 == i2);
      System.out.println(i3.equals(i4));
      System.out.println(i3 == i4);

   }

   public static int switchIt(int x) {
      int j = 1;
      switch (x) {
         case 1:
            System.out.println("execute case 1");
            j++;
         case 2:
            System.out.println("execute case 2");
            j++;
         case 3:
            System.out.println("execute case 3");
            j++;
         default:
            System.out.println("execute case default");
            j++;
      }
      return j + x;
   }
}
