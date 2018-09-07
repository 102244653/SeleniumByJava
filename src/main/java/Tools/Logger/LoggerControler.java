package Tools.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Created by Administrator on 2017/9/27.
 */
public class LoggerControler {
    private static Logger logger = null;
    private static LoggerControler logg = null;
    static String path = System.getProperty("user.dir");

    public static LoggerControler getLogger(Class<?> T) {
        if (logger == null) {
//            实例化一个 Properties 类，处理log4j.Properties文件
            Properties props = new Properties();
            PropertyConfigurator.configure(props);
            try {
//                获取log4j配置文件路径
                String envPaht = path +"/config/log4j.properties";
                InputStream is = new FileInputStream(envPaht);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            log4j 的PropertyConfigurator 类的configure方法输入数据流
            PropertyConfigurator.configure(props);
            logger = Logger.getLogger(T);
            logg = new LoggerControler();
        }
        return logg;
    }

    /**
     * 重写logger方法
     */
    public void info(String msg) {
        logger.info(msg);
    }

    public void debug(String msg) {
        logger.debug(msg);
    }

    public void warn(String msg) {
        logger.warn(msg);
    }

    public void error(String msg) {
        logger.error(msg);
    }
}


//         String date= new  mydate().getdata(mydate.TEN_PAY_DATE_STRING_FORMAT);
//         String date1= new mydate().getdata(mydate.time8);
 /*Log4j建议只使用四个级别，优先级从高到低分别是ERROR、WARN、INFO、DEBUG
//	   这里定义能显示到的最低级别,若定义到INFO级别,则看不到DEBUG级别的信息了~!级别后面是输出端*/
//            props.setProperty("log4j.rootLogger", "DEBUG, CONSOLE, logfile");
//            props.setProperty("log4j.appender.CONSOLE", "org.apache.log4j.ConsoleAppender");
//            props.setProperty("log4j.appender.CONSOLE.Target", "System.out");
//            props.setProperty("log4j.appender.CONSOLE.Threshold", "info");
//            props.setProperty("log4j.appender.CONSOLE.layout", "org.apache.log4j.PatternLayout");
//            props.setProperty("log4j.appender.CONSOLE.layout.ConversionPattern", "[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");
//
//            String src=path+"/src/main/resources/log/";
//            //获取当前日期
//            File dir = new File(src+date);
//            if (!dir.exists())
//            {dir.mkdirs();}
//            String filepath=src+date+"/"+date1+".txt";
//            props.setProperty("log4j.appender.logfile.encoding","UTF-8");
//            props.setProperty("log4j.appender.logfile","org.apache.log4j.FileAppender");
//            props.setProperty("log4j.appender.logfile.file",filepath);
//            props.setProperty("log4j.appender.logfile.layout","org.apache.log4j.PatternLayout");
//            props.setProperty("log4j.appender.logfile.layout.ConversionPattern", "[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");

