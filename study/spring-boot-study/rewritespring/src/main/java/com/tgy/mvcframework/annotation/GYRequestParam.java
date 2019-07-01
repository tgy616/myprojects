package com.tgy.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * @author DragonSwimDiving
 * @program rewritespring
 * @Date 2019-06-24 17:05
 **/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GYRequestParam {
    String value() default "";
}
