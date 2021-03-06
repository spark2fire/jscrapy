package cn.spark2fire.jscrapy.interceptor;

import cn.spark2fire.jscrapy.entity.ProcessorBean;
import cn.spark2fire.jscrapy.processor.PageProcessor;
import cn.spark2fire.jscrapy.util.PriorityQueue;

import java.util.HashSet;
import java.util.Set;

public class InterceptorRunner {

    private Set<PageProcessor> processors;
    private Set<Interceptor> interceptors = new HashSet<>();

    public InterceptorRunner(Set<PageProcessor> processors) {
        interceptors.add(new OrderInterceptor());
        interceptors.add(new SUrlInterceptor());
        this.processors = processors;
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
        ProcessorBean bean;
        for (PageProcessor processor : processors) {
            bean = new ProcessorBean(99, "", processor);
            for (Interceptor interceptor : interceptors) {
                interceptor.intercept(processor.getClass(), bean);
            }
            result.insert(bean);
        }
        return result;
    }
}
