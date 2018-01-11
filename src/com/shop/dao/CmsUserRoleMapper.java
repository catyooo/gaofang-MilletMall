package com.shop.dao;

import com.shop.po.CmsUserRole;

public interface CmsUserRoleMapper {
    int deleteByPrimaryKey(Long userRoleId);

    int insert(CmsUserRole record);

    int insertSelective(CmsUserRole record);

    CmsUserRole selectByPrimaryKey(Long userRoleId);

    int updateByPrimaryKeySelective(CmsUserRole record);

    int updateByPrimaryKey(CmsUserRole record);
}