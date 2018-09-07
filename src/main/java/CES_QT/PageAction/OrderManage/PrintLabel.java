package CES_QT.PageAction.OrderManage;


import CES_QT.PageElement.OrderManage.PrintLablePage;
import TestData.QT_DATA.DHLtestData;
import TestData.QT_DATA.PrintLableData;
import Tools.Assert.MyAssert;
import Tools.BaseDriver.MyDriver;
import Tools.ScreenShot.ScreenShot;
import Tools.Tool.Time;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Tools.BaseAction.MyActions.*;

public class PrintLabel {
    public static void printOrderLabel(String ASnum_xpath) throws Exception{
        print("*****标签打印开始******");
        click(PrintLablePage.Lable);
        Time.wait(1000);
        intoF(PrintLablePage.iframe,PrintLablePage.Order_code);
        sendText(PrintLablePage.Order_code, PrintLableData.AS_Num);
        String windowID1 = MyDriver.driver.getWindowHandle();   //获取打印前页面ID
        print("获取打印前的窗口ID:" + windowID1);
        click(PrintLablePage.printBtn);  //点击打印
        outF();
        Time.wait(3000);
        for (String windowID: MyDriver.driver.getWindowHandles()) {
            print("获取打印后的窗口ID:" + windowID);//获取打印后页面ID
            if (windowID.equals(windowID1)){
                continue;
            }else {
                MyDriver.driver.switchTo().window(windowID);   //将鼠标焦点移动到点击后的页面
                String Lable_ASnum=getText(By.xpath(ASnum_xpath));
                print("面单上的AS单号为:" + Lable_ASnum);
                if (Lable_ASnum.contains(PrintLableData.AS_Num)){
                    print("面单打印成功");
                    MyAssert.assertTrue(true);
                }else {
                    MyAssert.assertTrue(false, "Error of single print");
                }
                MyDriver.driver.close();
                MyDriver.driver.switchTo().window(windowID1);
                outF();
            }
        }
    }
    //关闭打印出来的发票
    public void ClosePrintInvoice() throws  Exception{
        for(String windowID: MyDriver.driver.getWindowHandles()){
            print("提交打印发票后的窗口ID：" + windowID);
            if (windowID.equals( DHLtestData.windowID1)){
                continue;
            }else{
                MyDriver.driver.switchTo().window(windowID);
                MyDriver.driver.close();
                MyDriver.driver.switchTo().window( DHLtestData.windowID1);
                outF();
            }
        }
    }
    //打印DHL面单
    public static void printDHLOrderLabel(String ASnum_xpath) throws Exception{
        print("*****标签打印开始******");
        click(PrintLablePage.Lable);
        Time.wait(1000);
        intoF(PrintLablePage.iframe,PrintLablePage.Order_code);
        sendText(PrintLablePage.Order_code, PrintLableData.AS_Num);
        String windowID1 = MyDriver.driver.getWindowHandle();   //获取打印前页面ID
        print("获取打印前的窗口ID:" + windowID1);
        click(PrintLablePage.printBtn);  //点击打印
        outF();
        Time.wait(3000);
        for (String windowID: MyDriver.driver.getWindowHandles()) {
            print("获取打印后的窗口ID:" + windowID);
            if (windowID.equals(windowID1)){
                continue;
            }else {
                MyDriver.driver.switchTo().window(windowID);   //将鼠标焦点移动到点击后的页面
                String Order_num_DHLfile=getText(By.xpath(ASnum_xpath));//获取DHL面单上的标识
                print("面单上的标识为：:" + Order_num_DHLfile);
                if (Order_num_DHLfile.equals("DOX")){
                    print("DHL文件面单打印成功");
                }else if (Order_num_DHLfile.equals("WPX")){
                    print("DHL物品面单打印成功");
                    MyAssert.assertTrue(true);
                }else{
                   // ScreenShot.screenShots(2);
                    MyAssert.assertTrue(false, "Error of single print");
                }
                MyDriver.driver.close();
                MyDriver.driver.switchTo().window(windowID1);
                outF();
            }
        }
    }
}
