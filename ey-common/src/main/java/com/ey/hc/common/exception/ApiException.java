package com.ey.hc.common.exception;

import com.ey.hc.common.api.IErrorCode;
import com.ey.hc.common.enums.ResultCode;

/**
 *  自定义API异常
 */
public class ApiException  extends RuntimeException{

    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
