package TestData.QT_DATA;

import Tools.Tool.RandomNum;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class ESBtestData {
    //截取创建成功后的订单流水号
    public static String ESBorderNumeber;
    public static String AS_num;  //AS单号
    public static String sql="delete from csd_order where refer_hawbcode='Test000003'";

    public static String ESB_ASnum_YunTu=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[16]";
    public static String ESB_ASnum_SaiCheng=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[23]";
    public static String ESB_ASnum_SaiCheng_AT=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[22]";
    public static String ESB_ASnum_AUS=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[27]";
    public static String ESB_ASnum_GATI=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[15]";
    public static String Path=System.getProperty("user.dir")+"\\fileupload\\";
    public static String TestPath1=Path+"ESB录单模板_没有来源-云途1.xls";

    //orderinfo_data
    public static String product_code;
    public static String country;
    public static String refer_hawbcode= RandomNum.getStringRandom(20);
    public static String order_weight= "2";
    public static String order_pieces= "1";
    public static String mail_cargo_type= "礼品(Gift)";
    public static String battery= "NOBattery(不带电)";
    public static String order_length= "10";
    public static String order_width= "8";
    public static String order_height="5";
    //consignee_data
    public static String company= "zongteng";
    public static String reciver= "Xiongfei";
    public static String province= "NSW";
    public static String recallnum= "18581223813";
    public static String recity= "10";
    public static String rephonenum= "15823666849";
    public static String reemail="zt6826@zongteng.net";

    public static String consignee_postcode= " ";
    public static String consignee_street= "9B Griffin Ave,Epsom";
    public static String consignee_doorplate= "A518";
    public static String consignee_street2= "9C=Griffin Ave,Epsom";
    public static String consignee_street3= "9D=Griffin Ave,Epsom";
    public static String cardtype= "ID Card(身份证)";
    public static String cardnum="500102199306105233";
    public static String endtime="2017-12-30";





}
