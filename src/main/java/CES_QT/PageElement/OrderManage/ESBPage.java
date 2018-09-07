package CES_QT.PageElement.OrderManage;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2018/2/27.
 * E速宝录单
 */
public class ESBPage {
    //菜单链接
    public static By ESB_list=By.linkText("E速宝录单");
    //iframe
    public static String iframe="resultFrame";

    /**基本信息*/
    //运输方式
    public static By product_code_chosen=By.xpath(".//*[@id='product_code_chosen']/a/div/b");
    public static By product_code_chosen_input= By.xpath(".//*[@id='product_code_chosen']/div/div/input");
    //收件人国家/地区
    public static By country_code_chosen=By.xpath(".//*[@id='country_code_chosen']/a/div/b");
    public static By country_code_chosen_input=By.xpath(".//*[@id='country_code_chosen']/div/div/input");
    //客户单号
    public static By refer_hawbcode=By.id("refer_hawbcode");
    //货物重量
    public static By order_weight=By.id("order_weight");
    //外包装件数
    public  static By order_pieces=By.id("order_pieces");
    //包裹申报种类
    public static By mail_cargo_type=By.id("mail_cargo_type");
    //是否带电池
    public static By battery=By.id("battery");
    //长
    public static By order_length=By.id("order_length");
    //宽
    public static By order_width=By.id("order_width");
    //高
    public static By order_height=By.id("order_height");

    /**收件人信息*/
    //公司名
    public static By  company=By.id("consignee_company");
    //收件人
    public static By  reciver=By.id("consignee_name");
    //收件人省/州
    public static By  province=By.id("consignee_province");
    //收件人电话
    public static By  recallnum=By.id("consignee_telephone");
    //收件人城市
    public static By  recity=By.id("consignee_city");
    //收件人手机
    public static By  rephonenum=By.id("consignee_mobile");
    //收件人邮箱
    public static By  reemail=By.id("consignee_email");
    //邮编
    public static By  consignee_postcode=By.id("consignee_postcode");
    //收件人门牌号
    public static By  consignee_doorplate=By.id("consignee_doorplate");
    //地址1
    public static By  consignee_street=By.id("consignee_street");
    //地址2
    public static By  consignee_street2=By.id("consignee_street2");
    //地址3
    public static By  consignee_street3=By.id("consignee_street3");
    //证件类型
    public static By  cardtype=By.id("consignee_certificatetype");
    //号码
    public static By  cardnum=By.id("consignee_certificatecode");
    //有效期
    public static By  endtime=By.id("consignee_credentials_period");

    /**海关申报信息 */
    //点击新增
    public static By  addpro=By.id("btn_addtr");
    //英文品名
    public static By invoice_enname=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[1]/input");
    //中文品名
    public static By invoice_cnname=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[2]/input");
    //数量
    public static By invoice_quantity=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[3]/input");
    //单位
    public static By unit_code=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[4]/input");
    //单价
    public static By invoice_unitcharge=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[5]/input");
    //重量
    public static By invoice_weight=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[7]/input");
    //SKU
    public static By sku=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[9]/input");
    //海关协制编号
    public static By hs_code=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[10]/input");
    //配货信息
    public static By invoice_note=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[11]/input");
    //销售地址
    public static By invoice_url=By.xpath(".//*[@id='dynamicTable']/tbody/tr[1]/td[12]/input");
    //删除
    public static By delete=By.className("delete");

    /**发件人信息 */
    //发件人1
    public static By  sender1=By.id(" ");
    //发件人2
    public static By  sender2=By.id(" ");
    //发件人3
    public static By  sender3=By.id(" ");
    //点击新增
    public static By  addsender=By.className("open_btn");

    //提交订单
    public static By  submitesb=By.xpath(".//*[@id='orderForm']/div[5]/input");
    //确定提交
    public  static By popup_ok=By.id("popup_ok");
    //提交成功后的文本
    public static By  submitESBSucessText=By.xpath(".//*[@id='success-tip']/p");
    //异常提示框
    public static By failtip=By.id("dialog-auto-alert-tip");
}
 class SenderInfoPage{
    /**新增发件人*/
    //公司名
    public static By  sendercompany=By.name("E3");
    //发件人姓名
    public static By  sendername=By.name("E2");
    // 国家/地区
    public static By  sendercountry=By.id("E4");
    //省
    public static By  senderprovince=By.name("E5");
    //城市
    public static By  sendercity=By.name("E6");
    //详细地址
    public static By  senderaddress=By.name("E7");
    //邮编
    public static By  senderpost=By.name("E8");
    //联系电话
    public static By  senderphone=By.name("E10");
    //设为默认地址
    public static By  isaddress=By.name("E17");
    //提交
    public static By  submit=By.id("orderSubmitBtn");
}
