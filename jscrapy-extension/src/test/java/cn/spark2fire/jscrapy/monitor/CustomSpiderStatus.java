package cn.spark2fire.jscrapy.monitor;

import cn.spark2fire.jscrapy.Spider;

/**
 * @author code4crafer@gmail.com
 */
public class CustomSpiderStatus extends SpiderStatus implements CustomSpiderStatusMXBean {

    public CustomSpiderStatus(Spider spider, SpiderMonitor.MonitorSpiderListener monitorSpiderListener) {
        super(spider, monitorSpiderListener);
    }


    @Override
    public String getSchedulerName() {
        return spider.getScheduler().getClass().getName();
    }
}
