package org.wangyt.javase.annotation.test2;

/**
 * 用 @interface 定义一个 注解。
 * 
 * 注解的使用方式：
 * 
 * @annotation(value = "args")
 * 
 *                   使用 @interface 自行定义Annotation类型时,实际上是自动继承了
 * 
 *                   java.lang.annotation.Annotation接口
 * 
 */
public @interface MyAnnotation1 {
	/**
	 * 定义注解的属性(属性名后必须跟括号)
	 * 
	 * 如果属性名为value的话在使用注解的时候可以省略。
	 * 
	 */
	String[] value() default "wangyongtao";
}
