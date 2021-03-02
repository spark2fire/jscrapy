package cn.spark2fire.jscrapy.downloader;

import cn.spark2fire.jscrapy.Request;
import cn.spark2fire.jscrapy.Site;
import cn.spark2fire.jscrapy.utils.UrlUtils;
import org.junit.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafter@gmail.com
 *         Date: 2017/7/22
 *         Time: 下午5:29
 */
public class HttpUriRequestConverterTest {

    @Test
    public void test_illegal_uri_correct() throws Exception {
        HttpUriRequestConverter httpUriRequestConverter = new HttpUriRequestConverter();
        HttpClientRequestContext requestContext = httpUriRequestConverter.convert(new Request(UrlUtils.fixIllegalCharacterInUrl("http://bj.zhongkao.com/beikao/yimo/##")), Site.me(), null);
        assertThat(requestContext.getHttpUriRequest().getURI()).isEqualTo(new URI("http://bj.zhongkao.com/beikao/yimo/#"));
    }
}