package CES_QT.PageElement.OrderManage;

import org.openqa.selenium.By;

public class DHLPage {
    //菜单链接
    public static By DHL_list=By.linkText("中速-DHL录单");
    //iframe
    public static String iframe="resultFrame";
    /**产品及服务*/
    //产品种类
    public static By product_code=By.id("product_code");

    /**发件人信息*/
    //联系人姓名
    public static By shipper_name=By.name("shipper[shipper_name]");
    //公司名称
    public static By shipper_company=By.name("shipper[shipper_company]");
    //邮编
    public static By shipper_postcode=By.name("shipper[shipper_postcode]");
    //城市
    public static By shipper_city=By.name("shipper[shipper_city]");
    //地址1
    public static By shipperstree=By.id("shipperstree");
    //地址2
    public static By shipperstree1=By.id("shipperstree1");
    //地址3
    public static By shipperstree2=By.id("shipperstree2");
    //电话号码
    public static By shipper_telephone=By.name("shipper[shipper_telephone]");

    /**收件人信息*/
    //公司名称
    public static By consignee_company=By.id("consignee_company");
    //国家
    public static By country_code=By.id("country_code");
    //街道1
    public static By consignee_street=By.id("consignee_street");
    //街道2
    public static By consignee_street2=By.id("consignee_street2");
    //街道3
    public static By consignee_street3=By.id("consignee_street3");
    //区
    public static By consignee_city=By.id("consignee_city");
    //邮编
    public static By consignee_postcode=By.id("consignee_postcode");
    //英国邮编后输入框
    public static By GBEXT=By.id("GBEXT");
    //联系人
    public static By consignee_name=By.id("consignee_name");
    //电话号码
    public static By consignee_telephone=By.id("consignee_telephone");



    /**内件信息*/
    //文件
    public static By File_type=By.xpath(".//*[@id='orderForm']/div[2]/div[2]/input[1]");
    //物品
    public static By Goods_type=By.xpath(".//*[@id='orderForm']/div[2]/div[2]/input[2]");

    /**快递详细信息*/
    //添加行
    public static By  addtr=By.id("addtr");
    //件数
    public static By  invoice_quantity=By.xpath(".//*[@id='tb1']/tbody/tr[1]/td[1]/input");
    //单件重量
    public static By  invoice_weight=By.xpath(".//*[@id='tb1']/tbody/tr[1]/td[2]/input");
    //长度（厘米）
    public static By  invoice_length=By.xpath(".//*[@id='tb1']/tbody/tr[1]/td[3]/input");
    //宽度（厘米）
    public static By  invoice_width=By.xpath(".//*[@id='tb1']/tbody/tr[1]/td[4]/input");
    //高度（厘米）
    public static By  invoice_height=By.xpath(".//*[@id='tb1']/tbody/tr[1]/td[5]/input");

    /**物品详细说明*/
    //是否含有危险品
    public static By dangerousgoods=By.name("order[dangerousgoods]");
    //中文品名
    public static By invoice_cnname=By.name("invoice[invoice_cnname][]");
    //英文品名
    public static By invoice_enname=By.name("invoice[invoice_enname][]");

    /**发票(只针对包裹快件(海关要求))*/
    //发件人增值税号
    public static By invoice_shippertax=By.name("invoice[invoice_shippertax][]");
    //收件人增值税号
    public static By invoice_consigneetax=By.name("invoice[invoice_consigneetax][]");
    //通关的申报价值（用于商业/形式发票）
    public static By invoice_totalcharge_all=By.name("invoice[invoice_totalcharge_all][]");
    //HS CODE（如果需要）
    public static By hs_code=By.name("invoice[hs_code][]");
    //快件保险（选择是）
    public static By extraservice=By.name("extraservice[]");
    //保险价值
    public static By insurance_value_gj=By.name("order[insurance_value_gj]");
    //目的地关税和税金（选择收件人）
    public static By shipper=By.xpath(".//*[@id='orderForm']/div[2]/div[14]/div/input[1]");
    //目的地关税和税金（选择发件人）
    public static By consignee=By.xpath(".//*[@id='orderForm']/div[2]/div[14]/div/input[2]");
    //选择制作发票
    public static By makeinvoice=By.id("makeinvoice");
    //形式发票
    public static By Proforma_invoice=By.xpath(".//*[@id='invoicetab']/div[1]/div/input[1]");
    //商业发票
    public static By Commercial_invoice=By.xpath(".//*[@id='invoicetab']/div[1]/div/input[2]");
    //日期
    public static By makeinvoicedate=By.name("order[makeinvoicedate]");
    //发票号码
    public static By invoicenum=By.name("order[invoicenum]");
    //完整描述*
    public static By invoice_note=By.xpath(".//*[@id='tb2']/tbody/tr[1]/td[1]/input");
    //数量
    public static By invoice_quantity1=By.xpath(".//*[@id='tb2']/tbody/tr[1]/td[2]/input");
    //商品代码
    public static By invoice_shipcode=By.xpath(".//*[@id='tb2']/tbody/tr[1]/td[3]/input");
    //单价
    public static By invoice_unitcharge=By.xpath(".//*[@id='tb2']/tbody/tr[1]/td[4]/input");

    /**额外服务选项(只针对文件)*/
    //文件保障服务 附加费29元/票
    public static By plane1=By.xpath(".//*[@id='plane1']/div/div[2]/input");

    /**发件人协议*/
    //我同意
    public static By allow=By.id("allow");
    //提交并打印运单
    public static By orderSubmitBtn=By.id("orderSubmitBtn");
    //提交成功文本提示
    public static By sucessSubmitBtntxt=By.xpath(".//*[@id='success-tip']/p");

}
