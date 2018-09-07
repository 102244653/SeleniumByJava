package CES_QT.PageElement.OrderManage;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2018/2/27.
 * 香港快递录单
 */
public class HKPage {
    //菜单链接
    public static By HK_list=By.linkText("中国香港快递录单");
    //iframe
    public static String iframe="resultFrame";

    /**产品及服务*/
     //产品种类
     public static By product_code=By.id("product_code");

    /**发件人信息*/
    //联系人姓名
    public static By shipper_name=By.name("shipper[shipper_name]");
    //电话号码
    public static By shipper_telephone=By.name("shipper[shipper_telephone]");
    //公司名称
    public static By shipper_company=By.name("shipper[shipper_company]");
    //城市
    public static By shipper_city=By.name("shipper[shipper_city]");
    //地址1
    public static By shipperstree=By.id("shipperstree");
    //地址2
    public static By shipperstree1=By.id("shipperstree1");
    //地址3
    public static By shipperstree2=By.id("shipperstree2");
    //邮编
    public static By shipper_postcode=By.name("shipper[shipper_postcode]");

    /**收件人信息*/
    //联系人
    public static By consignee_name=By.id("consignee_name");
    //电话号码
    public static By consignee_telephone=By.id("consignee_telephone");
    //区
    public static By consignee_city=By.id("consignee_city");
    //街道1
    public static By consignee_street=By.id("consignee_street");
    //街道2
    public static By consignee_street2=By.id("consignee_street2");
    //街道3
    public static By consignee_street3=By.id("consignee_street3");
    //公司名称
    public static By consignee_company=By.id("consignee_company");

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
    //长度（厘米）0
    public static By  invoice_length=By.xpath(".//*[@id='tb1']/tbody/tr[1]/td[3]/input");
    //宽度（厘米）
    public static By  invoice_width=By.xpath(".//*[@id='tb1']/tbody/tr[1]/td[4]/input");
    //高度（厘米）
    public static By  invoice_height=By.xpath(".//*[@id='tb1']/tbody/tr[1]/td[5]/input");

    /**物品详细说明*/
    //中文品名
    public static By invoice_cnname=By.name("invoice[invoice_cnname][]");
    //英文品名
    public static By invoice_enname=By.name("invoice[invoice_enname][]");

    /**如快件无法投递，我选择*/
    //退回
    public static By retu=By.xpath(".//*[@id='plane2']/div[1]/div[1]");
    //放弃
    public static By give_up=By.xpath(".//*[@id='plane2']/div[2]/div[1]");

    /**发件人协议*/
    //我同意
    public static By allow=By.id("allow");
    //提交并打印运单
    public static By orderSubmitBtn=By.id("orderSubmitBtn");
    //提交成功文本提示
    public static By sucessSubmitBtntxt=By.xpath(".//*[@id='success-tip']/p");

}
