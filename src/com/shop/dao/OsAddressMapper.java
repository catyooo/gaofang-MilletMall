package com.shop.dao;

import com.shop.po.OsAddress;

import java.util.List;

public interface OsAddressMapper {
    int deleteByPrimaryKey(Long addressId);

    int insert(OsAddress record);

    int insertSelective(OsAddress record);

    OsAddress selectByPrimaryKey(Long addressId);

    List<OsAddress> selectByUserId(Long userId);

    OsAddress selectByAddressId(Long addressId);

    int updateByPrimaryKeySelective(OsAddress record);

    int updateByPrimaryKey(OsAddress record);
}