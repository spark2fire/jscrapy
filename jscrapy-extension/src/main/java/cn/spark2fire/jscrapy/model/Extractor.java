package cn.spark2fire.jscrapy.model;

import cn.spark2fire.jscrapy.selector.Selector;

/**
 * The object contains 'ExtractBy' information.
 * @author code4crafter@gmail.com <br>
 * @since 0.2.0
 */
class Extractor {

    protected Selector selector;

    protected final Source source;

    protected final boolean notNull;

    protected final boolean multi;

    static enum Source {Html, Url, RawHtml, RawText}

    public Extractor(Selector selector, Source source, boolean notNull, boolean multi) {
        this.selector = selector;
        this.source = source;
        this.notNull = notNull;
        this.multi = multi;
    }

    Selector getSelector() {
        return selector;
    }

    Source getSource() {
        return source;
    }

    boolean isNotNull() {
        return notNull;
    }

    boolean isMulti() {
        return multi;
    }

    void setSelector(Selector selector) {
        this.selector = selector;
    }
}
