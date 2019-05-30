package org.wjh.common;

/**
 * 返回结果
 *
 * @param <T>
 */
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
        this(Code.OK.getCode(), Code.OK.getMsg(), null);
    }

    public Result(Integer code) {
        this(code, null, null);
    }

    public Result(Integer code, String msg) {
        this(code, msg, null);
    }

    public Result(T data) {
        this(Code.OK.getCode(), Code.OK.getMsg(), data);
    }

    public Result(Code codeEnum) {
        this(codeEnum, null);
    }

    public Result(Code codeEnum, T data) {
        this(codeEnum.getCode(), codeEnum.getMsg(), data);
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
