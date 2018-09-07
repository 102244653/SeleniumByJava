package CES_QT.PageAction.QTLogin;

import CES_QT.PageElement.QTLogin.LoginPage;
import TestData.QT_DATA.UserInfo_QT;
import Tools.Assert.MyAssert;
import Tools.BaseAction.MyActions;
import Tools.BaseDriver.MyDriver;
import Tools.Element.WaitElement;
import org.openqa.selenium.By;
import org.testng.annotations.*;

/**
 * Created by Administrator on 2018/2/27.
 */
public class DoLogin {
    @BeforeSuite
    public void set(){
        new DeleteReport().DeleteReprot();
    }

    @BeforeClass
    public void setbrowser(){
        try {
            new MyDriver().setup("Firefox");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @BeforeMethod
    //@Test(priority = 0)
    public  void QT_Login(){
        try {
            MyActions.openurl(UserInfo_QT.QTURL);
            MyActions.sendText(LoginPage.username, UserInfo_QT.UserName);
            MyActions.sendText(LoginPage.password, UserInfo_QT.PassWord);
            MyActions.click(LoginPage.loginbotten);
            String Name=MyActions.getText(LoginPage.userinfo).trim();
            if(Name.contains(UserInfo_QT.Name)){
                MyActions.print("中邮TMS前台登录成功");
            }else {
                MyActions.print("登录异常，当前用户为："+Name);
            }
        }catch (Exception e){
            MyAssert.assertTrue(false, "中邮TMS前台登录失败，测试被迫中止...");
            e.printStackTrace();
        }
    }

    //@AfterMethod
    //@Test(priority = 1)
    public void QT_Logout(){
        try {
            MyActions.click(LoginPage.logout);
            String text=MyActions.getText(By.xpath("//a[text()='登录']")).trim();
            if(text.contains("登录")){
                MyActions.print("中邮TMS前台退出成功");
            }else {
                MyActions.print("中邮TMS前台退出异常");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public void out(){
        new MyDriver().tearDown();
    }

    public  void Login_QT(String browser)  {
        try {
            new MyDriver().setup(browser);
            MyActions.openurl(UserInfo_QT.QTURL);
            MyActions.sendText(LoginPage.username, UserInfo_QT.UserName);
            MyActions.sendText(LoginPage.password, UserInfo_QT.PassWord);
            MyActions.click(LoginPage.loginbotten);
            WaitElement.waitXS(LoginPage.userinfo,2);
            MyActions.print("中邮TMS前台登录成功");
        }catch (Exception e){
            MyAssert.assertTrue(false, "中邮TMS前台登录失败，测试被迫中止...");
            e.printStackTrace();
        }
    }
}
