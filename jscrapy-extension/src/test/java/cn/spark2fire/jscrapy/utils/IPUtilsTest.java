package cn.spark2fire.jscrapy.utils;

import org.junit.Test;

/**
 * @author code4crafer@gmail.com
 */
public class IPUtilsTest {

    @Test
    public void testGetFirstNoLoopbackIPAddresses() throws Exception {
        System.out.println(IPUtils.getFirstNoLoopbackIPAddresses());
    }
}
