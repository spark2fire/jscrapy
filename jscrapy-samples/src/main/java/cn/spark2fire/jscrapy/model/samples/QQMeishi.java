package cn.spark2fire.jscrapy.model.samples;

import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.model.ConsolePageModelPipeline;
import cn.spark2fire.jscrapy.model.OOSpider;
import cn.spark2fire.jscrapy.model.annotation.ExtractBy;
import cn.spark2fire.jscrapy.model.annotation.TargetUrl;

/**
 * @author code4crafter@gmail.com
 */
@TargetUrl("http://meishi.qq.com/beijing/c/all[\\-p2]*")
@ExtractBy(value = "//ul[@id=\"promos_list2\"]/li",multi = true)
public class QQMeishi {

    @ExtractBy("//div[@class=info]/a[@class=title]/h4/text()")
    private String shopName;

    @ExtractBy("//div[@class=info]/a[@class=title]/text()")
    private String promo;

    public static void main(String[] args) {
        OOSpider.create(Site.me(), new ConsolePageModelPipeline(), QQMeishi.class).addUrl("http://meishi.qq.com/beijing/c/all").thread(4).run();
    }

}
