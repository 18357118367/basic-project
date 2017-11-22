package cn.hotol.bp.domain;

import java.io.Serializable;

public class BasicResult<T> implements Serializable {

    private static final long serialVersionUID = 308206823825564261L;
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

    /**
     * 系统请求唯一序列号
     */
    private String key;


    public BasicResult() {

    }

    public BasicResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BasicResult(int code, String message , T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BasicResult(int code, String message, String key) {
        this.code = code;
        this.message = message;
        this.key = key;
    }

    public BasicResult(T data) {
        this.data = data;
    }
    public BasicResult(T data, String key) {
        this.data = data;
        this.key = key;
    }



    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
