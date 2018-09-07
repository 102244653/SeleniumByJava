package CES_QT.PageElement.OrderManage;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2018/2/27.
 * FBA录单
 */
public class FBAPage {
    //菜单链接
     public static By FBA=By.linkText("FBA录单");
     //iframe
      public static String iframe="resultFrame";
     //界面标题
      public static By head=By.xpath("//a[text()='FBA录单']");

    /**基本信息*/
    //服务方式
    public static By server_code=By.id("server_code");
    //FBA订单号
    public static By  FBAhawbcode=By.name("order[refer_hawbcode]");
    //上传发票
    public static By invoice=By.id("invoice");
    //上传按钮
   public static By upid1=By.id("upid1");
   //确定按钮
    public  static By popup_ok=By.id("popup_ok");
    //上传装箱单
    public static By  invoicelist=By.xpath(".//*[@id='invoicelist'] ");
    //装箱单上传按钮
    public  static By upid=By.id("upid");
    //上传发票成功文本
    public static By sucessUpinvoice=By.id("frendInformation2") ;
   //上传装箱单成功文本
    public static By sucessUpinvoicelist=By.id("frendInformation1") ;


    /**收件人信息*/
    //FBA仓库
    public static By  fbahouse=By.id("storage");
    //国家/地区
    public static By  sendcountry=By.id(" ");
    //省/州
    public static By  sendprovince=By.id(" ");
    //邮编
    public static By  sendpostcode=By.id(" ");
    //城市
    public static By  sendcity=By.id(" ");
    //地址
    public static By  sendaddress=By.id(" ");

    /**申报信息*/
    //添加多箱按钮
    public static By  addbox=By.id("addBox");
    //添加箱子信息
    //关联箱号
    public  static By box_number=By.name("invoice[box_number][]");
    //SKU
    public  static By sku=By.name("invoice[sku][]");
    //长
    public  static By invoice_length=By.name("invoice[invoice_length][]");
    //宽
    public  static By invoice_width=By.name("invoice[invoice_width][]");
    //高
    public  static By invoice_height=By.name("invoice[invoice_height][]");
    //重量
    public  static By invoice_boxweight=By.name("invoice[invoice_boxweight][]");

    //添加内件
    public static By  addInvoice=By.className("addInvoice");
    //添加行
    public static By  shippingloc=By.xpath(".//*[@id='shippingloc']/div[2]/button[1]");

    //英文品名
    public static By invoice_enname=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[2]/input");
    //中文品名
    public static By invoice_cnname=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[3]/input");
    //数量
    public static By invoice_quantity=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[4]/input");
    //单价
    public static By invoice_unitcharge=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[5]/input");
    //商品总重量
    public static By invoice_weight=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[6]/input");
    //海关编码
    public static By hs_code=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[8]/input");
    //销售链接
    public static By invoice_url=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[9]/input");
    //品牌
    public static By modal_invoice_brand=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[10]/input");
    //型号
    public static By modal_invoice_model=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[11]/input");
    //操作
    public static By delete_modal_invoice=By.xpath(".//*[@id='shippingloc']/div[2]/div[2]/table/tbody/tr[1]/td[12]/input");
    //保存
    public static By modal_invoice_sure=By.xpath("//*[@id='shippingloc']/div[2]/button[2]");



    //**发件人信息 */
    //发件人信息1
    public static By sender1=By.xpath("//div[@class='TextList']/p[1]/label/span[1]/input");
    //发件人信息2
    public static By sender2=By.xpath("//div[@class='TextList']/p[2]/label/span[1]/input");
    //发件人信息3
    public static By sender3=By.xpath("//div[@class='TextList']/p[3]/label/span[1]/input");
    //新增发件人
     public static By addsender=By.className("open_btn");


    //提交订单
    public static By  submitFBA=By.className("btns1 ");
    //提交成功后的文本
    public static By  submitFBASucessText=By.xpath(".//*[@id='success-tip']/p");
   //异常提示框
    public static By failtip=By.id("dialog-auto-alert-tip");


}
class ProInfo{
    /**内件信息*/
    //添加行
    public static By  addrow=By.xpath(".//*[@id='shippingloc']/div[2]/button[1]");
    //确认
    public static By  ok=By.xpath("//*[@id='shippingloc']/div[2]/button[2]");
    //取消
    public static By  cancel=By.xpath("//*[@id='shippingloc']/div[2]/button[3]");
}
