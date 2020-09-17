package com.ey.hc.common.exception;


import com.ey.hc.common.api.ResultJson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * Created by macro on 2020/2/27.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ResultJson handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return ResultJson.failed(e.getErrorCode());
        }
        return ResultJson.failed(e.getMessage());
    }
}
