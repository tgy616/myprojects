package com.tgy.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * @author DragonSwimDiving
 * @program rewritespring
 * @Date 2019-06-24 16:59
 **/
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GYRequestMapping {
    String value() default "";
}
