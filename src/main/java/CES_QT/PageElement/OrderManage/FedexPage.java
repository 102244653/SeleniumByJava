package CES_QT.PageElement.OrderManage;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2018/2/27.
 * Fedex录单
 */
public class FedexPage {
    //菜单链接
    public static By Fedex=By.linkText("中速-FedEx录单");
    //iframe
    public static String iframe="resultFrame";

    /**发件人信息*/
    //寄件人姓名
    public static By  sendername= By.name("shipper[shipper_name]");
    //公司名称
    public static By  scompanyname= By.name("shipper[shipper_company]");
    //联系电话
    public static By  senderphone= By.name("shipper[shipper_telephone]");
    //邮政编码
    public static By  spostcode= By.name("shipper[shipper_postcode]");
    //城市
    public static By  scity= By.name("shipper[shipper_city]");
    //货件参考信息
    public static By  proinfo= By.name("order[refer_hawbcode]");
    //地址行1
    public static By  saddress= By.id("shipperstree");
    //添加到发件人地址薄
    public static By  addsenderlist= By.id("shipperaddaddress");
    //发件人地址薄
    public static By  senderlist= By.id("shipperaddrs");


    /**收件人信息*/
    //收件人姓名
    public static By  recivername= By.id("consignee_name");
    //公司名称
    public static By  rcompanyname= By.id("consignee_company");
    //联系电话
    public static By  reciverphone= By.id("consignee_telephone");
    //国家/地区
    public static By  rcountry= By.id("country_code");
    //邮政编码
    public static By  rpostcode= By.id("consignee_postcode");
    //州/省
    public static By  rprovince= By.id("consignee_province");
    //城市
    public static By  rcity= By.id("consignee_city");
    //地址1
    public static By  raddress1= By.id("consignee_street");
    //地址2
    public static By  raddress2= By.id("consignee_street2");
    //添加到收件人地址薄
    public static By  addreciverlist= By.id("consigneeaddaddress");
    //收件人地址薄
    public static By  reciverlist= By.id("consigneeaddrs");


    /**货件内容*/
    // 仅文件
    public static By  File_type= By.xpath("//input[@class='fise1']");

    //货品
    public static By  Goods_type= By.xpath("//input[@class='fise2']");

    //生成商业发票/形式发票(是)
    public static By  isbill= By.xpath("//input[@type='radio' and @value='1']");
    //商业发票详细信息
    public static By  billinfo= By.xpath("//span[text()='商业发票详细信息']");

    //生成商业发票/形式发票（否）
    public static By  notbill= By.xpath("//input[@type='radio' and @value='2']");


    /**货品信息*/
    //增加
    public static By  addpro= By.xpath("//span[@descript='invoice_hw']");
    //确定
    public static By  ok= By.xpath("//span[text()='取消']/../span[1]");

    /**货件详细信息*/
    //寄件日期
    public static By  sendtime= By.name("order[makeinvoicedate]");
    //服务
    public static By  service= By.name("order[services_code]");
    //包装
    public static By packageinfo= By.name("order[packtype]");
    //货件尺寸
    public static By prosizeinfo=By.id("sizeInfo");
    //包裹数量
    public static By  packageqty= By.id("boxNum");
    //总重量
    public static By  packageweight= By.id("order_weight");
    //托运申报价值
    public static By  proprice= By.id("consignmentvalue");
    //海关价值
    public static By  hgprice= By.id("invoice_totalcharge_all");
    //部门/备注
    public static By  note= By.id("fpnote");


    /**付款详细信息*/
    //收件人付
    public static By  isreciver= By.xpath("//input[@type='radio' and @value='R']");
    //寄件人付
    public static By  issender= By.xpath("//input[@type='radio' and @value='S']");

    /**发件人协议*/
    //同意协议
    public static By  accept= By.id("allow");

    //提交打印面单
    public static By  submitFedex= By.id("orderSubmitBtn");
}

class FedexbillInfo{
    /**发票详细信息*/
    //增加
    public static By addbillpro=By.xpath("//span[@descript='invoice_fp']");
    //海关申报总值
    public static By  billprice= By.id("allow");
    //币种
    public static By  currency= By.id("allow");
    //总重量
    public static By  totalweight= By.id("allow");
    //单位
    public static By  weightunit= By.id("allow");

    /**销售和收款条款*/
    //销售条款
    public static By  sellterm= By.id("allow");
    //运费
    public static By  tranprice= By.id("allow");
    //保险费
    public static By  bxprice= By.id("allow");
    //其它费用
    public static By  othprice= By.id("allow");
    //税费金额
    public static By  sfprice= By.id("allow");
    //总计
    public static By  totalprice= By.id("allow");
    //货件用途
    public static By  prouse= By.id("allow");

    /**商业发票信息*/
    //商业发票
    public static By  businessbill= By.id("allow");
    //形式发票
    public static By  formbill= By.id("allow");
    //备注
    public static By  note= By.id("allow");

    //保存
    public static By  savebill= By.id("allow");
}
