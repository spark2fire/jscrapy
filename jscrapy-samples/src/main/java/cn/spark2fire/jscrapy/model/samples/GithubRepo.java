package cn.spark2fire.jscrapy.model.samples;

import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.model.HasKey;
import cn.spark2fire.jscrapy.model.OOSpider;
import cn.spark2fire.jscrapy.model.annotation.ExtractBy;
import cn.spark2fire.jscrapy.model.annotation.ExtractByUrl;
import cn.spark2fire.jscrapy.model.annotation.HelpUrl;
import cn.spark2fire.jscrapy.model.annotation.TargetUrl;
import cn.spark2fire.jscrapy.pipeline.JsonFilePageModelPipeline;
import cn.spark2fire.jscrapy.scheduler.FileCacheQueueScheduler;

import java.util.List;

/**
 * @author code4crafter@gmail.com <br>
 */
@TargetUrl("https://github.com/\\w+/\\w+")
@HelpUrl({"https://github.com/\\w+\\?tab=repositories","https://github.com/\\w+","https://github.com/explore/*"})
public class GithubRepo implements HasKey {

    @ExtractBy(value = "//h1[@class='entry-title public']/strong/a/text()", notNull = true)
    private String name;

    @ExtractByUrl("https://github\\.com/(\\w+)/.*")
    private String author;

    @ExtractBy("//div[@id='readme']")
    private String readme;

    @ExtractBy(value = "//div[@class='repository-lang-stats']//li//span[@class='lang']",multi = true)
    private List<String> language;

    @ExtractBy("//a[@class='social-count js-social-count']/text()")
    private String star;

    @ExtractBy("//a[@class='social-count js-social-count']/text()")
    private String fork;

    @ExtractByUrl
    private String url;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(0).setRetryTimes(3),
                new JsonFilePageModelPipeline(), GithubRepo.class)
                .addUrl("https://github.com/explore")
                .setScheduler(new FileCacheQueueScheduler("/data/webmagic/cache/")).thread(15).run();
    }

    @Override
    public String key() {
        return author+":"+name;
    }

    public String getName() {
        return name;
    }

    public String getReadme() {
        return readme;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getLanguage() {
        return language;
    }

    public String getUrl() {
        return url;
    }

    public String getStar() {
        return star;
    }

    public String getFork() {
        return fork;
    }
}
