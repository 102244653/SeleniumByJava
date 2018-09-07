package CES_QT.PageAction.QTLogin;

import Tools.BaseAction.MyActions;
import Tools.Tool.MyFile;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/3/13.
 */
public class DeleteReport {

    @Test
    public void DeleteReprot(){
        String path= MyActions.getpath()+"\\TestReport";
        MyFile file=new MyFile();
        List<Integer> nums = new ArrayList<Integer>();
        try{
            File f=new File(path);
            if(!file.fileExists(path)){
                return;
            }
            String[] listname=file.GetFileName(f);
            if(listname.length>2){
                for(int i=0;i<listname.length;i++){
                    nums.add(Integer.valueOf(listname[i]));
                }
               int min = Collections.min(nums);
               file.deleteDirectory(path+"\\"+min);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("删除文件失败");
        }
    }
}
