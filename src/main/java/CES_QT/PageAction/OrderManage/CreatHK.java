package CES_QT.PageAction.OrderManage;

import CES_QT.PageElement.OrderManage.HKPage;
import TestData.QT_DATA.HKtestData;
import Tools.Assert.MyAssert;
import Tools.BaseDriver.MyDriver;
import Tools.Element.WaitElement;
import Tools.Tool.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static Tools.BaseAction.MyActions.*;

public class CreatHK {

    //打开HKEMS录单界面
    public void OpenHKpage() throws Exception {
        print("*****HKEMS录单开始******");
        click(HKPage.HK_list);
        Time.wait(1000);
        intoF(HKPage.iframe, HKPage.product_code);
    }
    //录入发件人信息
    public void Shipper_Info() throws Exception {
        print("*****录入发件人信息******");
        sendText(HKPage.shipper_name, HKtestData.shipper_name);
        sendText(HKPage.shipper_telephone, "72129110");
        sendText(HKPage.shipper_company,"ZongTeng");
        sendText(HKPage.shipper_city,"shenzhen");
        sendText(HKPage.shipper_postcode,"518000");
        sendText(HKPage.shipperstree, "510 MINZHI DA DAO");
        sendText(HKPage.shipperstree1, "610 MINZHI DA DAO");
        sendText(HKPage.shipperstree2, "710 MINZHI DA DAO");
        Time.wait(1000);
    }
    public void Consignee_Info() throws Exception {
        print("*****录入收件人信息******");
        sendText(By.id("consignee_name"), "ChangQi");
        sendText(By.id("consignee_telephone"), "72129160");
        selectText(By.id("consignee_city"), "沙田区");
        sendText(By.id("consignee_street"), "9A Griffin Ave,Ep");
        sendText(By.id("consignee_street2"),"9B Griffin Ave,Ep");
        sendText(By.id("consignee_street3"), "9C Griffin Ave,Ep");
        sendText(By.id("consignee_company"), "BaiDu");
        Time.wait(1000);
    }
    //选着内件
    public void order_type(int i) throws Exception {
        /**i 为内件性质
         * i=1 选择文件
         * i=2 选择物品
         * */
        JavascriptExecutor executor = (JavascriptExecutor) MyDriver.driver;
        executor.executeScript("window.scrollTo(arguments[0],arguments[1]);", -30);    //滑动鼠标滚动到指定坐标所处的位置
        switch (i) {
            case 1:
                click(HKPage.File_type);
                break;
            case 2:
                click(HKPage.Goods_type);
                break;
            default:
                click(HKPage.File_type);
        }

    }
    public void orderinfo(int k) throws Exception {
        print("*****录入文件信息******");
        JavascriptExecutor executor = (JavascriptExecutor)  MyDriver.driver;
        executor.executeScript("window.scrollTo(arguments[0],arguments[1]);", -30);     //滑动鼠标滚动到指定坐标所处的位置
        click(By.xpath(".//*[@id='orderForm']/div[2]/div[2]/input[1]")); //选择文件
        click(By.id("addtr"));
        Time.wait(1000);
        for(int i=2;i<=k;i++){
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr["+i+"]/td[1]/input"),"2");
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr["+i+"]/td[2]/input"),"3");
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr["+i+"]/td[3]/input"),"10");
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr["+i+"]/td[4]/input"),"10");
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr["+i+"]/td[5]/input"),"10");
        }
        sendText(By.name("invoice[invoice_cnname][]"),"测试中文品名");
        Time.wait(1000);
        sendText(By.name("invoice[invoice_enname][]"), "TestGood");
    }

    public void submit() throws Exception {
        JavascriptExecutor executor = (JavascriptExecutor)  MyDriver.driver;
        ((JavascriptExecutor) MyDriver.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//j将页面滑到最底端
        click(By.xpath(".//*[@id='plane2']/div[2]/div[1]"));
        click(By.id("allow")); //勾选我同意
        click(By.id("orderSubmitBtn"));
        Time.wait(1000);
        WaitElement.Eledisplay(By.xpath(".//*[@id='success-tip']/p")); //等待订单提交预报成功
        String result1 = getText(By.xpath(".//*[@id='success-tip']/p"));
        if (result1.contains("订单提交预报成功")) {
            print("订单录入成功");
            HKtestData.HKEMSordernumeber=String.valueOf(getnum(By.xpath(".//*[@id='success-tip']/p"), 14));
            Time.wait(1000);
            MyAssert.assertTrue(true);
        } else {
            print("订单录入失败");
            MyAssert.assertTrue(false, "订单录入失败");
        }
    }
}
