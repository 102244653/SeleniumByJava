package Test_Case;

import CES_QT.PageAction.OrderManage.OrderManage;
import CES_QT.PageAction.QTLogin.DoLogin;
import Tools.Assert.MyAssert;

public class Test_OrderQuery  extends DoLogin{
//测试订单管理—查询订单状态
    public void Test_Query(String ordernum){
       try {
           OrderManage.OrderQuery(ordernum);
       }catch (Exception e){
           e.printStackTrace();
           MyAssert.assertTrue(false);
       }

    }

}
