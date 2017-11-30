package cn.hotol.base.common.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by shenJianKang on 2017/11/28.
 */
public class DateUtils {

    public final static String FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String SIMPLE_FORMAT = "yyyy-MM-dd";

    /**
     * 字符串转时间格式
     *
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        Date date = null;
        if (!StringUtils.isEmpty(str)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 获取两个时间之间的秒数
     */
    public static long getSecondsBetween(Date d1, Date d2) {
        return Math.abs((d1.getTime() - d2.getTime()) / 1000);
    }

    /**
     * 获取当天最后一秒
     *
     * @param current
     * @return
     */
    public static Date getEndDate(Date current) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }


    /**
     * 获取当天第一秒
     *
     * @param current
     * @return
     */
    public static Date getFirstDate(Date current) {
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * @return int 天数
     * @description 两个日期相差的天数，第一个比第二个日期小返回正数，反之负数
     * @params [date1, date2]
     * @date 2017/11/29 10:35
     */
    private int differentDaysByMillisecond(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
    }

}
