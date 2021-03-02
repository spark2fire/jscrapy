package cn.spark2fire.jscrapy.handler;

import cn.spark2fire.jscrapy.Request;

/**
 * @author code4crafer@gmail.com
 * @since 0.5.0
 */
public interface RequestMatcher {

    /**
     * Check whether to process the page.<br><br>
     * Please DO NOT change page status in this method.
     *
     * @param page page
     *
     * @return whether matches
     */
    public boolean match(Request page);

    public enum MatchOther {
        YES, NO
    }
}
