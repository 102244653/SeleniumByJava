package CES_QT.PageAction.OrderManage;

import CES_QT.PageAction.QTLogin.DoLogin;
import CES_QT.PageElement.OrderManage.DHLPage;
import TestData.QT_DATA.DHLtestData;
import Tools.Assert.MyAssert;
import Tools.BaseDriver.MyDriver;
import Tools.Element.WaitElement;
import Tools.Tool.RandomNum;
import Tools.Tool.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


import static Tools.BaseAction.MyActions.*;

public class CreateDHL extends DoLogin {
    //打开DHL录单界面
    public void OpenDHLpage() throws Exception {
        print("*****DHL录单开始******");
        click(DHLPage.DHL_list);
        Time.wait(1000);
        intoF(DHLPage.iframe, DHLPage.product_code);
    }

    //录入发件人信息
    public void Shipper_Info() throws Exception {
        //选择产品种类
        // selectText(DHLPage.product_code,"G_DHL[中速-DHL DHL]");
        /**发件人信息*/
        //联系人姓名
        sendText(DHLPage.shipper_name, DHLtestData.shipper_name);
        //公司名称
        sendText(DHLPage.shipper_company, DHLtestData.shipper_company);
        //发件人邮编
        sendText(DHLPage.shipper_postcode, DHLtestData.shipper_postcode);
        //发件人地址1
        sendText(DHLPage.shipperstree, DHLtestData.shipperstree);
        //发件人地址2
        sendText(DHLPage.shipperstree1, DHLtestData.shipperstree1);
        //发件人地址3
        sendText(DHLPage.shipperstree2, DHLtestData.shipperstree2);
        //发件人城市
        sendText(DHLPage.shipper_city, DHLtestData.shipper_city);
        //发件人电话
        sendText(DHLPage.shipper_telephone, DHLtestData.shipper_telephone);
    }
    //填写收件人信息
    public void Consignee_Info() throws Exception {
        //收件人公司
        sendText(DHLPage.consignee_company, DHLtestData.consignee_company);
        //收件人国家
        selectText(DHLPage.country_code, DHLtestData.country_code);
        //收件人地址1
        sendText(DHLPage.consignee_street, DHLtestData.consignee_street);
        //收件人地址2
        sendText(DHLPage.consignee_street2, DHLtestData.consignee_street2);
        //收件人地址3
        sendText(DHLPage.consignee_street3, DHLtestData.consignee_street3);
        //收件人城市
        sendText(DHLPage.consignee_city, DHLtestData.consignee_city);
        //收件人姓名
        sendText(DHLPage.consignee_name, DHLtestData.consignee_name);
        //收件人邮编
        sendText(DHLPage.consignee_postcode, DHLtestData.consignee_postcode);
        //英国邮编后输入框
        sendText(DHLPage.GBEXT, DHLtestData.GBEXT);
        //收件人电话
        sendText(DHLPage.consignee_telephone, DHLtestData.consignee_telephone);
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
                click(DHLPage.File_type);
                break;
            case 2:
                click(DHLPage.Goods_type);
                break;
            default:
                click(DHLPage.File_type);
        }

    }
    //录入内件信息
    public void order_Info(int k) throws Exception {
        print("*****录入内件信息******");
        click(DHLPage.addtr);
        Time.wait(1000);
        for (int i = 2; i <= k; i++) {
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr[" + i + "]/td[1]/input"), "2");
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr[" + i + "]/td[2]/input"), "3");
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr[" + i + "]/td[3]/input"), "10");
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr[" + i + "]/td[4]/input"), "10");
            sendText(By.xpath(".//*[@id='tb1']/tbody/tr[" + i + "]/td[5]/input"), "10");
        }
        sendText(DHLPage.invoice_cnname, DHLtestData.invoice_cnname);
        Time.wait(1000);
        sendText(DHLPage.invoice_enname, DHLtestData.invoice_enname);
    }

    //填写物品发票信息
    public void Invoice(int n) throws Exception {
        JavascriptExecutor executor = (JavascriptExecutor) MyDriver.driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");//j将页面滑到最底端
        sendText(DHLPage.invoice_shippertax, "" + RandomNum.getNumRandom(10)); //发件人增值税号
        sendText(DHLPage.invoice_consigneetax, "" + RandomNum.getNumRandom(10));//收件人增值税号
        sendText(DHLPage.invoice_totalcharge_all,DHLtestData.invoice_totalcharge_all);
        sendText(DHLPage.hs_code, "" + RandomNum.getNumRandom(10));
        click(DHLPage.extraservice); //选择保险
        sendText(DHLPage.insurance_value_gj, DHLtestData.insurance_value_gj);
        click(DHLPage.makeinvoice); //选择制作发票
        click(DHLPage.Commercial_invoice); //选择商业发票
        sendText(DHLPage.makeinvoicedate, "2017-12-14");
        sendText(DHLPage.invoicenum, "" + RandomNum.getNumRandom(10));
        for (int i = 2; i <= n; i++) {
            sendText(By.xpath(".//*[@id='tb2']/tbody/tr[" + i + "]/td[1]/input"), "测试商品");
            sendText(By.xpath(".//*[@id='tb2']/tbody/tr[" + i + "]/td[2]/input"), "1");
            sendText(By.xpath(".//*[@id='tb2']/tbody/tr[" + i + "]/td[3]/input"), "test0001");
            sendText(By.xpath(".//*[@id='tb2']/tbody/tr[" + i + "]/td[4]/input"), "44");
        }

    }
    public void submit() throws Exception {
        JavascriptExecutor executor = (JavascriptExecutor) MyDriver.driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");//j将页面滑到最底端
        click(DHLPage.allow); //勾选我同意
        DHLtestData.windowID1 =String.valueOf( MyDriver.driver.getWindowHandle()); //获取提交前的windowID1
        click(DHLPage.orderSubmitBtn);
       Time.wait(1000);
       WaitElement.Eledisplay(DHLPage.sucessSubmitBtntxt); //等待订单提交预报成功
        String result1 = getText(DHLPage.sucessSubmitBtntxt);
        if (result1.contains("订单提交预报成功")) {
            print("订单录入成功");
            MyAssert.assertTrue(true);
            DHLtestData.DHLorderNumeber=String.valueOf(getnum(DHLPage.sucessSubmitBtntxt, 14));
            Time.wait(1000);
        } else {
            System.out.println("订单录入失败");
            MyAssert.assertTrue(false, "订单录入失败");
        }
    }
}

