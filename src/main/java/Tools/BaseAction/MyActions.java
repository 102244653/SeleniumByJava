package Tools.BaseAction;

import Tools.BaseDriver.MyDriver;
import Tools.Element.WaitElement;
import Tools.Logger.LoggerControler;
import Tools.Tool.Time;
import Tools.Tool.MyRobot;
import Tools.Tool.MyDate;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by Administrator on 2017/9/27.
 */
public class MyActions extends MyDriver {
    final static LoggerControler log = LoggerControler.getLogger(MyActions.class);

    //单击某个元素,T--元素名称
    public static void click(By by) {
        if(by!=null){
            WaitElement.findElement(by).click();
            log.info("点击" + by);
        }else {
            log.info("未查找到元素："+ by);
        }

    }
    //单机某个元素并显示元素名称
    public static void click(By by,String T) {
        if(by!=null) {
            WaitElement.findElement(by).click();
            log.info("点击" + T);
        }else {
            log.info("未查找到元素："+ by);
        }
    }

    //单机某个元素并显示元素名称
    public static void openurl(String url) {
        driver.get(url);
        log.info("打开网页：" + url);
    }

    //给某个元素发送文本信息,W--录入框名称
    public static void sendText(By by, String text) {
        if(by!=null){
            WebElement element = WaitElement.findElement(by);
            element.clear();
            element.sendKeys(text);
            log.info("在" + by + "输入：" + text);
        }else {
            log.info("未查找到元素："+ by);
        }
    }

    //通过键盘输入一个值
    public static void actiontext(By by,String text){
        if(by!=null){
        WaitElement.findElement(by).click();
        Actions action = new Actions(driver);
        action.sendKeys(text).perform();
        log.info("通过键盘输入了" + text);
        }else {
            log.info("未查找到元素："+ by);
        }
    }

    //键盘输入一个只并且按下确认键
    public static void actiontextkey(By by,String text) throws Exception {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException el) {
            el.printStackTrace();
        }
        if(by!=null) {
            Actions action = new Actions(driver);
            WaitElement.findElement(by).click();
            action.sendKeys(text).perform();
            log.info("输入：" + text);
            Time.wait(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Time.wait(1000);
        }else {
            log.info("未查找到元素："+ by);
        }
    }

    //获取某个元素的文本信息,W--获取信息对象的名称
    public static String getText(By by) {
        String text = null;
        if (by != null) {
            for (int i = 0; i <= 15; i++) {
                text = WaitElement.findElement(by).getText().trim();
                if (i == 15) {
                    log.info("未读取到" + by + "文本信息");
                }
                if (text.length() == 0) {
                    Time.wait(1000);
                } else {
                    log.info("读取" + by + "文本信息:" + text);
                    break;
                }
            }
        }else {
            log.info("未查找到元素："+ by);
        }
        return text;
    }

    //读取文本信息并打印
    public static void printText(By by) {
        if (by != null) {
            String text = WaitElement.findElement(by).getText();
            log.info(text);
        }else {
            log.info("未查找到元素："+ by);
        }
    }

    //获取多个元素的文本信息
    public static ArrayList getTexts(By by) {
        ArrayList arrayList = new ArrayList();
        if (by != null) {
            try {
                java.util.List<WebElement> list = WaitElement.findElements(by);
                for (int j = 0; j < list.size(); j++) {
                    String text = list.get(j).getText();
                    arrayList.add(text);
                }
                log.info("读取文本信息:" + arrayList);
            } catch (Exception e) {
                log.info("读取文本信息失败");
                arrayList = null;
            } finally {
                return arrayList;
            }
        } else {
            log.info("未查找到元素："+ by);
            return  arrayList = null;
        }
    }

    //移动鼠标到某元素上--悬停
    public static void moveandwait( By by) {
        if (by != null) {
            Actions action = new Actions(driver);
            WebElement E1 = WaitElement.findElement(by);
            action.moveToElement(E1).perform();
            log.info("鼠标移动到" + by + "上面！");
        } else {
            log.info("未查找到元素："+ by);
        }
    }

    //移动鼠标到某元素并点击
    public static void moveandclick( By by) {
        if (by != null) {
        Actions action = new Actions(driver);
        WebElement E1 = WaitElement.findElement(by);
        action.moveToElement(E1).perform();
        E1.click();
        log.info("点击元素"+by);
        } else {
            log.info("未查找到元素："+ by);
        }
    }

    //下拉框操作
    public static void selectindex( By by,int A ){
        if (by != null) {
            try {
                Select SH = new Select(driver.findElement(by));
                SH.selectByIndex(A);
                log.info(by + "下拉框选择了第" + A + "个值");
            }catch (Exception e){
                log.error("下拉框选择失败");
            }
        } else {
            log.info("未查找到元素："+ by);
        }

    }
    public static void  selectvalue( By by,String text ){
        if (by != null) {
            try {
                Select SH = new Select(driver.findElement(by));
                SH.selectByValue(text);
                log.info(by+"下拉框选择了"+text);
            }catch (Exception e){
                log.error("下拉框选择失败");
            }
        } else {
            log.info("未查找到元素："+ by);
        }
    }

    public static void  selecttext( By by,String text){
        if (by != null) {
            try {
            Select SH = new Select(driver.findElement(by));
            SH.selectByVisibleText(text);
            log.info(by+"下拉框选择了"+text);
            }catch (Exception e){
            log.error("下拉框选择失败");
             }
        } else {
            log.info("未查找到元素："+ by);
        }
    }
    public static void  selectText( By by,String text) {
        if (by != null) {
        Select SH = new Select(driver.findElement(by));
        SH.selectByVisibleText(text);
        log.info(by+"下拉框选择了"+text);
        } else {
            log.info("未查找到元素："+ by);
        }
    }



    //进入iframe
    public static  void intoF(String frame,By by) {
        if (by != null) {
        try{
            driver.switchTo().frame(frame);
            if(WaitElement.findE(by)){
                log.info("进入"+frame+"成功");
            }else {
                log.error("进入" + frame + "失败");
            }
        }catch (Exception e){
            log.error("进入" + frame + "失败");
            e.printStackTrace();
        }
        } else {
            log.info("未查找到元素："+ by);
        }
    }

    //2个窗口切换
    public static void changewindow( ){
        String oldwindow=driver.getWindowHandle();
        Set<String> Id2=driver.getWindowHandles();
        log.info("当前窗口总数：" + String.valueOf(Id2.size()));
        for(String id:Id2){
            if(id==oldwindow){
                continue;
            }else {
                driver.switchTo().window(id);
            }
        }
    }

    //关闭当前窗口以外的窗口
    public static  void  closeotherWindow(){
        Object[] handles=driver.getWindowHandles().toArray();
        String  currentwindow=driver.getWindowHandle();
        for(int i=0;i<handles.length;i++){
            if(!(handles[i].toString().equalsIgnoreCase(currentwindow))){
                driver.switchTo().window(handles[i].toString());
                driver.close();
            }
        }
        driver.switchTo().window(currentwindow);
    }

    //切回默认窗口框架
    public static  void outF() throws Exception{
        driver.switchTo().defaultContent();
    }

    //模糊查询选择
    public static void down(){
        new MyRobot().robot().keyPress(KeyEvent.VK_DOWN);
        new MyRobot().robot().keyRelease(KeyEvent.VK_DOWN);
        Time.wait(1000);
    }

    //打印消息
    public static void print(String text){log.info(text);}

    //enter
    public static void enter(){
        new MyRobot().robot().keyPress(KeyEvent.VK_ENTER);
        new MyRobot().robot().keyRelease(KeyEvent.VK_ENTER);
    }
    //报错信息打印
    public static void error(String text){
        log.error(text);
    }

    public static void clear(By by){
        if (by != null) {
            WaitElement.findElement(by).clear();
        }else {
            log.info("未查找到元素："+ by);
        }
    }

    //获取单号
    public static String getnum(By by,int i) {
        if (by != null) {
        String str = WaitElement.findElement(by).getText();
        String num =str.substring(i);
        return num;
        }else {
            log.info("未查找到元素："+ by);
            return null;
        }
    }

    public static String getstr(By by,int i,int j) {
        if (by != null) {
        String str = WaitElement.findElement(by).getText();
        String num =str.substring(i,j);
        return num;
        }else {
            log.info("未查找到元素："+ by);
            return null;
        }
    }
    //获取焦点
    public static void focus(By by){
        if (by != null) {
        driver.switchTo().activeElement().findElement(by);
        }else {
            log.info("未查找到元素：" + by);
        }
    }

    //调用js
    public static void js(String js){
        ((JavascriptExecutor) driver).executeScript(js);
        log.info("通过JS传入参数");
    }

    public static WebElement getEle(By by,int i){
        if (by != null) {
        return WaitElement.findElements(by).get(i);
        }else {
            log.info("未查找到元素：" + by);
            return null;
        }
    }

    //等待30秒让元素可见
    public static void Display30(By by){
        WebDriverWait webDriverWait=new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(WaitElement.findElement(by))).isDisplayed();
    }

    //判断元素是否显示
    public static boolean isDisplayed(By by) {
        WebElement webElement=WaitElement.findElement(by);
        webElement.isEnabled();
        log.info("元素显示状态为：" + webElement.isDisplayed());
        return webElement.isDisplayed();
    }

    //判断一组元素是否存在
    public static boolean isPresent(By locator, int timeOut) throws InterruptedException
    {
        boolean isPresent = false;
        Thread.sleep(timeOut * 1000);
        java.util.List<WebElement> we =WaitElement.findElements(locator);
        if (we.size() != 0) {
            isPresent = true;
        }
        log.info("判断结果为：" + isPresent);
        return isPresent;
    }

    //多窗口切换
    public  static void switchToWindow(int i)
    {
        String[] handls=new String[driver.getWindowHandles().size()];
        driver.getWindowHandles().toArray(handls);
        driver.switchTo().window(handls[i]);
    }

    //鼠标双击操作
    public  static void click_double(By by ) {
        WebElement webElement=WaitElement.findElement(by);
        Actions actions=new Actions(driver);
        actions.doubleClick(webElement).perform();
    }

    // 鼠标右键操作
    public static void click_right(By locator) {
        WebElement webElement=WaitElement.findElement(locator);
        Actions actions=new Actions(driver);
        actions.contextClick(webElement).perform();
    }

    /**
     * 点击确认按钮
     */
    public  static void alertConfirm() {
        Alert alert=driver.switchTo().alert();
        try {
            alert.accept();
            log.info("点击确认按钮");
        } catch (NoAlertPresentException notFindAlert) {
            // TODO: handle exception
            //throw notFindAlert;
            log.error("找不到确认按钮");
            throw notFindAlert;
        }
    }
    /**
     * 点击取消按钮
     */
    public static void alertDismiss() {
        Alert alert= driver.switchTo().alert();
        try {
            alert.dismiss();
            log.info("点击取消按钮");
        } catch (NoAlertPresentException notFindAlert) {
            // TODO: handle exception
            //throw notFindAlert;
            log.error("找不到取消按钮");
            throw notFindAlert;
        }
    }
    /**
     * 获取对话框文本
     * @return 返回String
     */
    public static String getAlertText() {
        Alert alert=driver.switchTo().alert();
        try {
            String text=alert.getText().toString();
            log.info("获取对话框文本："+text);
            return text;
        } catch (NoAlertPresentException notFindAlert) {
            // TODO: handle exception
            log.error("找不到对话框");
            throw notFindAlert;
        }
    }

    //将页面滚动条拖到底部
    public static void tounder(){
        ((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=10000");
        Time.wait(1000);
    }

    //将页面滚动条拖到顶部
    public static void totop(){
        ((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=0");
        Time.wait(1000);
    }

    //将页面滚动条拖到页面中间
    public static void TN(){
        ((JavascriptExecutor)driver).executeScript("scrollBy(0, 0-document.body.scrollHeight *1/2)");
    }

    //左右中间
    public static void RL() {
        ((JavascriptExecutor)driver).executeScript("scrollBy(0, 0-document.body.scrollWidht *1/2)");
    }

    //时间控件使用js录入时间
    public static void TimeControl(String ControlName,String timetype) {
        String date= MyDate.format(timetype);
        String js="$(function(){$(\"input[name='" + ControlName +"']\").removeAttr('readonly');" +
                "$(\"input[name='" + ControlName +"']\").val(\"" + date + "\");})";
        ((JavascriptExecutor) driver).executeScript(js);
        System.out.println(js);
    }

    //获取项目路径
    public static String getpath(){
        return System.getProperty("user.dir");
    }
}
