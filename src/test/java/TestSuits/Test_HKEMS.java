package TestSuits;

import CES_QT.PageAction.QTLogin.DoLogin;
import TestData.QT_DATA.HKtestData;
import TestData.QT_DATA.PrintLableData;
import Test_Case.Test_CreateOrder;
import Test_Case.Test_OrderQuery;
import Test_Case.Test_PrintOrder;
import org.testng.annotations.Test;

public class Test_HKEMS extends DoLogin{
    /**测试用列1
     * 创建并打印HKEMS文件*/
    @Test(priority = 1)
    public void 创建HKEMS订单_文件(){
        new Test_CreateOrder().Test_CreateHK_Order(1);
    }
    @Test(priority = 2 )
    public void 查询HKEMS订单_文件(){
        new Test_OrderQuery().Test_Query(HKtestData.HKEMSordernumeber);
    }
    @Test(priority = 3)
    public void 打印HKEMS订单_文件(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.HK_LabelASnum_File);
    }
    /**测试用列2
     * 创建并打印HKEMS物品*/
    @Test(priority = 4)
    public void 创建HKEMS订单_物品(){
        new Test_CreateOrder().Test_CreateHK_Order(2);
    }
    @Test(priority = 5 )
    public void 查询HKEMS订单_物品(){
        new Test_OrderQuery().Test_Query(HKtestData.HKEMSordernumeber);
    }
    @Test(priority = 6)
    public void 打印HKEMS订单_物品(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.HK_LabelASnum_File);
    }
}
