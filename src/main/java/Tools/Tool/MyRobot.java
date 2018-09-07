package Tools.Tool;

import java.awt.*;

/**
 * Created by Administrator on 2017/7/21.
 * java键盘鼠标操作类
 */
public class MyRobot {
    public  Robot robot() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return robot;
    }
}
