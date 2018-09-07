package CES_QT.PageElement.QTLogin;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2018/2/27.
 * 登录界面元素
 */
public class LoginPage {
    public static By username=By.id("userName");
    public static By password=By.id("userPass");
    public static By loginbotten=By.className("loginbtn");

    //登录成功之后
    //退出按钮
    public static By logout=By.xpath("//li[@class='logout']/a");
    //用户名
    public static By userinfo=By.className("username");
}
