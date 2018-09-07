package Tools.Tool;

import Tools.BaseDriver.MyDriver;
import Tools.Logger.LoggerControler;
import org.openqa.selenium.JavascriptExecutor;

public class drag {
    final static LoggerControler log = LoggerControler.getLogger(drag.class);
    public static void dragMouse(){
        //将页面滑到最底端
        JavascriptExecutor executor = (JavascriptExecutor) MyDriver.driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        log.info("将页面滑到最底端");
    }
    public static void dragdown(){
        JavascriptExecutor executor = (JavascriptExecutor) MyDriver.driver;
        executor.executeScript("window.scrollTo(arguments[0],arguments[1]);", -30);
        log.info("将页面向下滑动20");
    }

}
