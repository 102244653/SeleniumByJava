package TestSuits;

import CES_QT.PageAction.QTLogin.DoLogin;
import TestData.QT_DATA.FBAtestData;
import TestData.QT_DATA.PrintLableData;
import Test_Case.Test_CreateOrder;
import Test_Case.Test_OrderQuery;
import Test_Case.Test_PrintOrder;
import org.testng.annotations.Test;

public class Test_FBA extends DoLogin{
    @Test(priority = 1)
    public void 创建FBA订单(){
        new Test_CreateOrder().Test_CreateFBA_Order();
    }
    @Test(priority = 2 )
    public void 查询FBA订单(){
        new Test_OrderQuery().Test_Query(FBAtestData.FBAorderNumeber);
    }
    @Test(priority = 3)
    public void 打印FBA订单(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.FBA_LabelASnum_US);
    }
}
