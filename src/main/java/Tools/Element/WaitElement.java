package Tools.Element;

import Tools.Assert.MyAssert;
import Tools.BaseAction.MyActions;
import Tools.BaseDriver.MyDriver;
import Tools.Logger.LoggerControler;
import Tools.ScreenShot.ScreenShot;
import Tools.Tool.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */
public class WaitElement extends MyDriver {
    final static LoggerControler log = LoggerControler.getLogger(WaitElement.class);
    //等待单个元素
    public static WebElement findElement(final By by) {
        try {
            //等待元素出现，10s之后即超时
            WebElement webElement = new WebDriverWait(driver, 10).until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {return driver.findElement(by);}
            });
            return webElement;
        } catch (Exception e) {
            WebElement webElement=null;
            log.error("元素:" + by + "查找失败");
            return webElement;
        }
    }


    //等待多个元素
    public static List<WebElement> findElements(final By by) {
        try {
            List<WebElement> webElement = new WebDriverWait(driver, 10).until(new ExpectedCondition<List<WebElement>>() {
                public List<WebElement> apply(WebDriver driver) {return driver.findElements(by);}
            });
            return webElement;
        } catch (Exception e) {
            log.error("元素:" + by + "查找失败");
            List<WebElement> webElement = null;
            return webElement;
        }
    }

    //显性等待单个元素x秒
    public static void waitEle(By by,int i){
        boolean isexit=false;
        if(i<1){
            log.error("等待时间必须大于1s");
            return;}
        WebDriverWait wait=new WebDriverWait(driver,i);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //等待某个元素2s直到出现
    public static boolean waitXS(By by, int i){
        boolean isexit=false;
        if(i<1){
            log.error("等待时间必须大于1s");
            return isexit;
        }
        for (int second = 0;second<=i; second++) {
            WebElement Ele=findElement(by);
            if (Ele!= null){
                isexit= true;break;
            }else {
                if (second==i){log.warn("元素" + by + "未找到");}
                Time.wait(1000);
            }
        }
        return isexit;
    }

    //判断某个元素是否出现
    public static boolean findE(By by){
        boolean isexit1 ;
        WebElement Ele=findElement(by);
        if (Ele!= null){
            isexit1= true;
        }else{
            isexit1=false;
            log.warn("元素" + by + "未找到");
        }
        return isexit1;
    }

    //判断某个元素出现在界面
    public static boolean Eledisplay(By by){
        boolean isdisplay=false;
        for (int i = 0; i <2; i++) {
            WebElement Ele = findElement(by);
            if (Ele == null||Ele.isDisplayed() == false) {
                Time.wait(1000);
            }else {
                isdisplay = true;
            }
        }
        return isdisplay;
    }
}
