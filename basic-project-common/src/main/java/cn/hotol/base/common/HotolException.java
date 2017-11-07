package cn.hotol.base.common;


import cn.hotol.bp.domain.ResultCodes;

public class HotolException extends RuntimeException{
    private ResultCodes rspCode;


    public HotolException() {
        super();
    }

    public HotolException(ResultCodes rspCode) {
        this.rspCode = rspCode;
    }

    public ResultCodes getRspCode() {
        return rspCode;
    }

    public void setRspCode(ResultCodes rspCode) {
        this.rspCode = rspCode;
    }
}
