package cn.spark2fire.jscrapy.entity;

import cn.spark2fire.jscrapy.processor.PageProcessor;

public class ProcessorBean implements Comparable {
    public int order;
    private String url;
    private PageProcessor processor;

    public ProcessorBean(int order, String url, PageProcessor processor) {
        this.order = order;
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

    @Override
    public int compareTo(Object obj) {
        if (obj instanceof ProcessorBean) {
            if (this.order > ((ProcessorBean) obj).order) {
                return 1;
            } else if (this.order == ((ProcessorBean) obj).order) {
                return 0;
            } else {
                return -1;
            }
        }
        return -99;
    }
}
