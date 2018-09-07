package Tools.Tool;

import Tools.Element.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 * 表格操作类
 */
public class Table extends WaitElement {
    public  String tablecell(By by,String adress){
        //获取表元素
        WebElement table= WaitElement.findElement(by);
        //拆分表格行列地址
        int index=adress.trim().indexOf('.');
        int row=Integer.parseInt(adress.substring(0, index));
        int cell=Integer.parseInt(adress.substring(index + 1));
        //获取表格所有元素
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        //获取表格行信息
        WebElement therow=rows.get(row);
        //获取列信息
        String text=getcell(therow, cell).getText();

        return text;
    }

    public  WebElement getcell(WebElement Row, int cell){
        List<WebElement> cells=null;
        //=new ArrayList<WebElement>()
        WebElement target=null;
        if(WaitElement.findElements(By.tagName("th")).size()>0){
            cells= Row.findElements(By.tagName("th"));
            target=cells.get(cell);
        }
        if(WaitElement.findElements(By.tagName("td")).size()>0){
            cells= Row.findElements(By.tagName("td"));
            target=cells.get(cell);
        }
        return target;
    }
}
