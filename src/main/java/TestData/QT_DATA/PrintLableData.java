package TestData.QT_DATA;


public class PrintLableData {
    //存放需要打印的订单号
    public static String Print_OrderNum;
    //流水订单号对应的AS单号
    public static String AS_Num;

    /**各种渠道上面单上的AS单号*/
    //E速宝—云途
    public static String ESB_LabelASnum_YunTu=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[16]";
    //E速宝—赛诚
    public static String ESB_LabelASnum_SaiCheng=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[23]";
    //E速宝—AUS(澳大利亚专递)
    public static String ESB_LabelASnum_AUS=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[27]";
    //E速宝—赛诚(澳大利亚小包)
    public static String ESB_LabelASnum_SaiCheng_AT=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[22]";
    //E速宝—迦递（印度）
    public static String ESB_LabelASnum_GATI=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[15]";
    //FBA—美国面单
    public static String FBA_LabelASnum_US=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[8]";
    //日本FBA—日本渠道面单
    public static String JapanFBA_LabelASnum_Japan=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[6]";
    //中速-DHL面单（文件）
    public static String DHL_LabelASnum_File=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[3]";
    //HKEMS面单（文件）
    public static String HK_LabelASnum_File=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[27]";
    //FedEX面单（文件）
    public static String FedEx_LabelASnum_File=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[46]";
    //FedEX面单（文件）
    public static String FedEx_LabelASnum_Goods=".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[61]";
}
