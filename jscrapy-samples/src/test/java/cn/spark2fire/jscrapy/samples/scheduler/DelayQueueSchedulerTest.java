package cn.spark2fire.jscrapy.samples.scheduler;

import org.junit.Ignore;
import org.junit.Test;
import cn.spark2fire.jscrapy.Request;

import java.util.concurrent.TimeUnit;

/**
 * @author code4crafter@gmail.com
 */
public class DelayQueueSchedulerTest {

    @Ignore("infinite")
    @Test
    public void test() {
        DelayQueueScheduler delayQueueScheduler = new DelayQueueScheduler(1, TimeUnit.SECONDS);
        delayQueueScheduler.push(new Request("1"), null);
        while (true){
            Request poll = delayQueueScheduler.poll(null);
            System.out.println(System.currentTimeMillis()+"\t"+poll);
        }
    }
}
