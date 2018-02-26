package org.wangyt.javase.enumeration.test1;

/**
 * @author WANG YONG TAO
 * 
 * @since 2015-7-7 下午8:35:01
 * 
 */
public class GradeTest {
	
	public static void main(String[] args) {
		// 输出结果：class java.lang.Enum 说明枚举都继承自java.lang.Enum
		System.out.println(Grade.A.getClass().getSuperclass());
	}
	
}
