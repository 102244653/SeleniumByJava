package Tools.Tool;

import Tools.BaseAction.MyActions;
import Tools.Logger.LoggerControler;
import org.openqa.selenium.By;

import java.awt.event.KeyEvent;

/**
 * Created by Administrator on 2017/9/27.
 */
public class MyUpload {
    final static LoggerControler log = LoggerControler.getLogger(MyUpload.class);
    //by1--任意文本输入框，用来记录上传文件path
    //path--调用方法之前先取出文件路径并保存
    //by2--文件上传按钮
    public  void upload(By by1,String path,By by2) {
        MyRobot robot = new MyRobot();
        MyActions.sendText(by1, path);
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_A);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_A);
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_C);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_C);
        MyActions.click(by2);
        Time.wait(1000);
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_V);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_V);
        Time.wait(1000);
        robot.robot().keyPress(KeyEvent.VK_ENTER);
        robot.robot().keyRelease(KeyEvent.VK_ENTER);
        log.info("已选择上传文件,路径为：" + path);
        Time.wait(1000);
        MyActions.clear(by1);
    }

    public  void uploadjs(By by1,String path,String js) {
        MyRobot robot = new MyRobot();
        MyActions.sendText(by1, path);
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_A);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_A);
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_C);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_C);
        MyActions.js(js);
        Time.wait(1000);
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_V);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_V);
        Time.wait(1000);
        robot.robot().keyPress(KeyEvent.VK_ENTER);
        robot.robot().keyRelease(KeyEvent.VK_ENTER);
        log.info("已选择上传文件,路径为：" + path);
        Time.wait(1000);
        MyActions.clear(by1);
    }

    public  void copy(By by,String path) {
        MyActions.clear(by);
        MyActions.sendText(by, path);
        MyRobot robot = new MyRobot();
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_A);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_A);
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_C);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_C);
        Time.wait(1000);
        MyActions.clear(by);
    }

    public  void paste(By by) {
        MyActions.click(by);
        Time.wait(1000);
        MyRobot robot = new MyRobot();
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_V);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_V);
        Time.wait(1000);
        robot.robot().keyPress(KeyEvent.VK_ENTER);
        robot.robot().keyRelease(KeyEvent.VK_ENTER);
    }

    public  void paste() {
        MyRobot robot = new MyRobot();
        robot.robot().keyPress(KeyEvent.VK_CONTROL);
        robot.robot().keyPress(KeyEvent.VK_V);
        robot.robot().keyRelease(KeyEvent.VK_CONTROL);
        robot.robot().keyRelease(KeyEvent.VK_V);
        Time.wait(1000);
        robot.robot().keyPress(KeyEvent.VK_ENTER);
        robot.robot().keyRelease(KeyEvent.VK_ENTER);
    }
}
