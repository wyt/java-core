package org.wangyt.javase.grammar.innerclass;

interface Teachable {
   void work();
}


/**
 * 闭包是一种能够被调用的对象，它保存了创建它的作用域信息。
 * 
 * 仿闭包实现回调（内部类引用调用外部类的方法）
 * 
 * @author wangyt
 *
 */
class OutterClass05 {
   private String name;

   public OutterClass05() {}

   public OutterClass05(String name) {
      this.name = name;
   }

   public void work() {
      System.out.println(name + "在灯下认真敲键盘...");
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}


class TeachableCoder extends OutterClass05 {
   public TeachableCoder() {}

   public TeachableCoder(String name) {
      super(name);
   }

   private void teach() {
      System.out.println(getName() + "老师在讲台上讲解...");
   }

   private class Closure implements Teachable {
      
      @Override
      public void work() {
         teach();
      }
   }

   /** 返回一个内部类的实例 **/
   public Teachable getCallBackRef() {
      return new Closure();
   }
}


class TestThisClass {
   public static void main(String[] args) {

      /** 创建一个外部类对象 **/
      TeachableCoder tc = new TeachableCoder("Yongtao Wang");
      tc.work();

      // 表面上是调用TeachableCoder的work方法，实际上是回调Closure的teach()方法
      tc.getCallBackRef().work();
   }
}
