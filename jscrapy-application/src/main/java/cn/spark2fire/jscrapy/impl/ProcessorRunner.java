package cn.spark2fire.jscrapy.impl;

import cn.spark2fire.jscrapy.Spider;
import cn.spark2fire.jscrapy.downloader.selenium.SeleniumDownloader;
import cn.spark2fire.jscrapy.entity.ProcessorBean;
import cn.spark2fire.jscrapy.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessorRunner {

    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private List<ProcessorBean> processorBeans = new ArrayList<>();
    private Pipeline pipeline;

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
        for (ProcessorBean processorBean : processorBeans) {
            spider = Spider.create(processorBean.getProcessor())
                    .setDownloader(new SeleniumDownloader().setSleepTime(500))
                    .addUrl(processorBean.getUrl());
            executorService.submit(spider);
        }
    }
}
