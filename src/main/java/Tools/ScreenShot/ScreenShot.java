package Tools.ScreenShot;

import Tools.BaseDriver.MyDriver;
import Tools.Logger.LoggerControler;
import Tools.MyListener.TestReport;
import Tools.Tool.MyDate;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/27.
 */
public class ScreenShot extends MyDriver{
    protected static final LoggerControler log = LoggerControler.getLogger(ScreenShot.class);
    static String path1 = System.getProperties().getProperty("user.dir") + "/test-output/screenshot/";
    static String path2 = System.getProperties().getProperty("user.dir") + "/TestReport/";
    /**
     * 错误截图
     **/
    public static String screenShots(int k) {
        String path;
        String picname;
        if(k==1){
            path=path1;
        }else if(k==2){
            path=path2;
        }else {
            return "空";
        }
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        try {
            //根据日期创建文件夹
            String nowdata= TestReport.dirc;
            File dir = new File(path +nowdata);
            String time=new MyDate().getdata(MyDate.time8);
            if (!dir.exists())
            {dir.mkdirs();}
            FileUtils.copyFile(file, new File(path +nowdata + "/" + time + ".png"));
             picname=nowdata + "/" +time+ ".png";
            log.info("截图："+picname);
        } catch (IOException e) {
            picname="001.png";
            log.error("截图失败！！");
            e.printStackTrace();
        }
        return picname;
    }

    /**
     * 错误截图
     **/
    public static String screenShots(int k,String name) {
        String picname;
        String path;
        if(k==1){
            path=path1;
        }else if(k==2){
            path=path2;
        }else {
            return "空";
        }
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        try {
            //根据日期创建文件夹
            String nowdata=TestReport.dirc;
            File dir = new File(path +nowdata);
            if (!dir.exists())
            {dir.mkdirs();}
            FileUtils.copyFile(file, new File(path +nowdata + "/" + name + ".png"));
            picname=name+".png";
            log.info("截图："+picname);
        } catch (IOException e) {
            picname="001.png";
            log.error("截图失败！！");
            e.printStackTrace();
        }
        return picname;
    }
}
