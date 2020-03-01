package com.my.design.patterns.lab.wallet.repository;

import org.springframework.stereotype.Repository;

import com.my.design.patterns.lab.wallet.entity.VirtualWalletEntity;

import java.math.BigDecimal;

/**
 * <p>
 * 模拟代码
 * </p>
 *
 * @author zhangkun
 */
@Repository
public class VirtualWalletRepository {
    public VirtualWalletEntity getWalletEntity(Long walletId) {
        return null;
    }

    public BigDecimal getBalance(Long walletId) {
        return BigDecimal.ZERO;
    }

    public void updateBalance(Long walletId, BigDecimal amount) {

    }
}
