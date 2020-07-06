package io.dreamstudio.jarslink.commons.entity;

import java.io.Serializable;

/**
 * @author Ricky Fung
 */
public class ResponseDTO<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public static ResponseDTO ok() {
        return ok(null);
    }

    public static ResponseDTO ok(Object data) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ResponseCode.SUCCESS.getCode());
        responseDTO.setMessage("请求成功");
        responseDTO.setData(data);
        return responseDTO;
    }

    //--------参数错误
    public static ResponseDTO invalidParam(String errorMsg) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ResponseCode.INVALID_PARAM.getCode());
        responseDTO.setMessage(errorMsg);
        return responseDTO;
    }

    //-------用户未登录
    public static ResponseDTO notLogin() {
        return notLogin(ResponseCode.USER_UNAUTHORIZED.getMessage());
    }
    public static ResponseDTO notLogin(String errorMsg) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ResponseCode.USER_UNAUTHORIZED.getCode());
        responseDTO.setMessage(errorMsg);
        return responseDTO;
    }

    //-------用户无权限
    public static ResponseDTO deny() {
        return deny(ResponseCode.USER_FORBIDDEN.getMessage());
    }
    public static ResponseDTO deny(String errorMsg) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ResponseCode.USER_FORBIDDEN.getCode());
        responseDTO.setMessage(errorMsg);
        return responseDTO;
    }

    //--------业务异常
    public static ResponseDTO failure(int code, String errorMsg) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(code);
        responseDTO.setMessage(errorMsg);
        return responseDTO;
    }

    //-------系统异常
    public static ResponseDTO systemError() {
        return systemError(ResponseCode.INTERNAL_SERVER_ERROR.getMessage());
    }
    public static ResponseDTO systemError(String message) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(ResponseCode.INTERNAL_SERVER_ERROR.getCode());
        responseDTO.setMessage(message);
        return responseDTO;
    }

    public boolean isSuccess() {
        return code == ResponseCode.SUCCESS.getCode();
    }

    //----------
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
}
