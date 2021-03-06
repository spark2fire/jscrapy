package cn.spark2fire.jscrapy.model.samples;

import cn.spark2fire.jscrapy.Page;
import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.model.*;
import cn.spark2fire.jscrapy.model.annotation.ExtractBy;
import cn.spark2fire.jscrapy.model.annotation.HelpUrl;
import cn.spark2fire.jscrapy.model.annotation.TargetUrl;

/**
 * @author code4crafter@gmail.com <br>
 */
@TargetUrl("http://www.oschina.net/question/\\d+_\\d+*")
@HelpUrl("http://www.oschina.net/question/*")
@ExtractBy(value = "//ul[@class='list']/li[@class='Answer']", multi = true)
public class OschinaAnswer implements AfterExtractor{

    @ExtractBy("//img/@title")
    private String user;

    @ExtractBy("//div[@class='detail']")
    private String content;

    public static void main(String[] args) {
        OOSpider.create(Site.me(), OschinaAnswer.class).addUrl("http://www.oschina.net/question/567527_120597").run();
    }

    @Override
    public void afterProcess(Page page) {

    }
}
