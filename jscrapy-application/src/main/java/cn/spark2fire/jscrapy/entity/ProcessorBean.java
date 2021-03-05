package cn.spark2fire.jscrapy.entity;

import cn.spark2fire.jscrapy.processor.PageProcessor;

public class ProcessorBean {
    private String url;
    private PageProcessor processor;

    public ProcessorBean(String url, PageProcessor processor) {
        this.url = url;
        this.processor = processor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PageProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(PageProcessor processor) {
        this.processor = processor;
    }
}
