package com.shop.dao;

import java.util.List;

import com.shop.po.OsProductParameter;

public interface OsProductParameterMapper {
    int deleteByPrimaryKey(Long productParameterId);

    int insert(OsProductParameter record);

    int insertSelective(OsProductParameter record);

    OsProductParameter selectByPrimaryKey(Long productParameterId);

    int updateByPrimaryKeySelective(OsProductParameter record);

    int updateByPrimaryKey(OsProductParameter record);
    
    List<OsProductParameter> selectByProductId(Long productId);
}