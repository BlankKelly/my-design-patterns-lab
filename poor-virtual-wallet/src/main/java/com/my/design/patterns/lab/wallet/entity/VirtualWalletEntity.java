package com.my.design.patterns.lab.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author zhangkun
 */
@Data
@ToString
public class VirtualWalletEntity {
    private Long id;
    private Long createTime;
    private BigDecimal balance;
}
