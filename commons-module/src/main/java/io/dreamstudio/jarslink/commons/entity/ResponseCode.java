package io.dreamstudio.jarslink.commons.entity;

/**
 * 响应码定义
 * @author Ricky Fung
 */
public enum ResponseCode {
    SUCCESS(1, "OK"),
    INVALID_PARAM(400, "请求参数不合法"),
    USER_UNAUTHORIZED(401, "用户未登录"),
    USER_FORBIDDEN(403, "用户没有权限访问此接口"),
    INTERNAL_SERVER_ERROR(500, "服务器开小差了，请稍后再试！"),
    ;
    private int code;
    private String message;
    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
