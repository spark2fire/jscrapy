package cn.spark2fire.jscrapy.interceptor;

import java.lang.reflect.Field;

public class OrderInterceptor implements Interceptor {

    private Interceptor nextInterceptor;

    @Override
    public void intercept(Class<?> clazz) {
        String value = "";
        Field[] fields = clazz.getDeclaredFields();
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
