package cn.spark2fire.jscrapy.monitor;

/**
 * @author code4crafer@gmail.com
 */
public interface CustomSpiderStatusMXBean extends SpiderStatusMXBean {

    public String getSchedulerName();

}
