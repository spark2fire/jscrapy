package cn.spark2fire.jscrapy.model;

import cn.spark2fire.jscrapy.Page;

/**
 * Interface to be implemented by page models that need to do something after fields are extracted.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.2.0
 */
public interface AfterExtractor {

    public void afterProcess(Page page);
}
