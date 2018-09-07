package Tools.Tool;

import Tools.Logger.LoggerControler;

/**
 * Created by Administrator on 2017/9/27.
 */
public class Time {
    final static LoggerControler log = LoggerControler.getLogger(Time.class);
    public static void wait(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            log.error("Wait发生了一个错误...");
        }
    }
}
