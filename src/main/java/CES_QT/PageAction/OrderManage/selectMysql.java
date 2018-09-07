package CES_QT.PageAction.OrderManage;

import Tools.DBManage.ConnectionDB;
import Tools.DBManage.DoSQL;
import org.testng.annotations.Test;

import java.sql.Connection;


public class selectMysql {
    static String selectResult;
    @Test

    public void selectA(){
        try {

            //res1= DoSQL.MyQuery(DriverManager.getConnection(connection),"select title from zt_case where id=3",1);
            Connection conn=ConnectionDB.StartDB("192.168.10.200:63307","kuaijian_otms_web-test","zt-6155-test","4dZBEJM_ad.89aFCziIMam");
            //selectResult= DoSQL.MyQuery(ConnectionDB.StartDB("192.168.10.200:63307","kuaijian_otms_web-test","zt-6155-test","4dZBEJM_ad.89aFCziIMam"),"select count(*) 总单数 from csd_order  where order_id>258058 ;",1);
            DoSQL.MyQuery(conn,"select count(*) 总单数 from csd_order  where order_id>258058 ;",1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
