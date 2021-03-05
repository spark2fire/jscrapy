package cn.spark2fire.jscrapy.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SUrl {
    String value() default "";
}
