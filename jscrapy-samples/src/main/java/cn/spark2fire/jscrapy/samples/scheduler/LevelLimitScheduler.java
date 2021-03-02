package cn.spark2fire.jscrapy.samples.scheduler;

import cn.spark2fire.jscrapy.Request;
import cn.spark2fire.jscrapy.Task;
import cn.spark2fire.jscrapy.scheduler.PriorityScheduler;

/**
 * @author code4crafter@gmail.com
 */
public class LevelLimitScheduler extends PriorityScheduler {

    private int levelLimit = 3;

    public LevelLimitScheduler(int levelLimit) {
        this.levelLimit = levelLimit;
    }

    @Override
    public synchronized void push(Request request, Task task) {
        if (((Integer) request.getExtra("_level")) <= levelLimit) {
            super.push(request, task);
        }
    }
}
