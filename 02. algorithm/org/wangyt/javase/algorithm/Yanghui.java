package org.wangyt.javase.algorithm;

import java.util.Scanner;

/**
 * 杨辉三角
 * 
 *             1     
            1     1     
         1     2     1     
      1     3     3     1     
   1     4     6     4     1  
 * 
 * @author 王永涛
 * 
 * @date 2012-9-10 下午12:40:54
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class Yanghui {
   public static void main(String[] args) {
      System.out.println("请输入行数：");
      Scanner f = new Scanner(System.in);
      int n = f.nextInt();

      int[][] arr = new int[n][];

      for (int i = 0; i < n; i++) {
         arr[i] = new int[i + 2];// 二维数组中的一维数组在存入数据的时候也必须new，即先分配内存。
         arr[i][0] = 1;
         // arr[i][i+1] =0; //int变量不赋值默认为0
         for (int j = 1; j < i + 1; j++) {
            arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
         }
      }

      // m控制行数
      for (int m = 0; m < n; m++) {
         for (int u = 0; u < n - m; u++) {
            System.out.print("   ");
         }

         // s控制每行输入的个数
         for (int s = 0; s < m + 1; s++) {
            System.out.print(arr[m][s] + "     ");
         }
         System.out.println();
      }
   }
}
