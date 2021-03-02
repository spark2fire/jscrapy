package cn.spark2fire.jscrapy.model;

import org.apache.commons.io.IOUtils;
import cn.spark2fire.jscrapy.Page;
import cn.spark2fire.jscrapy.Request;
import cn.spark2fire.jscrapy.selector.PlainText;

import java.io.IOException;

/**
 * @author code4crafter@gmail.com
 *         Date: 2017/6/3
 *         Time: 下午9:08
 */
public class PageMocker {

    public Page getMockJsonPage() throws IOException {
        Page page = new Page();
        page.setRawText(IOUtils.toString(PageMocker.class.getClassLoader().getResourceAsStream("json/mock-githubrepo.json")));
        page.setRequest(new Request("https://api.github.com/repos/code4craft/webmagic"));
        page.setUrl(new PlainText("https://api.github.com/repos/code4craft/webmagic"));
        return page;
    }

    public Page getMockPage() throws IOException {
        Page page = new Page();
        page.setRawText(IOUtils.toString(PageMocker.class.getClassLoader().getResourceAsStream("html/mock-webmagic.html")));
        page.setRequest(new Request("http://webmagic.io/list/0"));
        page.setUrl(new PlainText("http://webmagic.io/list/0"));
        return page;
    }
}
