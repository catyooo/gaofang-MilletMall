package com.shop.dao;

import java.util.List;

import com.shop.po.OsProductImage;

public interface OsProductImageMapper {
    int deleteByPrimaryKey(Long picImgId);

    int insert(OsProductImage record);

    int insertSelective(OsProductImage record);

    OsProductImage selectByPrimaryKey(Long picImgId);

    int updateByPrimaryKeySelective(OsProductImage record);

    int updateByPrimaryKey(OsProductImage record);
    
    List<OsProductImage> selectByProductId(Long productId);
}