package org.wangyt.javase.annotation.test3;

/**
 * @author 王永涛
 *
 * @date 2012-7-8 下午09:12:38
 *
 * @version v1.0
 *
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * Retention-->保持力 RetentionPolicy-->保持策略
 * 
 * @Retention(RetentionPolicy.RUNTIME) 将其标记的对象信息保持到运行期。
 * 
 * @Retention(RetentionPolicy.CLASS) 将其标记的对象信息保持到编译期,且在class档案中仍然保持,但在运行期会丢掉。
 * 
 * @Retention(RetentionPolicy.SOURCE) 将其标记的对象信息保持到编译期。
 * 
 * 信息被保持的运行期的话,我们就可以通过反射机制动态获取。
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	
	public String hello() default "langsin";

	public String world();
}