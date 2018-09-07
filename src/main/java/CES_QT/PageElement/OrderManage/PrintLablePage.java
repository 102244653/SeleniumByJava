package CES_QT.PageElement.OrderManage;

import org.openqa.selenium.By;

public class PrintLablePage {
    //菜单链接
    public static By Lable= By.linkText("标签打印");
    //iframe
    public static String iframe="resultFrame";
    //运单号或跟踪单号
    public static By Order_code=By.id("order_code");
    //打印按钮
    public static By printBtn=By.xpath(".//*[@id='pring_order_id_wrap']/input[2]");
}
