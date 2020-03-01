package com.my.design.patterns.lab.wallet.repository;

import com.my.design.patterns.lab.wallet.entity.VirtualWalletTransactionEntity;
import com.my.design.patterns.lab.wallet.enums.Status;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 模拟代码
 * </p>
 *
 * @author zhangkun
 */
@Repository
public class VirtualWalletTransactionRepository {
    public Long saveTransaction(VirtualWalletTransactionEntity entity) {
        return 0L;
    }

    public void updateStatus(Long transactionId, Status status) {

    }
}
