package cn.spark2fire.jscrapy.downloader;

import cn.spark2fire.jscrapy.Page;
import cn.spark2fire.jscrapy.Request;
import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.Task;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafter@gmail.com
 *         Date: 2017/11/29
 *         Time: 下午1:32
 */
public class SSLCompatibilityTest {

    @Test
    public void test_tls12() throws Exception {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Task task = Site.me().setCycleRetryTimes(5).toTask();
        Request request = new Request("https://juejin.im/");
        Page page = httpClientDownloader.download(request, task);
        assertThat(page.isDownloadSuccess()).isTrue();
    }
}
