package com.chiy.dualpolarization.common.exception;

import com.chiy.dualpolarization.common.contants.ResultCodeEnum;
import lombok.Data;

/**
 *自定义异常
 */
@Data
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "DPRException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}
