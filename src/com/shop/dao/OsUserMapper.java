package com.shop.dao;

import com.shop.po.OsUser;

public interface OsUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(OsUser record);

    int insertSelective(OsUser record);

    OsUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(OsUser record);

    int updateByPrimaryKey(OsUser record);

    OsUser selectByTelephone(String telephone);
}