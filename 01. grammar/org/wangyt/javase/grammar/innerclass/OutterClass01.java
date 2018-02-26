package org.wangyt.javase.grammar.innerclass;


/**
 * 静态内部类,static 修饰
 * 
 * @author wangyt
 * 
 */
@SuppressWarnings("all")
class OutterClass01 {
   public Integer count = new Integer(22);

   /**
    * public 修饰的静态内部类跟独立的外部类几乎没有区别
    * 
    * @author wangyt
    *
    */
   public static class InnerClass01 {
      private void calcul() {
         // 访问不到成员变量
         // System.out.println(count);
      }
   }
}
