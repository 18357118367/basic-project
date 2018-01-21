package cn.hotol.base.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author ZhangZH 2017/12/7 20:08
 */
public class DecimalUtil {

    /**
     * @return java.math.BigDecimal
     * @description 格式化BigDecimal
     * @params [bigDecimal]
     * @date 2017/12/7 20:06
     */
    public static BigDecimal formatDecimal(BigDecimal bigDecimal) {
        return bigDecimal == null ? new BigDecimal(0) : bigDecimal.setScale(4, RoundingMode.DOWN);
    }

    /**
     * @return java.math.BigDecimal
     * @description 格式化BigDecimal
     * @params [bigDecimal]
     * @date 2018年1月21日14:51:02
     */
    public static BigDecimal formatDecimal(BigDecimal bigDecimal,int scale) {
        return bigDecimal == null ? new BigDecimal(0) : bigDecimal.setScale(scale, RoundingMode.DOWN);
    }

    /**
     * @return java.math.BigDecimal
     * @description 格式化BigDecimal
     * @params [bigDecimal]
     * @date 2017/12/7 20:06
     */
    public static BigDecimal formatTwoDecimal(BigDecimal bigDecimal) {
        return bigDecimal == null ? new BigDecimal(0) : bigDecimal.setScale(2, RoundingMode.DOWN);
    }
}
