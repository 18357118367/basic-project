package cn.hotol.base.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * @author ZhangZH 2017/12/7 20:08
 */
public class DecimalUtil {
    private final static Logger logger = LoggerFactory.getLogger(DecimalUtil.class);

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
    public static BigDecimal formatDecimal(BigDecimal bigDecimal, int scale) {
        return bigDecimal == null ? new BigDecimal(0) : bigDecimal.setScale(scale, RoundingMode.DOWN);
    }

    /**
     * @return java.math.BigDecimal
     * @description 格式化BigDecimal
     * @params [bigDecimal]
     * @date 2017/12/7 20:06
     */
    public static BigDecimal formatTwoDecimal(BigDecimal bigDecimal) {
        return bigDecimal == null ? BigDecimal.ZERO : bigDecimal.setScale(2, RoundingMode.DOWN);
    }

    //计算利息
    public static BigDecimal interestCalculate(Date loanDayStart, Date loanDayEnd, BigDecimal interestRate, BigDecimal amount) {
        if (interestRate.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        int dayNumber = DateUtils.differentDaysByMillisecond(loanDayStart, loanDayEnd);
        logger.debug("DecimalUtil.interestCalculate[dayNumber:{}]", dayNumber);
        return interestCalculate(dayNumber, interestRate, amount);
    }

    //计算利息
    public static BigDecimal interestCalculate(int dayNumber, BigDecimal interestRate, BigDecimal amount) {
        if (interestRate.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal a = interestRate.multiply(new BigDecimal(dayNumber)).setScale(10, BigDecimal.ROUND_DOWN).
                divide(new BigDecimal(360).setScale(10, BigDecimal.ROUND_DOWN)
                        , BigDecimal.ROUND_DOWN).multiply(amount.setScale(10,BigDecimal.ROUND_DOWN));
        logger.debug("DecimalUtil.interestCalculate[a:{}]", a);
        return a;
    }
}
