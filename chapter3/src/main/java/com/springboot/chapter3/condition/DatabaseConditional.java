package com.springboot.chapter3.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.condition
 * @className : DatabaseConditional
 * @description : TODO
 * @date : 2022/11/16 09:34
 */
public class DatabaseConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.containsProperty("database.driverName")
                && env.containsProperty("database.url")
                && env.containsProperty("database.username")
                && env.containsProperty("database.password");
    }
}
