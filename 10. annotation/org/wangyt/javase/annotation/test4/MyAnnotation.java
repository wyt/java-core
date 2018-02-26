package org.wangyt.javase.annotation.test4;

/**
 * @author 王永涛
 *
 * @since 2012-7-8 下午09:24:59
 *
 */
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/*
 * @Targer 指定其所修饰的注解可以修饰哪些元素
 * @author Javakxs.Wong
 * 
 */
@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
public @interface MyAnnotation {
}
