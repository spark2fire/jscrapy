package cn.spark2fire.jscrapy.impl;

import cn.spark2fire.jscrapy.Spider;
import cn.spark2fire.jscrapy.downloader.selenium.SeleniumDownloader;
import cn.spark2fire.jscrapy.entity.ProcessorBean;
import cn.spark2fire.jscrapy.pipeline.ConsolePipeline;
import cn.spark2fire.jscrapy.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessorRunner {

    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private List<ProcessorBean> processorBeans = new ArrayList<>();
    private boolean hasDriver;
    private Pipeline pipeline;

    public ProcessorRunner(boolean hasDriver, Pipeline pipeline) {
        this.hasDriver = hasDriver;
        this.pipeline = pipeline;
    }

    public void addProcessorBean(ProcessorBean processorBean) {
        processorBeans.add(processorBean);
    }

    public Pipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    public void start() {
        Spider spider = null;
        if (hasDriver) {
            for (ProcessorBean processorBean : processorBeans) {
                spider = Spider.create(processorBean.getProcessor())
                        .addPipeline(pipeline != null ? pipeline : new ConsolePipeline())
                        .setDownloader(new SeleniumDownloader().setSleepTime(500))
                        .addUrl(processorBean.getUrl());
                executorService.submit(spider);
            }
        } else {
            for (ProcessorBean processorBean : processorBeans) {
                spider = Spider.create(processorBean.getProcessor())
                        .addPipeline(pipeline != null ? pipeline : new ConsolePipeline())
                        .addUrl(processorBean.getUrl());
                executorService.submit(spider);
            }
        }

    }
}
