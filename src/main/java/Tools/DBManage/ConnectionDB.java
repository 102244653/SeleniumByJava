package Tools.DBManage;

import Tools.Logger.LoggerControler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/12/20.
 */
public class ConnectionDB {

    final static LoggerControler log = LoggerControler.getLogger(ConnectionDB.class);

    /**
     * 数据库地址    URL
     * 数据库名     dataname
     * 账号        username
     * 密码        password
     * */
    //连接数据库
    public static Connection StartDB(String URL,String dbname,String username,String password){
        Connection conn=null;
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 创建javademo数据库，MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String connection = "jdbc:mysql://"+URL+"/"+ dbname+"?"+ "user="+username
                +"&password="+password+"&useUnicode=true&characterEncoding=UTF8";

        try{
            // 使用MySQL的驱动，通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以：
            //No.1
            Class.forName("com.mysql.jdbc.Driver").newInstance();// 动态加载mysql驱动
            // No.2
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // No.3
            // new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connection);
            if(conn!=null){
                log.info("数据库链接成功");
            }
        }catch(SQLException e){
            log.error("MySQL链接错误");
            e.printStackTrace();
        } catch (Exception e) {
            log.error("MySQL链接错误");
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeDB(Connection conn){
        try {
        if(!conn.equals(null)){
            conn.close();
            log.info("数据库已断开");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
