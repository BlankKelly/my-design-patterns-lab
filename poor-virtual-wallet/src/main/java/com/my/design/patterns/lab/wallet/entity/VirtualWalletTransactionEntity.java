package com.my.design.patterns.lab.wallet.entity;

import lombok.Data;
import lombok.ToString;

import com.my.design.patterns.lab.wallet.enums.Status;
import java.math.BigDecimal;

/**
 * @author zhangkun
 */
@Data
@ToString
public class VirtualWalletTransactionEntity {
    private Long id;
    private BigDecimal amount;
    private Long createTime;
    private Long fromWalletId;
    private Long toWalletId;
    private Status status;
}
