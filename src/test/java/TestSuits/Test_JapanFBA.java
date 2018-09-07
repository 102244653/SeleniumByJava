package TestSuits;

import CES_QT.PageAction.QTLogin.DoLogin;
import TestData.QT_DATA.JapanFBA_Data;
import TestData.QT_DATA.PrintLableData;
import Test_Case.Test_CreateOrder;
import Test_Case.Test_OrderQuery;
import Test_Case.Test_PrintOrder;
import org.testng.annotations.Test;

public class Test_JapanFBA extends DoLogin{
    @Test(priority = 1)
    public void 创建日本FBA订单(){
        new Test_CreateOrder().Test_CreateJapan_FBA_Order();
    }
    @Test(priority = 2 )
    public void 查询日本FBA订单(){
        new Test_OrderQuery().Test_Query(JapanFBA_Data.JapanFbaNum);
    }
    @Test(priority = 3)
    public void 打印日本FBA订单(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.JapanFBA_LabelASnum_Japan);
    }
}
