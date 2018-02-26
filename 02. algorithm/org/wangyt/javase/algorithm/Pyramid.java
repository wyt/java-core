package org.wangyt.javase.algorithm;

import java.util.Scanner;

/**
 * 输出金字塔
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午12:34:22
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class Pyramid {
   public static void main(String[] args) {
      int n;// 金字塔的总行数

      Scanner sc = new Scanner(System.in);
      System.out.println("请输入金字塔行数：");
      n = sc.nextInt();// 从键盘上获得金字塔的行数

      /* i表示行号 */
      for (int i = 1; i <= n; i++) {
         /* 找出每行空格数 和 行号的规律 */
         for (int j = 1; j <= n - i; j++) {
            // 打印空格数
            System.out.print(" ");
         }

         /* 找出每行的星号号数 和 行号的规律 */
         for (int k = 1; k <= 2 * i - 1; k++) {
            // 打印星号
            System.out.print("*");
         }

         System.out.println();
      }
   }
}
