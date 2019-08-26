package org.wjh.exception;

import org.wjh.common.Code;

/**
 * 公共异常
 */
public class CommonException extends RuntimeException {

    private String msg;
    private Integer code;

    public CommonException() {
        this(Code.FAIL.getMsg(), Code.FAIL.getCode(), Code.FAIL.getMsg(), null);
    }

    public CommonException(Exception e) {
        this(Code.FAIL.getMsg(), Code.FAIL.getCode(), Code.FAIL.getMsg(), e);
    }

    public CommonException(String msg, Integer code) {
        this(msg, code, msg, null);
    }

    public CommonException(String msg, Integer code, String message) {
        this(msg, code, message, null);
    }

    public CommonException(String msg, Integer code, String message, Exception e) {
        super(message, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}