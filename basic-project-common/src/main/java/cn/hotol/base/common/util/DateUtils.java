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
     * @param current s
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
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.SECOND, 0);
        return (int) ((c2.getTime().getTime() - c1.getTime().getTime()) / (1000 * 3600 * 24));
    }

    /**
     * @return void
     * @description 针对前端只传一个时间的特殊处理。
     * @params [startTime, endTime]
     * @date 2017/12/7 20:05
     */
    public static void formatParmsDate(Date startTime, Date endTime) {
        if (startTime == null && endTime != null) {
            startTime = getFirstDate(endTime);
            endTime = getEndDate(endTime);
        }
        if (endTime == null && startTime != null) {
            startTime = getFirstDate(startTime);
            endTime = getEndDate(startTime);
        }
    }

    /**
     * 计算两个日期相差的月份数
     *
     * @param date1 日期1
     * @param date2 日期2
     * @param pattern  日期1和日期2的日期格式
     * @return  相差的月份数
     * @throws ParseException
     */
    public static int countMonths(String date1,String date2,String pattern) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
        //开始日期若小月结束日期
        if(year<0){
            year=-year;
            return year*12+c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH);
        }
        return year*12+c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);
    }

    /**
     * @description     获取当前日期，以字符串形式返回
     * @param pattern   日期格式
     * @return          当前日期 （字符串）
     * @Date 2018/1/22 14:52
     */
    public static String getCurrentDateStr(String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Date date=new Date();
        return sdf.format(date);
    }

    /**
     * 时间比较
     *
     * @param date1
     * @param date2
     * @return date2>=date1 true ;date2<date1 false
     */
    public static Boolean compareWithDay(Date date1,Date date2){
        if (date1 == null || date2 == null){
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(SIMPLE_FORMAT);
        String one = dateFormat.format(date1);
        String two = dateFormat.format(date2);
        if (one.compareTo(two) <= 0){
            return true;
        }
        return false;
    }

}
