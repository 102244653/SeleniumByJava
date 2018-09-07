package Tools.DBManage;


import Tools.Logger.LoggerControler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/12/20.
 */
public class DoSQL  {
    final static LoggerControler log = LoggerControler.getLogger(DoSQL.class);

    //查询数据
    public static String MyQuery(Connection conn,String sql,int i){
        String result="null";
        if(conn.equals(null)){
            log.error("数据库连接异常...");
            return result;
        }
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    //根据索引取值
                    result=rs.getString(i);
                    log.info("查询到数据为:"+result);
                }
            }
            //关闭进程
            rs.close();
            try{
                if(stmt!=null){stmt.close();}
            }catch(Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //增加数据
    public static boolean MyAdd(Connection conn,String sql){
        boolean flag=false;
        if(conn.equals(null)){
            return flag;
        }
        try {
            Statement stmt=conn.createStatement();
            flag=stmt.execute(sql);
            if(flag==false){
                log.info("插入数据失败");
            }
            try{
                if(stmt!=null){stmt.close();}
            }catch(Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    //修改数据(updata和delete)
    public static boolean MyModify(Connection conn,String sql){
        boolean flag=false;
        if(conn.equals(null)){
            return flag;
        }
        try {
            Statement stmt=conn.createStatement();
            //语句会返回一个受影响的行数，如果返回-1就没有成功
            int i=stmt.executeUpdate(sql);
            if (i != -1) {
                flag=true;
            }else {
                log.error("更新数据失败");
            }
            try{
                if(stmt!=null){stmt.close();}
            }catch(Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}
