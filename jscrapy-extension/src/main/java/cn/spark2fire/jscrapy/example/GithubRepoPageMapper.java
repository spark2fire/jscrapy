package cn.spark2fire.jscrapy.example;

import cn.spark2fire.jscrapy.Page;
import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.Spider;
import cn.spark2fire.jscrapy.model.PageMapper;
import cn.spark2fire.jscrapy.processor.PageProcessor;

/**
 * @author code4crafter@gmail.com <br>
 * @since 0.3.2
 */
public class GithubRepoPageMapper implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(0);

    private PageMapper<GithubRepo> githubRepoPageMapper = new PageMapper<GithubRepo>(GithubRepo.class);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+)").all());
        GithubRepo githubRepo = githubRepoPageMapper.get(page);
        if (githubRepo == null) {
            page.setSkip(true);
        } else {
            page.putField("repo", githubRepo);
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageMapper()).addUrl("https://github.com/code4craft").thread(5).run();
    }
}