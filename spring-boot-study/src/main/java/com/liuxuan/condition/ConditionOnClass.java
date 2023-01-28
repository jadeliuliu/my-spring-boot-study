package com.liuxuan.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author: liuxuan
 * @date: 2022-12-26 09:48
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ClassCondition.class)
public @interface ConditionOnClass {
    String[] value();
}
