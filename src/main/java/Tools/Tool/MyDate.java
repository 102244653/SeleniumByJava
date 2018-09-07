package Tools.Tool;


import Tools.Logger.LoggerControler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2017/7/21.
 * 获取时间
 */
public class MyDate {
    final static LoggerControler log = LoggerControler.getLogger(MyDate.class);

    public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd";

    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String SMALL_DATE_FORMAT = "MM-dd";

    public static final String ABC_ORDER_DATE_FORMAT = "yyyy/MM/dd";

    public static final String ABC_ORDER_TIME_FORMAT = "HH:mm:ss";

    public static final String LOTTERY_PRINTING_TIME_FORMAT = "HH_mm_ss";

    public static final String CHECK_LOG_FORMAT = "yyMMddHHmm";

    public static final String TEN_PAY_DATE_STRING_FORMAT = "yyMMdd";

    public static final String REPORT_CSV_FORMAT = "yyyyMMdd_HHmmss";

    public static final String ZH_DATE_FORMAT = "yyyy年MM月dd日 HH:mm:ss";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd HH-mm-ss";

    public static final String time8 = "MMddHHmmss";

    //	引入SimpleDateFormat类处理时间
    private static SimpleDateFormat simpleDateFormat;

    public  String getdata(String type) {
        simpleDateFormat = new SimpleDateFormat(type);
        String s = simpleDateFormat.format(new java.util.Date());
        log.info(s);
        return s;
    }

    public static String format(String type) {
        simpleDateFormat = new SimpleDateFormat(type);
        String s = simpleDateFormat.format(new java.util.Date());
        log.info(s);
        return s;
    }

    //获取系统时间，毫秒级别
    public  long time() {
        long t = System.currentTimeMillis();
        log.info(String.valueOf(t));
        return t;
    }

    //对系统当前时间增加n天
    public static String format(String type, int n) {
        SimpleDateFormat sf = new SimpleDateFormat(type);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, n);
        String s=sf.format(c.getTime());
        log.info(s);
        return s;
    }
}
