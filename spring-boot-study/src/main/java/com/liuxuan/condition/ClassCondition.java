package com.liuxuan.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author: liuxuan
 * @date: 2022-12-26 09:24
 **/
public class ClassCondition implements Condition {
    /**
     * @param context  上下文对象。用于获取环境、Ioc容器、classLoader对象
     * @param metadata 注解元对象，可以用于获取注解定义的属性值
     * @return boolean
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 需求1：写创建bean的条件：导入jedis坐标后创建bean
//        try {
//            Class cls = Class.forName("redis.clients.jedis.Jedis");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;

        // 需求2：通过注解属性值value指定坐标后创建bean
        Map<String, Object> map = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
        String[] value = (String[])map.get("value");
        try {
            for (String className : value) {
                Class<?> cls = Class.forName(className);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
