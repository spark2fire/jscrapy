package cn.spark2fire.jscrapy.interceptor;

public interface Interceptor {
    void intercept(Class<?> clazz);
    void setNextInterceptor(Interceptor interceptor);
    Interceptor getNextInterceptor();
}
