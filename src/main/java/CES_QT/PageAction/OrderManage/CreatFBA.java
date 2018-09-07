package CES_QT.PageAction.OrderManage;

import CES_QT.PageAction.QTLogin.DoLogin;
import CES_QT.PageElement.OrderManage.FBAPage;
import CES_QT.PageElement.OrderManage.Japan_FBAPage;
import TestData.QT_DATA.FBAtestData;
import TestData.QT_DATA.JapanFBA_Data;
import TestData.QT_DATA.PrintLableData;
import Tools.Assert.MyAssert;
import Tools.Element.WaitElement;
import Tools.ScreenShot.ScreenShot;
import Tools.Tool.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static Tools.BaseAction.MyActions.*;

public class CreatFBA extends DoLogin {
    MyUpload upload=new MyUpload();
    //打开界面
    public void OpenFBA()throws Exception{
        click(FBAPage.FBA);
        Time.wait(1000);
        intoF(FBAPage.iframe, FBAPage.server_code);
    }
    //选着服务方式
    public void SelectService() throws Exception {
        Time.wait(1000);
        //selectvalue(FBAPage.server_code,"2");
        selectText(FBAPage.server_code, "空加派服务");
        sendText(FBAPage.FBAhawbcode, "" + RandomNum.getStringRandom(20));
    }
    //上传发票
    public void UploadBill()throws Exception{
        upload.upload(FBAPage.box_number, FBAtestData.invoicePath, FBAPage.invoice);
        click(FBAPage.upid1);
        click(FBAPage.popup_ok);
        Time.wait(2000);
        if(WaitElement.Eledisplay(FBAPage.sucessUpinvoice)){
            print("发票"+getText(FBAPage.sucessUpinvoice));
        }else {
            print("发票上传失败");
        }
    }

    //上传装箱清单
    public void UploadList()throws Exception{
        upload.upload(FBAPage.box_number, FBAtestData.invoicelistPath, FBAPage.invoicelist);
        click(FBAPage.upid);
        click(FBAPage.popup_ok);
        Time.wait(2000);
        if(WaitElement.Eledisplay(FBAPage.sucessUpinvoicelist)){
            print("装箱清单"+getText(FBAPage.sucessUpinvoicelist));
        }else {
            print("装箱清单上传失败");
        }
    }
    //选择仓库（收件人信息）
    public void consignee_Info() throws Exception{
        selectText(FBAPage.fbahouse,"PHX3");
    }
    //添加箱子信息,i--要添加的箱数
    public void AddBox()throws Exception{
            drag.dragdown();//把页面向下移动
            Time.wait(1000);
                 //关联箱号
                sendText(By.xpath(".//*[@id='getInvoice']/div[2]/div[2]/input"),"xiangzi001");
                //SKU
                sendText(By.xpath(".//*[@id='getInvoice']/div[2]/div[3]/input"),"2222");
                //长(cm)
                sendText(By.xpath("//*[@id='getInvoice']/div[2]/div[4]/input"),"30");
                //宽(cm)
                sendText(By.xpath("//*[@id='getInvoice']/div[2]/div[5]/input"),"10");
                //高(cm)
                sendText(By.xpath("//*[@id='getInvoice']/div[2]/div[6]/input"), "5");
                //总重量(kg)
                sendText(By.xpath("//*[@id='getInvoice']/div[2]/div[7]/input"), "40");
    }
    //添加箱子的内件信息,k--要添加的内件数量
     public void ProInfo(int k) {
         click(FBAPage.addInvoice);
         drag.dragdown();
         for (int i = 1; i < k; i++) {
             click(By.xpath(".//*[@id='shippingloc']/div[2]/button[1]"));
         }
         for (int i = 1; i <= k; i++) {
             sendText(By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[2]/input"), "testEname");
             sendText(By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[3]/input"), "测试商品");
             sendText(By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[4]/input"), "15.2");
             sendText(By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[5]/input"), "2");
             sendText(By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[6]/input"), "10");
             sendText(By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[8]/input"), "10011");
             sendText(By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[9]/input"), "http://test.shipping.com/");
             sendText(By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[10]/input"), "Nike");
             sendText(By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[11]/input"), "AA2");
             Time.wait(1000);
         }
         click(By.xpath("//*[@id='shippingloc']/div[2]/button[2]"));
     }
    //选择发件人,i--发件人序号
    public void selectSender(int i) throws Exception{
        switch (i){
            case 1:
                click(FBAPage.sender1);break;
            case 2:
                click(FBAPage.sender2);break;
            case 3:
                click(FBAPage.sender3);break;
            default:
                click(FBAPage.sender1);
                break;
        }
    }
     //提交订单
    public void submit()throws Exception{
        drag.dragMouse(); //将页面滑到最底端
        click(FBAPage.submitFBA);
        WaitElement.Eledisplay(FBAPage.submitFBASucessText);
        String resultText=getText(FBAPage.submitFBASucessText);
        if(resultText.contains("订单提交预报成功")){
            print("FBA订单录入成功");
            FBAtestData.FBAorderNumeber=String.valueOf(getnum(By.xpath(".//*[@id='success-tip']/p"), 14));
            print(FBAtestData.FBAorderNumeber);
            MyAssert.assertTrue(true);
        }else if (WaitElement.Eledisplay(FBAPage.failtip)){
            print("FBA订单录入失败");
            MyAssert.assertTrue(false);
        }else {
            print("FBA订单录入失败");
            MyAssert.assertTrue(false);
        }
    }
    @Test
    public void test (){
        try {
            this.OpenFBA();
            this.SelectService();
            this.UploadBill();
            Time.wait(2000);
            this.UploadList();
            this.consignee_Info();
            this.AddBox();
            this.ProInfo(2);
            this.selectSender(2);
            this.submit();
            outF();
            OrderManage.OrderQuery(FBAtestData.FBAorderNumeber);
            PrintLabel.printOrderLabel(PrintLableData.FBA_LabelASnum_US);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
