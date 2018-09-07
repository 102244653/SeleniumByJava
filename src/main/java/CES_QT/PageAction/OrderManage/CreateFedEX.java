package CES_QT.PageAction.OrderManage;

import CES_QT.PageElement.OrderManage.FedexPage;
import TestData.QT_DATA.FedExtestData;
import Tools.Assert.MyAssert;
import Tools.BaseDriver.MyDriver;
import Tools.Element.WaitElement;
import Tools.Tool.RandomNum;
import Tools.Tool.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static Tools.BaseAction.MyActions.*;

public class CreateFedEX {
    public void openpage() throws Exception{
        print("*****FedEx录单开始******");
        click(By.linkText("中速-FedEx录单"));
        Time.wait(1000);
        intoF("resultFrame", By.name("shipper[shipper_name]"));
    }
    public void shipper() throws Exception{
        sendText(By.name("shipper[shipper_name]"), "Mr.tian");
        sendText(By.name("shipper[shipper_company]"),"ZongTeng");
        sendText(By.name("shipper[shipper_telephone]"),"15823666849");
        sendText(By.name("shipper[shipper_city]"), "SHAOXING");
        click(By.xpath(".//*[@id='checkcity']/li[3]"));
        sendText(By.id("shipperstree"), "chongqingbeiA");
        sendText(By.id("shipperstree1"), "chongqingbeiB");
        Time.wait(1000);
    }
    public void consignee() throws Exception{
        sendText(By.name("consignee[consignee_name]"), "wangtia2");
        sendText(By.name("consignee[consignee_company]"), "KAMMM");
        sendText(By.name("consignee[consignee_telephone]"), "72129110");
        selectText(By.id("country_code"), "US [美国 UNITED STATES OF AMERICA]");
        sendText(By.name("consignee[consignee_postcode]"), "4659");
        sendText(By.name("consignee[consignee_province]"), "IN");
        sendText(By.name("consignee[consignee_city]"), "WINONA LAKE");
        sendText(By.id("consignee_street"), "streetc1");
        sendText(By.id("consignee_street2"), "streetc2");
        Time.wait(1000);
        click(By.xpath(".//*[@id='orderForm']/div[1]/div[5]/div[2]/ul/li/div/label[2]/input")); //选择寄件人付关税
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
                click(FedexPage.File_type);
                break;
            case 2:
                click(FedexPage.Goods_type);
                break;
            default:
                click(FedexPage.File_type);
        }

    }
    public void File_orderinfo( ) throws Exception{
        sendText(By.className("laydate-icon"), "2017-12-14");
        selectText(By.id("services_code"), "INTERNATIONAL_PRIORITY");
        selectText(By.id("packtype"), "FedEx 快递封");
        sendText(By.id("consignmentvalue"), "22");
        sendText(By.id("invoice_totalcharge_all"),"22");
        //  use.sendText(By.id("refer_hawbcode"),"testABC");
        sendText(By.id("fpnote"), "22");
        Time.wait(1000);
    }
    public void Goods_orderinfo( ) throws Exception{
        //click(By.className(ordertype));
        click(By.name("order[invoice_print]"));
        click(By.xpath(".//*[@id='orderForm']/div[1]/div[2]/div[2]/div/span"));//填写商业发票
        for (int i=1;i<=3;i++) {
            click(By.xpath(".//*[@id='orderForm']/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/span"));
        }
        for (int i=1;i<=3;i++){
            sendText(By.xpath(".//*[@id='orderForm']/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[1]/input"),"Testgoogs");
            sendText(By.xpath(".//*[@id='orderForm']/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/table/tbody/tr["+i+"]/td[2]/input"),""+ RandomNum.getNumRandom(10));
            selectvalue(By.xpath(".//*[@id='orderForm']/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/table/tbody/tr[" + i + "]/td[3]/select"), "AZ");
        }
        click(By.xpath(".//*[@id='orderForm']/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/span[1]"));
        sendText(By.className("laydate-icon"), "2017-12-14");
        selectText(By.id("services_code"), "INTERNATIONAL_ECONOMY");
        selectText(By.id("packtype"), "自备包装");
        sendText(By.id("boxNum"), "3");
        click(By.id("sizeInfo"));
        for (int i=2;i<=4;i++){
            sendText(By.xpath(".//*[@id='packInfo']/tbody/tr["+i+"]/td[1]/input"), "5");
            sendText(By.xpath(".//*[@id='packInfo']/tbody/tr["+i+"]/td[2]/input"), "5");
            sendText(By.xpath(".//*[@id='packInfo']/tbody/tr["+i+"]/td[3]/input"), "5");
            sendText(By.xpath(".//*[@id='packInfo']/tbody/tr["+i+"]/td[4]/input"), "5");
            sendText(By.xpath(".//*[@id='packInfo']/tbody/tr["+i+"]/td[1]/input"), "5");
        }
        click(By.xpath(".//*[@id='orderForm']/div[1]/div[4]/div[2]/ul/li[4]/div/div/div[2]/div[3]/span[1]"));
        sendText(By.id("order_weight"), "20");
        sendText(By.id("consignmentvalue"),"100");
        sendText(By.id("invoice_totalcharge_all"),"100");

        sendText(By.id("fpnote"), "22");
        Time.wait(1000);
        click(By.xpath(".//*[@id='orderForm']/div[1]/div[2]/div[2]/div/span"));
        Time.wait(1000);;
        click(By.xpath(".//*[@id='orderForm']/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/span[1]"));

    }
    public void submit() throws Exception{
        click(By.id("allow")); //勾选发件人协议
        Time.wait(1000);
        click(By.id("orderSubmitBtn")); //提交并打印面单
        WaitElement.Eledisplay(By.xpath(".//*[@id='success-tip']/p")); //等待订单提交预报成功
        String result1 = getText(By.xpath(".//*[@id='success-tip']/p"));
        if (result1.contains("订单提交预报成功")) {
            print("订单录入成功");
            FedExtestData.FedExorderNumeber=String.valueOf(getnum(By.xpath(".//*[@id='success-tip']/p"), 14));
            Time.wait(1000);
        } else {
            System.out.println("订单录入失败");
            MyAssert.assertTrue(false, "订单录入失败");
        }
    }
}
