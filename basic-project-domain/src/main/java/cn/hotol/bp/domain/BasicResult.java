package cn.hotol.bp.domain;

import java.io.Serializable;

public class BasicResult<T> implements Serializable {

    private static final long serialVersionUID = 308206823825564261L;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 是否成功
     */

    private boolean success;

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
     * 配置信息
     */
    private String config;

    /**
     * 基本信息
     *
     */
    private String info;

    /**
     * 系统请求唯一序列号
     */
    private String key;

    public BasicResult(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public BasicResult() {

    }

    public BasicResult(boolean success, int code, String message, T data, int a) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.message = message;
        totalPage = a;
    }

    public BasicResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public BasicResult(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public BasicResult(boolean success, int code, String message, String key) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.key = key;
    }

    public BasicResult(boolean success, T data, String key) {
        this.success = success;
        this.data = data;
        this.key = key;
    }

    public BasicResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BasicResult(int code, String message, T data) {
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
        setSuccess(true);
        this.data = data;
    }

    public BasicResult(T data, String key) {
        setSuccess(true);
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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}