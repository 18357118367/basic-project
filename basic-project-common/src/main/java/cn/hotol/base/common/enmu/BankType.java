package cn.hotol.base.common.enmu;

/**
 * @author ZhangZH 2017/12/1 15:53
 * 平台支持的银行账户枚举
 */
public enum BankType {

    NONG_YE_BANK(1, "农业银行"),
    JIAO_TONG_BANK(2, "交通银行"),
    GONG_SHANG_BANK(3, "工商银行"),
    YOU_CHU_BANK(4, "邮储银行"),
    PU_FA_BANK(5, "浦发银行"),
    GUANG_FA_BANK(6, "广发银行"),
    PING_AN_BANK(7, "平安银行"),
    ZHAO_SHANG_BANK(8, "招商银行"),
    JIAN_SHE_BANK(9, "建设银行"),
    GUANG_DA_BANK(10, "光大银行"),
    ZHONG_XIN_BANK(11, "中信银行"),
    HUA_XIA_BANK(12, "华夏银行"),
    HANG_ZHOU_BANK(13, "杭州银行"),
    BEI_JING_BANK(14, "北京银行"),
    SHANG_HAI_BANK(15, "上海银行"),
    GUANG_ZHOU_SHANG_YE_BANK(16, "广州市商业银行"),
    NING_BO_BANK(17, "宁波银行");

    private Integer type;
    private String desc;

    BankType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static BankType getBankByType(Integer type) {
        for (BankType bankType : values()) {
            if (bankType.getType().equals(type)) {
                return bankType;
            }
        }
        return null;
    }

    public static BankType getBankByDesc(String desc) {
        for (BankType bankType : values()) {
            if (bankType.getDesc().equals(desc)) {
                return bankType;
            }
        }
        return null;
    }

}
