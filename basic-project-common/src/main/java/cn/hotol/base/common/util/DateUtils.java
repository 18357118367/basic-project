package cn.hotol.base.common.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
