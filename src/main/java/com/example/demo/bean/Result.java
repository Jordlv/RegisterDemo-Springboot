package com.example.demo.bean;

/**
 * 向前端返回查询结果封装类
 * @param<T>可变类型
 */
public class Result<T> {
    private String msg;

    private boolean success;

    private T detail;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
