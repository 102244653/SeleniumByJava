package Tools.Tool;

import Tools.Logger.LoggerControler;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

/**
 * Created by Administrator on 2017/8/16.
 */
public class MyExcel {
    final static LoggerControler log = LoggerControler.getLogger(MyExcel.class);
    HSSFSheet sheet;
    //创建excel工作对象
    public MyExcel(String path, String sheetname){
        try {
            //创建workbook
            File file = new File(path);
            FileInputStream fs = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fs);
            sheet = workbook.getSheet(sheetname);
            log.info("读取到"+sheetname);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //单元格读取
    public String readFromExcelCell(int rowIndex, int cellIndex){
        HSSFRow row = sheet.getRow(rowIndex);
        if (row == null) {
            log.error(rowIndex+"行不存在");
            return  null;
        }
        HSSFCell cell = row.getCell(cellIndex);
        if (cell == null) {
            log.error(cellIndex+"列不存在");
            return  null;
        }
        int cellType = cell.getCellType();
        String S;
        switch (cellType)
        {
            default:
            case 1 :
            {
                S=String.valueOf(cell.getStringCellValue());
                log.info("读取到单元格["+rowIndex+"."+cellIndex+"]的值："+S);
                break;
            }
            case 0 :
            {
                S =String.valueOf(cell.getNumericCellValue());
                log.info("读取到单元格["+rowIndex+"."+cellIndex+"]的值："+S);
                break;
            }
        }
        return S;
    }

    //整行读取
    public String[] readFromExcelrow(int rowIndex) {
        HSSFRow row = sheet.getRow(rowIndex);
        if (row == null) {
            log.error(rowIndex+"行不存在");
            return  null;
        }
        String[] result=new String[row.getLastCellNum()];
        for(int i=0;i<row.getLastCellNum();i++){
            HSSFCell cell = row.getCell(i);
            int cellType = cell.getCellType();
            switch (cellType)
            {
                default:
                case 1 :
                {
                    result[i] =String.valueOf(cell.getStringCellValue());
                    log.info("读取到单元格["+rowIndex+"."+i+"]信息："+result[i]);
                    break;
                }
                case 0 :
                {
                    result[i] =String.valueOf(cell.getNumericCellValue());
                    log.info("读取到单元格["+rowIndex+"."+i+"]信息："+result[i]);
                    break;
                }
            }
        }
        return result;
    }
    //整列读取
    public String[] readFromExcelcolumn(int columnIndex){
        //行数
        int rowid=getrows();
        String[] result=new String[rowid];
        for (int k=0;k<rowid;k++){
            HSSFRow row = sheet.getRow(k);
            if (row == null) {
                log.error(k+"行不存在");
                return  null;
            }
            HSSFCell cell = row.getCell(columnIndex);
            if (cell == null) {
                log.error(columnIndex+"列不存在");
                return  null;
            }
            int cellType = cell.getCellType();
            switch (cellType)
            {
                default:
                case 1 :
                {
                    result[k] =String.valueOf(cell.getStringCellValue());
                    log.info("读取到单元格["+columnIndex+"."+k+"]信息："+result[k]);
                    break;
                }
                case 0 :
                {
                    result[k]=String.valueOf(cell.getNumericCellValue());
                    log.info("读取到单元格["+columnIndex+"."+k+"]信息："+result[k]);
                    break;
                }
            }
        }
        return result;
    }

    //单元格写入
    public void writeToExcelCell(int rowIndex, int cellIndex, String value) {
        HSSFRow row = sheet.getRow(rowIndex);
        //判断行是否存在
        if (row == null) {
            row = sheet.createRow(rowIndex);
            log.info("行号不存在，新建行"+rowIndex);
        }
        HSSFCell cell = row.getCell(cellIndex);
        //判断列是否存在
        if (cell == null) {
            cell = row.createCell(cellIndex);
            log.info("单元格不存在，新建单元格["+rowIndex+"."+cellIndex+"]");
        }
        cell.setCellValue(value);
        log.info("单元格["+rowIndex+"."+cellIndex+"]成功写入信息："+value);
    }

    //清除单元格
    public void  deletecell(int rowIndex, int cellIndex){
        HSSFRow row = sheet.getRow(rowIndex);
        if (row == null) {
            log.error(rowIndex + "行不存在");
            return ;
        }
        HSSFCell cell = row.getCell(cellIndex);
        if (cell == null) {
            log.error(cellIndex+"列不存在");
            return ;
        }else {
            row.removeCell(cell);
        }
    }

    //获取为空的行数序号
    public int getNullRow() {
        int i;
        for (i=4;i<200;i++) {
            String result = readFromExcelCell(i, 0);
            if (result == null) {
                log.info(i+"行为空行");
                break;
            }
        }
        return i;
    }

    //获取总行数
    public int getrows(){
        int row=sheet.getLastRowNum();
        log.info("当前页总行数为："+row);
        return row;
    }

    //整行写入
    public void writeToExcelRows( String[] value) {
        int rowid=getNullRow();
        //创建行
        HSSFRow row = sheet.createRow(rowid);
        for(int i=0;i<value.length;i++){
            //创建列
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(value[i]);
            log.info("单元格["+rowid+"."+i+"]写入值："+value[i]);
        }
    }

    //修改后保存Excel
    public void save (String path){
        try {
            // 首先要创建一个原始Excel文件的输出流对象！
            FileOutputStream excelFileOutPutStream = new FileOutputStream(path);
            // 将最新的 Excel 文件写入到文件输出流中，更新文件信息！
            sheet.getWorkbook().write(excelFileOutPutStream);
            // 执行 flush 操作， 将缓存区内的信息更新到文件上
            excelFileOutPutStream.flush();
            // 使用后，及时关闭这个输出流对象， 好习惯，再强调一遍！
            excelFileOutPutStream.close();
            log.info(path+"保存成功");
        }
        catch (Exception e){log.info(path+"保存失败");}
    }
}
