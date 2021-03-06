package cn.spark2fire.jscrapy.interceptor;

import cn.spark2fire.jscrapy.entity.ProcessorBean;

public interface Interceptor {
    void intercept(Class<?> clazz, ProcessorBean processorBean);

    void setNextInterceptor(Interceptor interceptor);

    Interceptor getNextInterceptor();
}
