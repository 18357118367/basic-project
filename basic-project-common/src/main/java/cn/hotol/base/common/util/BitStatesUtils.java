package cn.hotol.base.common.util;

/**
 * @author ZhangZH 二进制状态类
 */
public class BitStatesUtils {


    /**
     * 认证同盾
     */
    public static final long OP_BIND_TONGDUN = 1L;

    /**
     * 认证人脸识别
     */
    public static final long OP_BIND_FACE = 1L << 1;

    /**
     * 认证运营商
     */
    public static final long OP_BASIC_OPERATOR = 1L << 2;

    /**
     * 实名认证
     */
    public static final long OP_REAL_AUTH = 1L << 3;

    /**
     * 有一个借款在审核流程当中
     */
    public static final long HAS_BIDREQUEST_IN_PROCESS = 1L << 4;

    /**
     * 芝麻平台是否授权
     */
    public static final long ZHIMA_AUTHORISE = 1L << 5;

    /**
     * @param states 所有状态值
     * @param value  需要判断状态值
     * @return 是否存在
     */
    public static boolean hasState(long states, long value) {
        return (states & value) != 0;
    }

    /**
     * @param states 已有状态值
     * @param value  需要添加状态值
     * @return 新的状态值
     */
    public static long addState(long states, long value) {
        if (hasState(states, value)) {
            return states;
        }
        return (states | value);
    }

    /**
     * @param states 已有状态值
     * @param value  需要删除状态值
     * @return 新的状态值
     */
    public static long removeState(long states, long value) {
        if (!hasState(states, value)) {
            return states;
        }
        return states ^ value;
    }
}