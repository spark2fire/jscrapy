package cn.spark2fire.jscrapy.interceptor;

import cn.spark2fire.jscrapy.annotation.SUrl;
import cn.spark2fire.jscrapy.entity.ProcessorBean;

public class SUrlInterceptor implements Interceptor {
    @Override
    public void intercept(Class<?> clazz, ProcessorBean processorBean) {
        SUrl annotation = clazz.getAnnotation(SUrl.class);
        if (annotation != null) {
            String url = annotation.value();
            processorBean.setUrl(url);
        }
    }

    @Override
    public void setNextInterceptor(Interceptor interceptor) {

    }

    @Override
    public Interceptor getNextInterceptor() {
        return null;
    }
}
