package com.my.design.patterns.lab.wallet.convert;

import com.my.design.patterns.lab.wallet.bo.VirtualWalletBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.my.design.patterns.lab.wallet.entity.VirtualWalletEntity;

/**
 * @author zhangkun
 */
@Mapper
public interface VirtualWalletMapper {
    VirtualWalletMapper INSTANCE = Mappers.getMapper(VirtualWalletMapper.class);

    VirtualWalletBo convert(VirtualWalletEntity virtualWalletEntity);
}
