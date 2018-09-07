package TestSuits;

import CES_QT.PageAction.QTLogin.DoLogin;
import TestData.QT_DATA.ESBtestData;
import TestData.QT_DATA.PrintLableData;
import Test_Case.Test_CreateOrder;
import Test_Case.Test_OrderQuery;
import Test_Case.Test_PrintOrder;
import org.testng.annotations.Test;

public class Test_ESB extends DoLogin {
//    private static Object[][] obj;
//    @DataProvider()
//    public static Object[][] Provider( ) {
//        obj= new Object[][]{{"E速宝小包", "德国","Cortlandfgdg","69561"}, {"E速宝专递(有妥投信息)","德国","Cortlandfgdg","69561"}};
//        return  obj;
//    }
    /**测试用列1
     * 创建并打印E速宝小包—云途*/
    @Test(priority = 1)
    public void 创建E速宝小包订单_云途(){
        new Test_CreateOrder().Test_CreateESBR_Order("E速宝小包", "德国","Cortlandfgdg","69561");
    }
    @Test(priority = 2 )
    public void 查询E速宝小包订单_云途(){
        new Test_OrderQuery().Test_Query(ESBtestData.ESBorderNumeber);
    }
    @Test(priority = 3)
    public void 打印E速宝小包订单_云途(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.ESB_LabelASnum_YunTu);
    }
    /**测试用列2
     * 创建并打印E速宝专递—云途*/
    @Test(priority = 4)
    public void 创建E速宝专递订单_云途(){
        new Test_CreateOrder().Test_CreateESBR_Order("E速宝专递(有妥投信息)","德国","Cortlandfgdg","69561");
    }
    @Test(priority = 5 )
    public void 查询E速宝专递订单_云途(){
        new Test_OrderQuery().Test_Query(ESBtestData.ESBorderNumeber);
    }
    @Test(priority = 6)
    public void 打印E速宝专递订单_云途(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.ESB_LabelASnum_YunTu);
    }
    /**测试用列3
     * 创建并打印E速宝小包—赛程*/
    @Test(priority = 7)
    public void 创建E速宝小包订单_赛程(){
        new Test_CreateOrder().Test_CreateESBR_Order("E速宝小包","泰国","Cortlandfgdg","69561");
    }
    @Test(priority = 8)
    public void 查询E速宝小包订单_赛程(){
        new Test_OrderQuery().Test_Query(ESBtestData.ESBorderNumeber);
    }
    @Test(priority = 9)
    public void 打印E速宝小包订单_赛程(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.ESB_LabelASnum_SaiCheng);
    }
    /**测试用列4
     * 创建并打印E速宝专递—赛程*/
    @Test(priority = 10)
    public void 创建E速宝专递订单_赛程(){
        new Test_CreateOrder().Test_CreateESBR_Order("E速宝专递(有妥投信息)","泰国","Cortlandfgdg","69561");
    }
    @Test(priority = 11)
    public void 查询E速宝专递订单_赛程(){
        new Test_OrderQuery().Test_Query(ESBtestData.ESBorderNumeber);
    }
    @Test(priority = 12)
    public void 打印E速宝专递订单_赛程(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.ESB_LabelASnum_SaiCheng);
    }
    /**测试用列5
     * 创建并打印E速宝小包—澳大利亚*/
    @Test(priority = 13)
    public void 创建E速宝小包订单_赛程_澳大利亚(){
        new Test_CreateOrder().Test_CreateESBR_Order("E速宝小包","澳大利亚","maitland","2320");
    }
    @Test(priority = 14)
    public void 查询E速宝小包订单_赛程_澳大利亚(){
        new Test_OrderQuery().Test_Query(ESBtestData.ESBorderNumeber);
    }
    @Test(priority = 15)
    public void 打印E速宝小包订单_赛程_澳大利亚(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.ESB_LabelASnum_SaiCheng_AT);
    }
    /**测试用列6
     * 创建并打印E速宝专递—AUS*/
    @Test(priority = 16)
    public void 创建E速宝小包订单_AUS_澳大利亚(){
        new Test_CreateOrder().Test_CreateESBR_Order("E速宝专递(有妥投信息)","澳大利亚","maitland","2320");
    }
    @Test(priority = 17)
    public void 查询E速宝小包订单_AUS_澳大利亚(){
        new Test_OrderQuery().Test_Query(ESBtestData.ESBorderNumeber);
    }
    @Test(priority = 18)
    public void 打印E速宝小包订单_AUS_澳大利亚(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.ESB_LabelASnum_AUS);
    }
    /**测试用列7
     * 创建并打印E速宝小包—GATI*/
    @Test(priority = 19)
    public void 创建E速宝小包订单_迦递(){
        new Test_CreateOrder().Test_CreateESBR_Order("E速宝小包","INDIA","Cortlandfgdg","855102");
    }
    @Test(priority = 20)
    public void 查询E速宝小包订单_迦递(){
        new Test_OrderQuery().Test_Query(ESBtestData.ESBorderNumeber);
    }
    @Test(priority = 21)
    public void 打印E速宝小包订单_迦递(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.ESB_LabelASnum_GATI);
    }
    /**测试用列8
     * 创建并打印E速宝专递—GATI*/
    @Test(priority = 22)
    public void 创建E速宝专递订单_迦递(){
        new Test_CreateOrder().Test_CreateESBR_Order("E速宝专递(有妥投信息)","INDIA","Cortlandfgdg","855102");
    }
    @Test(priority = 23)
    public void 查询E速宝专递订单_迦递(){
        new Test_OrderQuery().Test_Query(ESBtestData.ESBorderNumeber);
    }
    @Test(priority = 24)
    public void 打印E速宝专递订单_迦递(){
        new Test_PrintOrder().Test_Print(1,PrintLableData.ESB_LabelASnum_GATI);
    }
}
