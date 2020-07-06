package io.dreamstudio.jarslink.main.web.advice;

import io.dreamstudio.jarslink.commons.entity.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class ResponseExceptionControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseExceptionControllerAdvice.class);

    @ExceptionHandler
    @ResponseBody
    public ResponseDTO illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        Long userId = getContextUserId();
        LOGGER.error("全局处理器-非法请求参数, userId:{}, 原因:{}", userId, ex.getMessage());
        return ResponseDTO.invalidParam(ex.getMessage());
    }

    //=========框架层面
    @ExceptionHandler
    @ResponseBody
    public ResponseDTO methodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        Long userId = getContextUserId();
        LOGGER.error("全局处理器-请求方法不支持, userId:{}, 原因:{}", userId, ex.getMessage());
        return ResponseDTO.invalidParam("请求Method不支持");
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseDTO missingParameterExceptionHandler(MissingServletRequestParameterException ex) {
        Long userId = getContextUserId();
        LOGGER.error("全局处理器-参数缺失, userId:{}, 原因:{}", userId, ex.getMessage());
        return ResponseDTO.invalidParam("参数缺失");
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseDTO exceptionHandler(Exception ex) {
        Long userId = getContextUserId();
        LOGGER.error(String.format("全局处理器-未知异常, userId:%s", userId), ex);
        return ResponseDTO.systemError();
    }

    private Long getContextUserId() {
        return null;
    }
}
