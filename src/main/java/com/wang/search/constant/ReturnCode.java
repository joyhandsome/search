package com.wang.search.constant;

import lombok.Data;

/**
 * 返回码
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/7/29 13:34
 * @since JDK 1.8
 */
public enum ReturnCode {

    /**
     * 成功
     */
    SUCESS(200, "成功"),;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
