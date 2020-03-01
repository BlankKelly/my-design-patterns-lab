package com.my.design.patterns.lab.wallet.bo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author zhangkun
 */
@Data
@ToString
public class VirtualWalletBo {
    private Long id;
    private Long createTime;
    private BigDecimal balance;
}
