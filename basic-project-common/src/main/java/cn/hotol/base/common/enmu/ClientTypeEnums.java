package cn.hotol.base.common.enmu;

public enum ClientTypeEnums {
    WECHAT(1,"WeChat"),
    IOS(2,"iOS"),
    ANDROID(3,"Android")
    ;
    private int typeCode;
    private String name;

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ClientTypeEnums(int typeCode, String message) {

        this.typeCode = typeCode;
        this.name = message;
    }

    public static Integer getCodeByName(String name) {
        for (ClientTypeEnums statusEnum : ClientTypeEnums.values()) {
            if (statusEnum.getName().equals(name)) {
                return statusEnum.getTypeCode();
            }
        }
        return null;
    }
}
