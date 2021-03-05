package cn.spark2fire.jscrapy;

import cn.spark2fire.jscrapy.annotation.Order;

public class AnnotationTest {
    public static void main(String[] args) {
        Class<?> clazz = TestProcessor.class;
        //判断是否有注解
        boolean hasAnnotation = clazz.isAnnotationPresent(Order.class);
        if (hasAnnotation) {
            Order annotation = clazz.getAnnotation(Order.class);
            int order = annotation.value();
            System.out.println(order);
        }
    }
}
