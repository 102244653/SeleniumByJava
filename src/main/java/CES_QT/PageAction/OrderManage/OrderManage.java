package CES_QT.PageAction.OrderManage;

import TestData.QT_DATA.PrintLableData;
import Tools.Assert.MyAssert;
import Tools.DBManage.ConnectionDB;
import Tools.DBManage.DoSQL;
import Tools.ScreenShot.ScreenShot;
import Tools.Tool.Time;
import org.openqa.selenium.By;


import java.sql.Connection;

import static Tools.BaseAction.MyActions.*;

public class OrderManage {
    public static void  OrderQuery(String ordernum)  {
        //ordernum 为预报成功后系统生成的订单流水号
        try {
            print("*****订单管理开始******");
            click(By.linkText("订单管理"));
            Time.wait(1000);
            intoF("resultFrame", By.id("code"));
            Time.wait(1000);
            selectvalue(By.id("code_type"), "shipper");
            sendText(By.id("code"), ordernum);
//            String connection = "jdbc:mysql://192.168.10.200:63307/kuaijian_otms_web-test"+"zt-6155-test"
//                    +"4dZBEJM_ad.89aFCziIMam"+"&useUnicode=true&characterEncoding=UTF8";
//            PrintLableData.AS_Num= DoSQL.MyQuery(DriverManager.getConnection(connection),"select server_hawbcode from csd_order where shipper_hawbcode='" + ordernum + "'",1);
            for(int i=0;i<=20;i++){
               click(By.xpath(".//*[@id='search-module-baseSearch']/div[1]/input[1]"));//点击搜索
                click(By.xpath(".//*[@id='fix_header_content']/div/div[1]/ul/li[1]/a/span[1]"));//点击所有订单
                Time.wait(1000);
                String TextOrderNum = getText(By.xpath("//tbody[@id='table-module-list-data']/tr/td[2]/a")); //获取流水号
                String OrderStatus = getnum(By.xpath("//tbody[@id='table-module-list-data']/tr/td[5]"), 5);  //获取订单状态
                if ( TextOrderNum.equals(ordernum)&&OrderStatus.equals("已预报")) {
                    print("已查询到运单号：" + ordernum+"，状态为："+OrderStatus);
                    Connection conn=ConnectionDB.StartDB("192.168.10.200:63307","kuaijian_otms_web-test","zt-6155-test","4dZBEJM_ad.89aFCziIMam");
                    //从数据库查询AS单号
                    PrintLableData.AS_Num=DoSQL.MyQuery(conn,"select server_hawbcode from csd_order where shipper_hawbcode='" + ordernum + "'",1);
                    MyAssert.assertTrue(true);
                    break;
                } else {
                    if(i==20){
                        print("订单状态为:"+ OrderStatus);
                        MyAssert.assertTrue(false,"20 seconds after the problem");
                    }
                    Time.wait(1000);
                }
            }
            outF();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
