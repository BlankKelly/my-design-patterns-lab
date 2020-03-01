package com.my.design.patterns.lab.wallet.enums;

/**
 * @author zhangkun
 */
public enum Status {
    /**
     * 转账状态值
     */
    TO_BE_EXECUTED(1, "转账中"),
    CLOSED(2, "关闭"),
    FAILED(3, "失败"),
    EXECUTED(4, "转账完成");

    private int value;
    private String description;

    private Status(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
