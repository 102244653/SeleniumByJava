package CES_QT.PageElement.OrderManage;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2018/2/27.
 * 日本专线录单
 */
public class Japan_FBAPage {
    //菜单链接
    public static By JapanFBA=By.linkText("EFBA录单-日本专线");
    //iframe
    public static String iframe="resultFrame";
    //界面标题
    public static By head=By.xpath("//a[text()='EFBA录单']");

    /**基本信息*/
    //客户单号
    public static By customernum=By.name("order[refer_hawbcode]");
    //上传发票（浏览）
    public static By selectbill=By.id("invoice");
    //上传发票（上传）
    public static By uplaodbill=By.id("upid1");
    //装箱单上传成功标志
    public static By successbill=By.id("frendInformation2");
    //上传装箱单（浏览）
    public static By selectlist=By.id("invoicelist");
    //上传装箱单（上传）
    public static By uploadlist=By.id("upid");
    //装箱单上传成功标志
    public static By successlist=By.id("frendInformation1");

    //确认上传
    public static By sureupload=By.id("popup_ok");

    /**收件人信息*/
    //FBA仓库
    public static By fbahouse=By.id("storage");
    //国家/地区
    public static By rcountry=By.id("consignee_countrycode");
    //省/州
    public static By rprovince=By.id("consignee_province");
    //邮编
    public static By rpostcode=By.id("consignee_postcode");
    //城市
    public static By rcity=By.id("consignee_city");
    //地址
    public static By raddress=By.id("consignee_street");
    //添加多箱
    public static By addbox=By.id("addBox");

    //添加行
    public static By addrow=By.className("addInvoiceRow");
    //确认
    public static By sureinfo=By.className("modal_invoice_sure");

    /**发件人信息 */
    //发件人信息1
    public static By sender1=By.xpath("//div[@class='TextList']/p[1]/label/span[1]/input");
    //发件人信息2
    public static By sender2=By.xpath("//div[@class='TextList']/p[2]/label/span[1]/input");
    //发件人信息3
    public static By sender3=By.xpath("//div[@class='TextList']/p[3]/label/span[1]/input");
    //新增发件人
    public static By addsender=By.className("open_btn");
	
	 /**新增发件人*/
    //公司名
    public static By sendercompany=By.name("E3");
    //发件人姓名
    public static By sendername=By.name("E2");
    // 国家/地区
    public static By sendercountry=By.name("E4");
    //省
    public static By senderprovince=By.name("E5");
    //城市
    public static By sendercity=By.name("E6");
    //详细地址
    public static By senderaddress=By.name("E7");
    //邮编
    public static By senderpost=By.name("E8");
    //联系电话
    public static By senderphone=By.name("E10");
    //设为默认地址
    public static By issender=By.name("E17");
    //提交
    public static By submitsender=By.id("orderSubmitBtn");

    //提交预报
    public static By submitJapan=By.xpath("//*[@value='提交预报']");
    //异常提示框
    public static By failtip=By.id("dialog-auto-alert-tip");
    //关闭失败提示框
    public static By closefailtip=By.xpath("html/body/div[*]/div[3]/div/button");
    //成功提示框
    public static By successtip=By.id("success-tip");
    //关闭成功提示框
    public static By closesuccesstip=By.xpath("//span[text()='录入下一条订单']/..");
}

