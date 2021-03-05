package cn.spark2fire.jscrapy.interceptor;

import cn.spark2fire.jscrapy.impl.ProcessorRunner;

import java.util.HashSet;
import java.util.Set;

public class InterceptorRunner {

    private Class<?> clazz;
    private Set<Interceptor> interceptors = new HashSet<>();

    public InterceptorRunner(Class<?> clazz) {
        interceptors.add(new OrderInterceptor());
        this.clazz = clazz;
    }

    public void clear() {
        interceptors = new HashSet<>();
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public Set<Interceptor> getInterceptors() {
        return interceptors;
    }

    public void invoke() {
        for (Interceptor interceptor : interceptors) {
            interceptor.intercept(clazz);
        }
    }
}
