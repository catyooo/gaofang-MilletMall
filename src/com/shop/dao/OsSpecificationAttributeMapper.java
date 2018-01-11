package com.shop.dao;

import com.shop.po.OsSpecificationAttribute;

public interface OsSpecificationAttributeMapper {
    int deleteByPrimaryKey(Long specAttrId);

    int insert(OsSpecificationAttribute record);

    int insertSelective(OsSpecificationAttribute record);

    OsSpecificationAttribute selectByPrimaryKey(Long specAttrId);

    int updateByPrimaryKeySelective(OsSpecificationAttribute record);

    int updateByPrimaryKey(OsSpecificationAttribute record);

}