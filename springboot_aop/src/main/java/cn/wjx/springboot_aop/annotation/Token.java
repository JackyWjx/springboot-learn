package cn.wjx.springboot_aop.annotation;

import java.lang.annotation.*;

/**
 * @author wjx
 * @date 2020/7/9 11:17
 * @description:自定义注解
 */

@Target({ElementType.METHOD, ElementType.TYPE}) //注解出现的位置
@Retention(RetentionPolicy.RUNTIME) //注解的保留时间
@Documented
public @interface Token {
    String value() default "";
}
