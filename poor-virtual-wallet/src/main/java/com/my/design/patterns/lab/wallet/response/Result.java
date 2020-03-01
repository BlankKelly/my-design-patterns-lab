package com.my.design.patterns.lab.wallet.response;

/**
 * @author zhangkun
 */
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success() {
        return new Result<>("10000", "ok", null);
    }

    public static Result successWithMessage(String message) {
        return new Result<>("10000", message, null);
    }
}
