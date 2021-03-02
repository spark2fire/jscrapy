package cn.spark2fire.jscrapy.samples;

import cn.spark2fire.jscrapy.Page;
import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.Spider;
import cn.spark2fire.jscrapy.downloader.selenium.SeleniumDownloader;
import cn.spark2fire.jscrapy.pipeline.FilePipeline;
import cn.spark2fire.jscrapy.processor.PageProcessor;

/**
 * 花瓣网抽取器。<br>
 * 使用Selenium做页面动态渲染。<br>
 * @author code4crafter@gmail.com <br>
 * Date: 13-7-26 <br>
 * Time: 下午4:08 <br>
 */
public class HuabanProcessor implements PageProcessor {

    private Site site;

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("http://huaban\\.com/.*").all());
        if (page.getUrl().toString().contains("pins")) {
            page.putField("img", page.getHtml().xpath("//div[@class='image-holder']/a/img/@src").toString());
        } else {
            page.getResultItems().setSkip(true);
        }
    }

    @Override
    public Site getSite() {
        if (null == site) {
            site = Site.me().setDomain("huaban.com").setSleepTime(0);
        }
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new HuabanProcessor()).thread(5)
                .addPipeline(new FilePipeline("/data/webmagic/test/"))
                .setDownloader(new SeleniumDownloader("/Users/yihua/Downloads/chromedriver"))
                .addUrl("http://huaban.com/")
                .runAsync();
    }
}
