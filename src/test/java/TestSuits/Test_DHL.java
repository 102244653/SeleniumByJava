package TestSuits;

import CES_QT.PageAction.QTLogin.DoLogin;
import TestData.QT_DATA.DHLtestData;
import TestData.QT_DATA.FBAtestData;
import TestData.QT_DATA.PrintLableData;
import Test_Case.Test_CreateOrder;
import Test_Case.Test_OrderQuery;
import Test_Case.Test_PrintOrder;
import org.testng.annotations.Test;

public class Test_DHL extends DoLogin {
    /**测试用列1
     * 创建并打印DHL物品*/
    @Test(priority = 1)
    public void 创建DHL订单_物品(){
        new Test_CreateOrder().Test_CreateDHL_Order_Goods();
    }
    @Test(priority = 2 )
    public void 查询DHL订单_物品(){
        new Test_OrderQuery().Test_Query(DHLtestData.DHLorderNumeber);
    }
    @Test(priority = 3)
    public void 打印DHL订单_物品(){
        new Test_PrintOrder().Test_Print(0,PrintLableData.DHL_LabelASnum_File);
    }
    /**测试用列2
     * 创建并打印DHL文件*/
    @Test(priority = 4)
    public void 创建DHL订单_文件(){
        new Test_CreateOrder().Test_CreateDHL_Order_File();
    }
    @Test(priority = 5 )
    public void 查询DHL订单_文件(){
        new Test_OrderQuery().Test_Query(DHLtestData.DHLorderNumeber);
    }
    @Test(priority = 6)
    public void 打印DHL订单_文件(){
        new Test_PrintOrder().Test_Print(0,PrintLableData.DHL_LabelASnum_File);
    }
}
