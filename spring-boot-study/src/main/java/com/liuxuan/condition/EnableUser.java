package com.liuxuan.condition;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: liuxuan
 * @date: 2022-12-30 19:29
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(UserConfig.class)
public @interface EnableUser {
}
