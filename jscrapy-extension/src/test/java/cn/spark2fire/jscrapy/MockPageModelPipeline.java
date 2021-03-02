package cn.spark2fire.jscrapy;

import cn.spark2fire.jscrapy.pipeline.PageModelPipeline;
import junit.framework.Assert;

/**
 * @author code4crafter@gmail.com
 */
public class MockPageModelPipeline implements PageModelPipeline {
    @Override
    public void process(Object o, Task task) {
        Assert.assertNotNull(o);
    }
}
