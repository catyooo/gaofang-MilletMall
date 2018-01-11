package com.shop.dao;

import com.shop.po.CmsRole;

public interface CmsRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(CmsRole record);

    int insertSelective(CmsRole record);

    CmsRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(CmsRole record);

    int updateByPrimaryKey(CmsRole record);
}