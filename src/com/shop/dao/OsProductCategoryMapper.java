package com.shop.dao;

import com.shop.po.OsProductCategory;

public interface OsProductCategoryMapper {
    int deleteByPrimaryKey(Long productCategoryId);

    int insert(OsProductCategory record);

    int insertSelective(OsProductCategory record);

    OsProductCategory selectByPrimaryKey(Long productCategoryId);

    int updateByPrimaryKeySelective(OsProductCategory record);

    int updateByPrimaryKey(OsProductCategory record);
}