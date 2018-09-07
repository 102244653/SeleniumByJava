
package CES_QT.PageAction.OrderManage;

import CES_QT.PageAction.QTLogin.DoLogin;
import CES_QT.PageElement.OrderManage.Japan_FBAPage;
import TestData.QT_DATA.JapanFBA_Data;
import Tools.Assert.MyAssert;
import Tools.Element.WaitElement;
import Tools.Tool.MyUpload;
import Tools.Tool.RandomNum;
import Tools.Tool.Str;
import Tools.Tool.Time;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static Tools.BaseAction.MyActions.*;

/**
 * Created by Administrator on 2018/2/28.
 * 创建日本FBA订单
 */
public class CreatJapan_FBA   {
    //成功或者失败标记
    String flag;
    MyUpload Up=new MyUpload();

    //打开界面
    public void OpenJapanFBA()throws Exception{
        print("*****日本FBA录单开始******");
        click(Japan_FBAPage.JapanFBA);
        Time.wait(1000);
        intoF(Japan_FBAPage.iframe, Japan_FBAPage.customernum);
    }

    //上传发票
    public void UploadBill()throws Exception{
        Up.upload(Japan_FBAPage.customernum, JapanFBA_Data.billpath, Japan_FBAPage.selectbill);
        click(Japan_FBAPage.uplaodbill);
        click(Japan_FBAPage.sureupload);
        Time.wait(2000);
        if(WaitElement.Eledisplay(Japan_FBAPage.successbill)){
            print("发票"+getText(Japan_FBAPage.successbill));
        }else {
            print("发票上传失败");
        }
    }

    //上传装箱清单
    public void UploadList()throws Exception{
        Up.upload(Japan_FBAPage.customernum, JapanFBA_Data.packagelistpath, Japan_FBAPage.selectlist);
        click(Japan_FBAPage.uploadlist);
        click(Japan_FBAPage.sureupload);
        Time.wait(2000);
        if(WaitElement.Eledisplay(Japan_FBAPage.successlist)){
            print("装箱清单"+getText(Japan_FBAPage.successlist));
        }else {
            print("装箱清单上传失败");
        }
    }

    //收件人信息录入
    public void ReciverInfo()throws Exception{
        sendText(Japan_FBAPage.customernum, JapanFBA_Data.CustomeNum);
        selectindex(Japan_FBAPage.fbahouse, 1);
    }

    //添加箱,i--要添加的箱数
    public void AddBox(int i)throws Exception{
        for(int k=1;k<=i;k++){
            click(Japan_FBAPage.addbox);
        }
    }

    //删除箱,i--箱号
    public void DeleteBox(int i)throws Exception{
        int k=i+1;
        click(By.xpath("//*[@id='getInvoice']/div["+k+"]/div[8]/button[2]"));
    }

    //箱信息录入,i--箱数
    public void BoxInfo(int i)throws Exception{
        for(int k=1;k<=i;k++) {
            int a=k+1;
            //关联箱号
            sendText(By.xpath("//*[@id='getInvoice']/div[" + a + "]/div[2]/input"),
                    String.valueOf(new RandomNum().getNumRandom(6)));
            //SKU
            sendText(By.xpath("//*[@id='getInvoice']/div[" + a + "]/div[3]/input"),
                    String.valueOf(new RandomNum().getStringRandom(5)));
            //长(cm)
            sendText(By.xpath("//*[@id='getInvoice']/div[" + a + "]/div[4]/input"), "100");
            //宽(cm)
            sendText(By.xpath("//*[@id='getInvoice']/div[" + a + "]/div[5]/input"), "100");
            //高(cm)
            sendText(By.xpath("//*[@id='getInvoice']/div[" + a + "]/div[6]/input"), "100");
            //总重量(kg)
            sendText(By.xpath("//*[@id='getInvoice']/div[" + a + "]/div[7]/input"), "50");
        }
    }

    //内件信息录入,i--箱号,k--内件信息行号
    public void ProInfo(int i)throws Exception{
        //根据箱数生成没想的内件数（随机生成）
        int[] a=new int[i];
        for(int c=0;c<i;c++){
            int index=Integer.valueOf((int) new RandomNum().getNumRandom(1,5));
            a[c]=index;
        }
        //循环添加内件信息
        for(int j=1;j<=a.length;j++) {
            click(By.xpath("//*[@id='getInvoice']/div[" + (j+1) + "]/div[8]/button[1]"));
            Time.wait(1000);
            totop();
            for (int k = 0; k <a[j-1]; k++) {
                if (k != 0) {
                    click(Japan_FBAPage.addrow);
                }
                int b = k + 1;
                //英文品名
                sendText(By.xpath("//tbody[@class='tbody1']/tr[" + b + "]/td[2]/input"), "EnglishName" + k);
                //中文品名
                sendText(By.xpath("//tbody[@class='tbody1']/tr[" + b + "]/td[3]/input"), "中文名");
                //单价
                sendText(By.xpath("//tbody[@class='tbody1']/tr[" + b + "]/td[4]/input"), String.valueOf(k+2));
                //数量
                sendText(By.xpath("//tbody[@class='tbody1']/tr[" + b + "]/td[5]/input"), String.valueOf(k+2));
                //商品重量(总,kg)
                sendText(By.xpath("//tbody[@class='tbody1']/tr[" + b + "]/td[6]/input"), String.valueOf(k+2));
                //海关编码
                sendText(By.xpath("//tbody[@class='tbody1']/tr[" + b + "]/td[8]/input"),
                        String.valueOf(new RandomNum().getNumRandom(10)));
                //销售链接
                sendText(By.xpath("//tbody[@class='tbody1']/tr[" + b + "]/td[9]/input"), "baidu.com");
                //品牌
                sendText(By.xpath("//tbody[@class='tbody1']/tr[" + b + "]/td[10]/input"), "品牌PP");
                //型号
                sendText(By.xpath("//tbody[@class='tbody1']/tr[" + b + "]/td[11]/input"), "XH" + k);
            }
            click(Japan_FBAPage.sureinfo);
            Time.wait(2000);
        }

    }

    //选择发件人,i--发件人序号
    public void SelectSender(int i)throws Exception{
        switch (i){
            case 1:
                click(Japan_FBAPage.sender1);
                break;
            case 2:
                click(Japan_FBAPage.sender2);
                break;
            case 3:
                click(Japan_FBAPage.sender3);
                break;
            default:
                click(Japan_FBAPage.sender1);
                break;
        }
    }

    //添加发件人,Y--默认发件人
    public void AddSender(String ismoren)throws Exception{
        click(Japan_FBAPage.addsender);
        //公司名
        sendText(Japan_FBAPage.sendercompany,"纵腾贸易");
        //发件人姓名
        sendText(Japan_FBAPage.sendername,"MyTest");
        // 国家/地区
        selectvalue(Japan_FBAPage.sendercountry,"CN");
        //省
        sendText(Japan_FBAPage.senderprovince,"广东");
        //城市
        sendText(Japan_FBAPage.sendercity,"广州");
        //详细地址
        sendText(Japan_FBAPage.senderaddress,"Notsnad Alsdk");
        //邮编
        sendText(Japan_FBAPage.senderpost, String.valueOf(new RandomNum().getNumRandom(8)));
        //联系电话
        sendText(Japan_FBAPage.senderphone,"13534251468");
        //设为默认地址
        if(ismoren.equals("Y")){
            click(Japan_FBAPage.issender);
        }
        //提交
        click(Japan_FBAPage.submitsender);
    }

    //提交订单
    public void SubmitJapan()throws Exception{
        click(Japan_FBAPage.submitJapan);
        Time.wait(5000);
        if(WaitElement.Eledisplay(Japan_FBAPage.successtip)){
            String result=getText(Japan_FBAPage.successtip).trim();
            JapanFBA_Data.JapanFbaNum=new Str().subStrEnd(result,13);
            flag="S";
            MyAssert.assertTrue(true);
        }else if(WaitElement.Eledisplay(Japan_FBAPage.failtip)){
            getText(Japan_FBAPage.failtip).trim();
            flag="F";
            MyAssert.assertTrue(false);
        }else {
            flag="F";
            MyAssert.assertTrue(false);
        }
    }

    public void closetip()throws Exception{
        switch (flag){
            case "S":
                click(Japan_FBAPage.closesuccesstip);
                break;
            case "F":
                click(Japan_FBAPage.closefailtip);
                break;
            default:
                break;
        }
    }

    @Test
    public void test(){
        try{
            this.OpenJapanFBA();
            this.UploadBill();
            Time.wait(2000);
            this.UploadList();
            this.ReciverInfo();
            this.AddBox(1);
            this.BoxInfo(2);
            this.ProInfo(2);
            this.SelectSender(2);
            this.SubmitJapan();
        }catch (Exception e){

        }
    }

}
