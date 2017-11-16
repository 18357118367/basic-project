package cn.hotol.bp.domain;

import cn.hotol.base.common.util.ResultCodes;

import java.io.Serializable;

public class Rew2Result<T> implements Serializable {

    /**
     * 错误代码 0:成功  其他为异常
     */
    private int code;

    /**
     * 错误详细信息
     */
    private String message = "成功";

    /**
     * 返回的数据，调用失败的是，返回数据为null
     */
    private T data;


    public Rew2Result() {

    }

    public Rew2Result(ResultCodes resultCodes) {
        this.code = resultCodes.getCode();
        this.message = resultCodes.getMessage();
    }


    public Rew2Result(T data) {
        this.data = data;
    }
    


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setResultCodes(ResultCodes resultCodes) {
        this.code = resultCodes.getCode();
        this.message = resultCodes.getMessage();
    }

}
