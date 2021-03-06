package cn.spark2fire.jscrapy.boot;

import cn.spark2fire.jscrapy.entity.ProcessorBean;
import cn.spark2fire.jscrapy.impl.ProcessorRunner;
import cn.spark2fire.jscrapy.interceptor.InterceptorRunner;
import cn.spark2fire.jscrapy.pipeline.Pipeline;
import cn.spark2fire.jscrapy.processor.PageProcessor;
import cn.spark2fire.jscrapy.util.PackageLoader;
import cn.spark2fire.jscrapy.util.PriorityQueue;

import java.util.HashSet;
import java.util.Set;

public class SpiderApplication {
    public boolean isSelenium;
    private Pipeline pipeline;

    public SpiderApplication() {
        this.isSelenium = false;
        pipeline = null;
    }

    public Pipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    public void run(String packagePath, String... args) {
        try {
            Set<Class<?>> classes = PackageLoader.getClasses(packagePath, false);
            Set<PageProcessor> beans = new HashSet<>();
            for (Class<?> clazz : classes) {
                Object obj = clazz.newInstance();
                if (obj instanceof PageProcessor) {
                    beans.add((PageProcessor) obj);
                }
            }
            InterceptorRunner interceptorRunner = new InterceptorRunner(beans);
            PriorityQueue<ProcessorBean> queue = interceptorRunner.invoke();

            ProcessorRunner runner = new ProcessorRunner(isSelenium, pipeline);

            while (!queue.isEmpty()) {
                runner.addProcessorBean(queue.pop());
            }

            runner.start();
            System.out.println();
        } catch (InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SpiderApplication application = new SpiderApplication();
        application.run("cn.spark2fire.jscrapy.example");
    }
}
