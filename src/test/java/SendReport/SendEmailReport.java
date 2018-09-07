package SendReport;

import TestData.GlobalData;
import Tools.Logger.LoggerControler;
import Tools.MyListener.TestReport;
import Tools.SendEmail.SendMail;
import Tools.SendEmail.ToZip;
import Tools.Tool.MyFile;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/2/2.
 */
public class SendEmailReport {
    protected static final LoggerControler log = LoggerControler.getLogger(SendEmailReport.class);

    @Test
    public  void SendEmailReport()throws Exception{
        String ZipPath=System.getProperties().getProperty("user.dir")+"\\TestReport\\";
        boolean flag = ToZip.fileToZip(ZipPath+TestReport.dirc, ZipPath, TestReport.dirc);
        if(flag){
            log.info(TestReport.dirc + ".zip文件打包成功!");
        }else{
            log.error("文件打包失败!");
        }
        new SendMail().SendReport(GlobalData.title,GlobalData.content,ZipPath+TestReport.dirc+".zip");
        if(flag=true){
            try {
                new MyFile().deleteDirectory(ZipPath+TestReport.dirc+".zip");
                log.info("删除文件成功");
            }catch (Exception e){}
        }
    }
}
