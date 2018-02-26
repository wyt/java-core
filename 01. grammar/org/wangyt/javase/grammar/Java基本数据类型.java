package org.wangyt.javase.grammar;

/**
 * Java 数据类型分为【基本数据类型】和【对象数据类型】两大类
 * 
 * 基本数据类型分为四类：【整型】【浮点型】【字符型】【布尔型】
 * 
 * 四种基本数据类型具体分为八种：【byte、short、int、long】【char】【float、double】【布尔型】
 * 
 */
public class Java基本数据类型 {
	public static void main(String[] args) {
		/**
		 * byte 类型占一个字节(Byte),一个字节8个二进制位位(Bit),第一个二进制位表示正负,剩余七位表数值,故最大值为
		 * 2^7-1=127,最小值为-(2^7)=-128
		 */
		System.out.println(Byte.SIZE + "," + Byte.MAX_VALUE + ","
				+ Byte.MIN_VALUE + ","); // 127,-128

		/**
		 * short 占两个字节
		 */
		System.out.println(Short.SIZE + "," + Short.MAX_VALUE + ","
				+ Short.MIN_VALUE); // 32767,-32768

		/**
		 * int 占四个字节
		 */
		System.out.println(Integer.SIZE + "," + Integer.MAX_VALUE + ","
				+ Integer.MIN_VALUE); // 2147483647,-2147483648

		/**
		 * long 占八个字节
		 */
		System.out.println(Long.SIZE + "," + Long.MAX_VALUE + ","
				+ Long.MIN_VALUE); // 9223372036854775807,-9223372036854775808

		/**
		 * float 占四个字节
		 */
		System.out.println(Float.SIZE + "," + Float.MAX_VALUE + ","
				+ Float.MAX_VALUE);

		/**
		 * double 占八个字节
		 */
		System.out.println(Double.SIZE + "," + Double.MAX_VALUE + ","
				+ Double.MIN_VALUE);

		/**
		 * char 占两个字节
		 */
		System.out.println(Character.SIZE + "," + (Character.MIN_VALUE + 0)
				+ "," + (Character.MAX_VALUE + 0));
	}
}
