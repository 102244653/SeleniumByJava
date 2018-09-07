package CES_QT.PageAction.OrderManage;

import CES_QT.PageAction.QTLogin.DoLogin;
import CES_QT.PageElement.OrderManage.ESBPage;
import TestData.QT_DATA.ESBtestData;
import TestData.QT_DATA.PrintLableData;
import Tools.Assert.MyAssert;
import Tools.BaseDriver.MyDriver;
import Tools.Element.WaitElement;
import Tools.ScreenShot.ScreenShot;
import Tools.Tool.RandomNum;
import Tools.Tool.Time;
import Tools.Tool.drag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


import static Tools.BaseAction.MyActions.*;

public class CreatESB extends DoLogin{
    /**打开E速宝录单界面*/
    public void OpenESBpage()throws Exception{
        click(ESBPage.ESB_list);
        Time.wait(1000);
        intoF(ESBPage.iframe, ESBPage.product_code_chosen);
    }
    /**录入订单信息*/
     public void OrderInfo(String Product_Code ,String Country_Code) throws Exception{
        click(ESBPage.product_code_chosen);
         actiontextkey(ESBPage.product_code_chosen_input,Product_Code); //选择服务方式
        click(ESBPage.country_code_chosen);
         actiontextkey(ESBPage.country_code_chosen_input,Country_Code); //选择国家
         Time.wait(1000);
         //客户单号
         sendText(ESBPage.refer_hawbcode, RandomNum.getStringRandom(20));
         //货物重量
         sendText(ESBPage.order_weight,ESBtestData.order_weight);
         //货物件数
         sendText(ESBPage.order_pieces, ESBtestData.order_pieces);
         //包裹申报种类
         selectText(ESBPage.mail_cargo_type, ESBtestData.mail_cargo_type);
         //是否带电池
         selectText(ESBPage.battery, ESBtestData.battery);
         //长
         sendText(ESBPage.order_length, ESBtestData.order_length);
         //宽
         sendText(ESBPage.order_width,ESBtestData.order_width);
         //高
         sendText(ESBPage.order_height,ESBtestData.order_height);
     }
    /**填写收件人信息*/
    public void consignee(String consignee_city,String consignee_postcode)throws Exception{
        print("*****录入收件人信息******");
        //收件人公司
        sendText(ESBPage.company, ESBtestData.company);
        //收件人，省，收件人电话，城市，手机，邮箱
        sendText(ESBPage.reciver, ESBtestData.reciver);
        sendText(ESBPage.province, ESBtestData.province);
        sendText(ESBPage.recallnum, ESBtestData.recallnum);
        sendText(ESBPage.recity, consignee_city);
        sendText(ESBPage.rephonenum, ESBtestData.rephonenum);
        sendText(ESBPage.reemail, ESBtestData.reemail);
        Time.wait(1000);
        //收件人邮编，地址1，地址2，地址3，证件类型，证件号码，有效期
        sendText(ESBPage.consignee_postcode, consignee_postcode);
        sendText(ESBPage.consignee_street, ESBtestData.consignee_street);
        sendText(ESBPage.consignee_doorplate, ESBtestData.consignee_doorplate);
        sendText(ESBPage.consignee_street2, ESBtestData.consignee_street2);
        sendText(ESBPage.consignee_street3, ESBtestData.consignee_street3);
        selectText(ESBPage.cardtype, ESBtestData.cardtype);
        sendText(ESBPage.cardnum, ESBtestData.cardnum);
        sendText(ESBPage.endtime,ESBtestData.endtime);
    }
    /**录入内件信息*/
    public void product(int k)throws Exception{
        JavascriptExecutor executor = (JavascriptExecutor)  MyDriver.driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");//j将页面滑到最底端
        for(int i=1;i<k;i++){
            click(By.id("btn_addtr"));
            Time.wait(1000);
        }
        for(int i=1;i<=k;i++){
            sendText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[1]/input"),"testgood"+i);
            sendText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[2]/input"),"测试商品A"+i);
            sendText(By.xpath(".//*[@id='dynamicTable']/tbody/tr[" + i + "]/td[3]/input"), "2");
            if(i==2){
                selectText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[4]/select"), "SET(套)");
            }else if (i==3){
                selectText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[4]/select"), "PCE(件)");
            }else {
                selectText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[4]/select"), "MTR(米)");
            }
            sendText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[5]/input"), "3");
            sendText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[7]/input"),"0.2");
            sendText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[9]/input"),"iii"+i);
            sendText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[10]/input"),"666"+i);
            sendText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[11]/input"),"配货信息测试"+i);
            sendText(By.xpath(".//*[@id='dynamicTable']/tbody/tr["+i+"]/td[12]/input"),"销售地址测试"+i);
        }
    }

    //选择发件人,i--发件人序号
    public void SelectSender(int i)throws Exception{
        switch (i){
            case 1:
                click(ESBPage.sender1);
                break;
            case 2:
                click(ESBPage.sender2);
                break;
            case 3:
                click(ESBPage.sender3);
                break;
            default:
                click(ESBPage.sender1);
                break;
        }
    }

    //提交订单
    public void submit()throws Exception{
        drag.dragMouse(); //将页面滑到最底端
        click(ESBPage.submitesb);
        Time.wait(1000);
        click(ESBPage.popup_ok);
        WaitElement.Eledisplay(ESBPage.submitESBSucessText);
        String resultText=getText(ESBPage.submitESBSucessText);
        if(resultText.contains("订单提交预报成功")){
            print("E速宝订单录入成功");
            ESBtestData.ESBorderNumeber=String.valueOf(getnum(By.xpath(".//*[@id='success-tip']/p"), 14));  //截取创建成功后的订单流水号
            print(ESBtestData.ESBorderNumeber);
            MyAssert.assertTrue(true);
        }else if (WaitElement.Eledisplay(ESBPage.failtip)){
            print("E速宝订单录入失败");
            MyAssert.assertTrue(false);
        }else {
            print("E速宝订单录入失败");
            MyAssert.assertTrue(false);
        }
    }

     //调试
    @Test
    public void test() throws Exception{
        this.OpenESBpage();
        this.OrderInfo("E速宝小包","德国");
        this.consignee("BHAVNAGAR","364295");
        this.product(3);
        this.submit();
        outF();
        OrderManage.OrderQuery(ESBtestData.ESBorderNumeber);
        PrintLabel.printOrderLabel(PrintLableData.ESB_LabelASnum_GATI);
    }
}
