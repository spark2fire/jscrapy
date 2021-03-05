package cn.spark2fire.jscrapy.boot;

import cn.spark2fire.jscrapy.pipeline.Pipeline;

public class SpiderApplication {
    private boolean isSelenium;
    private Pipeline pipeline;

    public SpiderApplication(){
        this.isSelenium = false;
        pipeline = null;
    }

    public void run(String packagePath, String... args) {
    }
}
