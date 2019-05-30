package org.wjh.common;

/**
 * 业务代码
 */
public enum Code {
    FAIL(1, "失败"),
    OK(200, "成功"),
    NOT_LOGIN(401, "未登录"),
    NOT_AUTH(403, "权限不足"),
    NOT_FOUND(404, "对象不存在");

    private Integer code;
    private String msg;

    Code(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
