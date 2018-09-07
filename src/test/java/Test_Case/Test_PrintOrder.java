package Test_Case;

import CES_QT.PageAction.OrderManage.PrintLabel;
import CES_QT.PageAction.OrderManage.PrintLable0;
import CES_QT.PageAction.QTLogin.DoLogin;
import Tools.Assert.MyAssert;

public class Test_PrintOrder extends DoLogin{
    //测试标签打印—打印面单
    public void Test_Print(int i,String ASnum_xpath){
        try {
           // PrintLabel.printOrderLabel(ASnum_xpath);
            PrintLable0.OpenLablePage();
            PrintLable0.printOrderLabel(i,ASnum_xpath);
            MyAssert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            MyAssert.assertTrue(false);
        }
    }

}
