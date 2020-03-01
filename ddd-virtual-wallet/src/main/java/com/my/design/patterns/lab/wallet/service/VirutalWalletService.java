package com.my.design.patterns.lab.wallet.service;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 1）service层负责和repository层交互，保持domain层独立性
 * 2）service层负责领域模型的业务聚合功能
 * 3）service类负责一些非功能性及与三方系统交互的工作。比如
 *    幂等、事务、发邮件、发消息、记录日志、调用其它系统的
 *    RPC接口等，都可以放到service类中
 * </p>
 *
 * @author zhangkun
 */
@Service
public class VirutalWalletService {
}
