package cn.spark2fire.jscrapy.model;

import cn.spark2fire.jscrapy.model.annotation.ExtractBy;

/**
 * @author code4crafter@gmail.com
 */
public class BaseRepo {

    @ExtractBy("//ul[@class='pagehead-actions']/li[1]//a[@class='social-count js-social-count']/text()")
    protected int star;
}
