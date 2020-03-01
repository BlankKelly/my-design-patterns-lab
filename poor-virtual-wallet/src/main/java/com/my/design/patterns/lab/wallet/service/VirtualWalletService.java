package com.my.design.patterns.lab.wallet.service;

import com.my.design.patterns.lab.wallet.bo.VirtualWalletBo;
import com.my.design.patterns.lab.wallet.convert.VirtualWalletMapper;
import com.my.design.patterns.lab.wallet.entity.VirtualWalletEntity;
import com.my.design.patterns.lab.wallet.entity.VirtualWalletTransactionEntity;
import com.my.design.patterns.lab.wallet.enums.Status;
import com.my.design.patterns.lab.wallet.exception.SufficientBalanceException;
import com.my.design.patterns.lab.wallet.repository.VirtualWalletRepository;
import com.my.design.patterns.lab.wallet.repository.VirtualWalletTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author zhangkun
 */
@Service
@Slf4j
public class VirtualWalletService {
    @Resource(name = "virtualWalletRepository")
    private VirtualWalletRepository walletRepo;

    @Resource(name = "virtualWalletTransactionRepository")
    private VirtualWalletTransactionRepository transactionRepo;

    public VirtualWalletBo getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletBo walletBo = VirtualWalletMapper.INSTANCE.convert(walletEntity);
        return walletBo;
    }

    public BigDecimal getBalance(Long walletId) {
        return walletRepo.getBalance(walletId);
    }

    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity  = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        if (balance.compareTo(amount) < 0) {
            throw new SufficientBalanceException();
        }
        walletRepo.updateBalance(walletId, balance.subtract(amount));
    }

    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        walletRepo.updateBalance(walletId, balance.add(amount));
    }

    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();

        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setStatus(Status.TO_BE_EXECUTED);
        Long transactionId = transactionRepo.saveTransaction(transactionEntity);

        try {
            debit(fromWalletId, amount);
            credit(toWalletId, amount);
        } catch (SufficientBalanceException e) {
            log.info("transactionId = {} closed, exception stack trace: {}", transactionId, ExceptionUtils.getStackTrace(e));
            transactionRepo.updateStatus(transactionId, Status.CLOSED);
        } catch (Exception e) {
            log.info("transactionId = {} failed, exception stack trace: {}", transactionId, ExceptionUtils.getStackTrace(e));
            transactionRepo.updateStatus(transactionId, Status.FAILED);
        }

        transactionRepo.updateStatus(transactionId, Status.EXECUTED);
    }
}
