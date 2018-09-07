package TestData.QT_DATA;

import Tools.Tool.RandomNum;

import static Tools.BaseAction.MyActions.*;

/**
 * Created by Administrator on 2018/2/28.
 */
public class JapanFBA_Data {
    //发票地址
    public static String billpath=getpath()+"\\fileupload\\Bill.xlsx";
    //装箱单地址
    public static String packagelistpath= getpath()+"\\fileupload\\FBAList.xlsx";

    //客户单号
    public static String CustomeNum= RandomNum.getStringRandom(20);
    //订单号
    public static String JapanFbaNum;

}
