package cn.spark2fire.jscrapy.interceptor;

import cn.spark2fire.jscrapy.entity.ProcessorBean;
import cn.spark2fire.jscrapy.util.PriorityQueue;

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

    public PriorityQueue<ProcessorBean> invoke() {
        PriorityQueue<ProcessorBean> result = new PriorityQueue<>();
        for (Interceptor interceptor : interceptors) {
            interceptor.intercept(clazz);
        }
        return result;
    }
}
