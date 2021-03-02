package cn.spark2fire.jscrapy.processor;

import cn.spark2fire.jscrapy.downloader.MockGithubDownloader;
import junit.framework.Assert;
import org.junit.Test;
import cn.spark2fire.jscrapy.*;
import cn.spark2fire.jscrapy.model.OOSpider;
import cn.spark2fire.jscrapy.pipeline.Pipeline;

/**
 * @author code4crafter@gmail.com
 */
public class GithubRepoProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        page.putField("star",page.getHtml().xpath("//ul[@class='pagehead-actions']/li[2]//a[@class='social-count js-social-count']/text()").toString());
        page.putField("fork",page.getHtml().xpath("//ul[@class='pagehead-actions']/li[3]//a[@class='social-count']/text()").toString());
    }

    @Override
    public Site getSite() {
        return Site.me();
    }

    @Test
    public void test() {
        OOSpider.create(new GithubRepoProcessor()).addPipeline(new Pipeline() {
            @Override
            public void process(ResultItems resultItems, Task task) {
                Assert.assertEquals("78",((String)resultItems.get("star")).trim());
                Assert.assertEquals("65",((String)resultItems.get("fork")).trim());
            }
        }).setDownloader(new MockGithubDownloader()).test("https://github.com/code4craft/webmagic");
    }

}
