package com.my.design.patterns.lab.wallet.controller;

import com.my.design.patterns.lab.wallet.service.VirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangkun
 */
@RestController
@RequestMapping
public class VirtualWalletController {
    @Autowired
    private VirtualWalletService virtualWalletService;


}
