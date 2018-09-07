package Test_Case;

import CES_QT.PageAction.OrderManage.*;
import CES_QT.PageAction.QTLogin.DoLogin;
import TestData.QT_DATA.ESBtestData;
import TestData.QT_DATA.PrintLableData;
import Tools.Assert.MyAssert;
import Tools.Tool.Time;
import org.testng.annotations.Test;

public class Test_CreateOrder extends DoLogin{
/**创建E速宝产品订单*/
    public void Test_CreateESBR_Order(String Product_Code ,String Country_Code,String consignee_city,String consignee_postcode){
        CreatESB CreatESB=new CreatESB();
        try {
            CreatESB.OpenESBpage();
            CreatESB.OrderInfo(Product_Code,Country_Code);
            CreatESB.consignee(consignee_city,consignee_postcode);
            CreatESB.product(3);
            CreatESB.submit();
//            OrderManage.OrderQuery(ESBtestData.ESBorderNumeber);
//            PrintLabel.printOrderLabel(PrintLableData.ESB_LabelASnum_YunTu);
        } catch (Exception e) {
            e.printStackTrace();
            MyAssert.assertTrue(false);
        }
    }
/**创建FBA产品订单*/
    public void Test_CreateFBA_Order(){
        CreatFBA CreatFBA=new CreatFBA();
        try{
            CreatFBA.OpenFBA();
            CreatFBA.SelectService();
            CreatFBA.UploadBill();
            Time.wait(1000);
            CreatFBA.UploadList();
            Time.wait(1000);
            CreatFBA.consignee_Info();
            CreatFBA.AddBox();
            CreatFBA.ProInfo(2);
            CreatFBA.selectSender(2);
            CreatFBA.submit();
        }catch (Exception e){
            e.printStackTrace();
            MyAssert.assertTrue(false);
        }
    }
    /**创建FBA_日本线产品订单*/
    public void Test_CreateJapan_FBA_Order(){
        CreatJapan_FBA CreatJapan_FBA=new CreatJapan_FBA();
        try{
            CreatJapan_FBA.OpenJapanFBA();
            CreatJapan_FBA.UploadBill();
            Time.wait(1000);
            CreatJapan_FBA.UploadList();
            Time.wait(1000);
            CreatJapan_FBA.ReciverInfo();
            CreatJapan_FBA.AddBox(2);
            CreatJapan_FBA.BoxInfo(3);
            CreatJapan_FBA.ProInfo(3);
            CreatJapan_FBA.DeleteBox(1);
            CreatJapan_FBA.SelectSender(2);
            CreatJapan_FBA.SubmitJapan();
        }catch (Exception e){
            e.printStackTrace();
            MyAssert.assertTrue(false);
        }
    }

    /**创建中速—DHL产品订单
     * 类型为物品*/
    public void Test_CreateDHL_Order_Goods(){
        CreateDHL CreateDHL=new CreateDHL();
        PrintLabel CloseInvoce=new PrintLabel();
        try{
            CreateDHL.OpenDHLpage();
            CreateDHL.Shipper_Info();
            CreateDHL.Consignee_Info();
            CreateDHL.order_type(2);
            CreateDHL.order_Info(3);
            CreateDHL.Invoice(3);
            CreateDHL.submit();
            CloseInvoce.ClosePrintInvoice();
        }catch (Exception e){
            e.printStackTrace();
            MyAssert.assertTrue(false);
        }
    }
    /**创建中速—DHL产品订单
     * 类型为文件*/
    public void Test_CreateDHL_Order_File(){
        CreateDHL CreateDHL=new CreateDHL();
        PrintLabel CloseInvoce=new PrintLabel();
        try{
            CreateDHL.OpenDHLpage();
            CreateDHL.Shipper_Info();
            CreateDHL.Consignee_Info();
            CreateDHL.order_type(1);
            CreateDHL.order_Info(3);
            CreateDHL.submit();
            CloseInvoce.ClosePrintInvoice();
        }catch (Exception e){
            e.printStackTrace();
            MyAssert.assertTrue(false);
        }
    }
    /**创建香港HKEMS产品订单
     * 类型为文件*/
    public void Test_CreateHK_Order(int i){
        CreatHK CreatHK=new CreatHK();
        try{
            CreatHK.OpenHKpage();
            CreatHK.Shipper_Info();
            CreatHK.Consignee_Info();
            CreatHK.order_type(i);
            CreatHK.orderinfo(3);
            CreatHK.submit();
        }catch (Exception e){
            e.printStackTrace();
            MyAssert.assertTrue(false);
        }
    }
    /**创建FedEX产品订单
     * 类型为文件*/
    public void Test_CreateFedEx_Order_File(int i){
        CreateFedEX CreateFedEX=new CreateFedEX();
        try {
            CreateFedEX.openpage();
            CreateFedEX.shipper();
            CreateFedEX.consignee();
            CreateFedEX.order_type(1);
            CreateFedEX.File_orderinfo();
            CreateFedEX.submit();
        }catch (Exception e){
            e.printStackTrace();
            MyAssert.assertTrue(false);
        }
    }
    /**创建FedEX产品订单
     * 类型为物品*/
    public void Test_CreateFedEx_Order_Goods(int i){
        CreateFedEX CreateFedEX=new CreateFedEX();
        try {
            CreateFedEX.openpage();
            CreateFedEX.shipper();
            CreateFedEX.consignee();
            CreateFedEX.order_type(i);
            CreateFedEX.Goods_orderinfo();
            CreateFedEX.submit();
        }catch (Exception e){
            e.printStackTrace();
            MyAssert.assertTrue(false);
        }
    }
}
