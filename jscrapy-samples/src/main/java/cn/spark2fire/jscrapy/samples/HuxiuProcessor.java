package cn.spark2fire.jscrapy.samples;

import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.Page;
import cn.spark2fire.jscrapy.Spider;
import cn.spark2fire.jscrapy.processor.PageProcessor;

import java.util.List;

/**
 * @author code4crafter@gmail.com <br>
 */
public class HuxiuProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        List<String> requests = page.getHtml().links().regex(".*article.*").all();
        page.addTargetRequests(requests);
        page.putField("title",page.getHtml().xpath("//div[@class='clearfix neirong']//h1/text()"));
        page.putField("content",page.getHtml().xpath("//div[@id='neirong_box']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return Site.me().setDomain("www.huxiu.com");
    }

    public static void main(String[] args) {
        Spider.create(new HuxiuProcessor()).addUrl("http://www.huxiu.com/").run();
    }

}