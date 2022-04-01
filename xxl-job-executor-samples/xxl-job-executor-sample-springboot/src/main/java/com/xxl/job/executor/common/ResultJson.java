package com.xxl.job.executor.common;

import com.sun.org.apache.regexp.internal.RE;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/1 13:48
 */
@SuppressWarnings("unused")
public class ResultJson<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> ResultJson<T> success(T data) {
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.setCode(ResultCodeEnum.SUCCESS.getCode());
        resultJson.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        resultJson.setData(data);
        return resultJson;
    }

    public static <T> ResultJson<T> success() {
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.setCode(ResultCodeEnum.SUCCESS.getCode());
        resultJson.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        resultJson.setData(null);
        return resultJson;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
}
