package cn.spark2fire.jscrapy.example;

import cn.spark2fire.jscrapy.ResultItems;
import cn.spark2fire.jscrapy.Spider;
import cn.spark2fire.jscrapy.Task;
import cn.spark2fire.jscrapy.downloader.MockGithubDownloader;
import cn.spark2fire.jscrapy.pipeline.Pipeline;
import cn.spark2fire.jscrapy.processor.example.GithubRepoPageProcessor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/1/19
 *         Time: 上午7:27
 */
public class GithubRepoPageProcessorTest {

    @Test
    public void test_github() throws Exception {
        Spider.create(new GithubRepoPageProcessor()).addPipeline(new Pipeline() {
            @Override
            public void process(ResultItems resultItems, Task task) {
                assertThat(((String) resultItems.get("name")).trim()).isEqualTo("webmagic");
                assertThat(((String) resultItems.get("author")).trim()).isEqualTo("code4craft");
            }
        }).setDownloader(new MockGithubDownloader()).test("https://github.com/code4craft/webmagic");
    }
}
