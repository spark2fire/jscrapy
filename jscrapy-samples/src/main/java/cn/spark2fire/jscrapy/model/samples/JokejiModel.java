package cn.spark2fire.jscrapy.model.samples;

import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.model.ConsolePageModelPipeline;
import cn.spark2fire.jscrapy.model.OOSpider;
import cn.spark2fire.jscrapy.model.annotation.ExtractBy;
import cn.spark2fire.jscrapy.model.annotation.HelpUrl;
import cn.spark2fire.jscrapy.model.annotation.TargetUrl;
import cn.spark2fire.jscrapy.scheduler.RedisScheduler;

/**
 * @author code4crafter@gmail.com
 */
@TargetUrl("http://www.jokeji.cn/jokehtml/jy/\\d+.htm")
@HelpUrl("http://www.jokeji.cn/list\\w+.htm")
public class JokejiModel {

    @ExtractBy("//title/regex('<title>([^_]+)',1)")
    private String title;

    @ExtractBy("//div[@class=mob_txt]/tidyText()")
    private String content;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setDomain("www.jokeji.cn").setCharset("gbk").setSleepTime(100).setTimeOut(3000)
                .setUserAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)")
                , new ConsolePageModelPipeline(), JokejiModel.class).addUrl("http://www.jokeji.cn/").thread(2)
                .scheduler(new RedisScheduler("127.0.0.1"))
                .run();
    }

}
