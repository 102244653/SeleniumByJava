package Tools.TestNg;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/9/29.
 */
public class ReadHtml {
    public  boolean gethtmltext(String htmlname,String testclass,String testMothod){
        boolean flag=true;
        try {
            String content = readFile(htmlname);
            if (content.contains(testclass)){
                if (content.contains(testMothod+"已执行失败")){
                    flag=false;
                }
            }
        }catch (Exception e){
         e.printStackTrace();
        }
        return flag;
    }


    public  String readFile(String htmlname) throws Exception{
        StringBuilder html = new StringBuilder("");
        int c1;
        FileInputStream H= new FileInputStream(htmlname);
        InputStreamReader in = new InputStreamReader(H, "UTF-8");
        while ((c1 = in.read()) != -1) {
            html.append((char) c1);
        }
        return html.toString();
    }
}
