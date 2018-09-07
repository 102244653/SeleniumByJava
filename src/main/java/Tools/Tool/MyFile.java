package Tools.Tool;


import Tools.Logger.LoggerControler;

import java.io.File;

/**
 * Created by Administrator on 2017/7/21.
 * 创建文件夹
 */
public class MyFile {
    final static LoggerControler log = LoggerControler.getLogger(MyFile.class);
    /**
     * 判断文件是否存在
     *
     * @param filePath 文件路劲
     * @return ture  or  false
     */
    public  boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }

    /**
     * 判断文件是否存在，没有就新建
     *
     * @param filePath 文件路径
     */
    public static void creatFile(String filePath) {
        MyFile myFile = new MyFile();
        if(myFile.fileExists(filePath)==false) {
            File file = new File(filePath);
            file.mkdir();
            log.info("创建文件："+filePath);
        }
    }

    /**
     * 删除目录及目录下所有文件和文件夹
     */
    public  void deleteDirectory(String directoryPath) {
        File file = new File(directoryPath);
        if (file.isDirectory()) { //是文件夹
            File temp = null;
            String[] childsFile = file.list(); //获得该目录下的子文件及子文件夹
            for (String s : childsFile) {
                //检查folderPath是不是以"\"节尾
                if (directoryPath.endsWith(File.separator)) {
                    temp = new File(directoryPath + s);
                } else {
                    temp = new File(directoryPath + File.separator + s);
                }
                //delete file
                if (temp != null && temp.isFile()) {  //是文件
                    System.out.println(temp.delete());
                    log.info("删除文件: " + temp.getAbsolutePath());
                } else if (temp != null && temp.isDirectory()) {  //是文件夹
                    deleteDirectory(temp.getAbsolutePath());
                    log.info("删除文件夹: " + temp.getAbsolutePath());
                }
            }
            file.delete();
        } else if (file.isFile()) {
            file.delete();
        }
    }

    //读取文件夹下的文件名称
    public String[] GetFileName(File file){
        String[] filename=null;
        try{
            File fa[] = file.listFiles();
            filename=new String[fa.length];
            for (int i = 0; i < fa.length; i++) {
                File fs = fa[i];
               String name=fs.getName();
                if (fs.isDirectory()) {
                    log.info(name + "是目录");
                } else {
                    log.info(name + "是文件");
                }
                filename[i]=name.substring(name.lastIndexOf("\\")+1).trim();
            }
        }catch (Exception e){
            filename=null;
            e.printStackTrace();
            log.error("读取文件名失败");
        }
        return filename;
    }
}
