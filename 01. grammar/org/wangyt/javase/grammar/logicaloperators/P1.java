package org.wangyt.javase.grammar.logicaloperators;
public class P1 {
 
    private long b = 0;
 
    public void set1() {
        b = 0;
    }
 
    public void set2() {
        b = -1;
    }
 
    public void check() {
        System.out.println(b);
 
        if (0 != b && -1 != b) {
            System.err.println("Error");
        }
    }
    public static void main(String[] args) {
      P1 p1 = new P1();
      p1.set1();
      p1.set2();
      p1.check();
   }
}