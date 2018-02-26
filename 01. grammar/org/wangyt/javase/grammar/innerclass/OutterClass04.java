package org.wangyt.javase.grammar.innerclass;

/**
 * 定一个一个接口
 * 
 * @author wangyt
 *
 */
interface Product {
   double getPrice();
   String getName();
}


/**
 * 匿名内部类
 * 
 * @author wangyt
 * 
 */
class OutterClass04 {
   private void productInfo(Product p) {
      System.out.println("购买了一个" + p.getName() + ",花掉了" + p.getPrice());
   }

   public static void main(String[] args) {
      OutterClass04 ac = new OutterClass04();

      // 创建一个匿名内部类作为参数传入
      ac.productInfo(new Product() {
         @Override
         public double getPrice() {
            return 568.51;
         }

         @Override
         public String getName() {
            return "AGP显卡";
         }
      });
   }
}
