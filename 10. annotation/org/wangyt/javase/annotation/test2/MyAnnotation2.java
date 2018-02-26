package org.wangyt.javase.annotation.test2;

/**
 * 使用枚举类型定义注解属性。
 * 
 * @author wangyongtao
 * 
 */
public @interface MyAnnotation2 {
	Grade[] value();
}

enum Grade {
	A, B, C, D, E;
}