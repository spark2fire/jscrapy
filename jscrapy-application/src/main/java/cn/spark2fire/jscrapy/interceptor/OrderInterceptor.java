package cn.spark2fire.jscrapy.interceptor;

import cn.spark2fire.jscrapy.annotation.Order;
import cn.spark2fire.jscrapy.entity.ProcessorBean;

import java.lang.reflect.Field;

public class OrderInterceptor implements Interceptor {

    private Interceptor nextInterceptor;

    @Override
    public void intercept(Class<?> clazz, ProcessorBean processorBean) {
        Order annotation = clazz.getAnnotation(Order.class);
        int order = annotation.value();
        processorBean.order = order;
    }

    @Override
    public void setNextInterceptor(Interceptor interceptor) {
        this.nextInterceptor = interceptor;
    }

    @Override
    public Interceptor getNextInterceptor() {
        return nextInterceptor;
    }
}
