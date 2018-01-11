package com.shop.dao;

import com.shop.po.OsProductDetail;

public interface OsProductDetailMapper {
    int deleteByPrimaryKey(Long productDetailId);

    int insert(OsProductDetail record);

    int insertSelective(OsProductDetail record);

    OsProductDetail selectByPrimaryKey(Long productDetailId);

    int updateByPrimaryKeySelective(OsProductDetail record);

    int updateByPrimaryKeyWithBLOBs(OsProductDetail record);

    int updateByPrimaryKey(OsProductDetail record);

    OsProductDetail selectByProductId(Long productId);
}