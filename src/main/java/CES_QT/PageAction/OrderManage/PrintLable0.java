package CES_QT.PageAction.OrderManage;

import CES_QT.PageAction.QTLogin.DoLogin;
import CES_QT.PageElement.OrderManage.PrintLablePage;
import TestData.QT_DATA.PrintLableData;
import Tools.Assert.MyAssert;
import Tools.ScreenShot.ScreenShot;
import Tools.Tool.Time;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static Tools.BaseAction.MyActions.*;

/**
 * Created by Administrator on 2018/3/12.
 */
public class PrintLable0 extends DoLogin{
    //打开界面
    public static void OpenLablePage()throws Exception{
        print("*****标签打印开始******");
        click(PrintLablePage.Lable);
        intoF(PrintLablePage.iframe,PrintLablePage.Order_code);
    }

    //打印(DHL--0)
    public  static void printOrderLabel(int i,String ASnum_xpath)throws Exception{
        sendText(PrintLablePage.Order_code, PrintLableData.AS_Num);
        click(PrintLablePage.printBtn);
        Time.wait(1000);
        changewindow();
        closeotherWindow();
       // focus(By.xpath(ASnum_xpath));
        String Lable_ASnum=getText(By.xpath(ASnum_xpath));
       switch (i){
           case 0:
               if (Lable_ASnum.equals("DOX") || Lable_ASnum.equals("WPX")){
                   print("DHL文件面单打印成功");
               } else{
                   MyAssert.assertTrue(false, "Error of single print");
               }
               break;
           default:
               if (Lable_ASnum.contains(PrintLableData.AS_Num)){
                   print("面单打印成功");
                   MyAssert.assertTrue(true);
               }else {
                   MyAssert.assertTrue(false, "Error of single print");
               }
               break;
       }
    }

    @Test
    public void test(){
        try {
            this.OpenLablePage();
            this.printOrderLabel(1,PrintLableData.JapanFBA_LabelASnum_Japan);
        }catch (Exception e){

        }
    }


}
