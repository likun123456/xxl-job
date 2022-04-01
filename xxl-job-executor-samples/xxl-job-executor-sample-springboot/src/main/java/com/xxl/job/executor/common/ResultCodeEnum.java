package com.xxl.job.executor.common;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/1 13:49
 */
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),

    ERROR(500, "失败");
    private Integer code;

    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
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
}
