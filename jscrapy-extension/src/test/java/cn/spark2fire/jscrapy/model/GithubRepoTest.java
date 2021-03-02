package cn.spark2fire.jscrapy.model;

import cn.spark2fire.jscrapy.downloader.MockGithubDownloader;
import org.junit.Test;
import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.Task;
import cn.spark2fire.jscrapy.example.GithubRepo;
import cn.spark2fire.jscrapy.pipeline.PageModelPipeline;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafter@gmail.com <br>
 */
public class GithubRepoTest {

    @Test
    public void test() {
        OOSpider.create(Site.me().setSleepTime(0)
                , new PageModelPipeline<GithubRepo>() {
            @Override
            public void process(GithubRepo o, Task task) {
                assertThat(o.getStar()).isEqualTo(86);
                assertThat(o.getFork()).isEqualTo(70);
            }
        }, GithubRepo.class).addUrl("https://github.com/code4craft/webmagic").setDownloader(new MockGithubDownloader()).test("https://github.com/code4craft/webmagic");
    }

}
