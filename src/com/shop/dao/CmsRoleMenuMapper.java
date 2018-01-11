package com.shop.dao;

import com.shop.po.CmsRoleMenu;

public interface CmsRoleMenuMapper {
    int deleteByPrimaryKey(Long roleMenuId);

    int insert(CmsRoleMenu record);

    int insertSelective(CmsRoleMenu record);

    CmsRoleMenu selectByPrimaryKey(Long roleMenuId);

    int updateByPrimaryKeySelective(CmsRoleMenu record);

    int updateByPrimaryKey(CmsRoleMenu record);
}