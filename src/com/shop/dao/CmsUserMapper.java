package com.shop.dao;

import com.shop.po.CmsUser;

public interface CmsUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(CmsUser record);

    int insertSelective(CmsUser record);

    CmsUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(CmsUser record);

    int updateByPrimaryKey(CmsUser record);
}