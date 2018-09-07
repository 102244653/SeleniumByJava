package Tools.BaseDriver;

import Tools.Logger.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/9/27.
 */
public class MyDriver {
    final static LoggerControler log = LoggerControler.getLogger(MyDriver.class);
    public static WebDriver driver;
    String path= System.getProperty("user.dir");

    @Parameters({"driver"})//testng.xml数据驱动传入driver
    public void setup(String browser) throws MalformedURLException {
        log.info("------------------开始执行测试---------------");
        //log.info("读取testng.xml配置的"+browser+"浏览器并将其初始化");
            try {
                driver=setDriver(browser);
            } catch (Exception e) {
                log.error("没有成功浏览器环境配置错误");
                e.printStackTrace();
            }
    }

    public void closebrowser() {
        driver.close();
        log.info("-------------结束测试，关闭浏览器-------------");
    }

    public void tearDown() {
        driver.close();
        driver.quit();
        log.info("-------------结束测试，并关闭退出浏览器-------------");
    }


    private WebDriver setDriver(String browsername)
    {
        switch (browsername)
        {
            case "Firefox" :
                driver = new FirefoxDriver();
                //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                log.info("火狐已经打开！");
                break;
            case "Chrome":

                System.setProperty("webdriver.chrome.driver",path+"/driver/chromedriver.exe");
                driver = new ChromeDriver();
                //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                break;
            case "IE":
                DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
                dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                dc.setCapability("ignoreProtectedModeSettings", true);
                System.setProperty("webdriver.ie.driver", path + "/driver/IEDriver64.exe");
                driver=new InternetExplorerDriver(dc);
                //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                log.info("IE已经打开！");
                break;
            default:
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                log.info("默认火狐浏览器已经打开！");
                break;
        }
        return driver;
    }
}
