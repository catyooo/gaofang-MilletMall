package com.shop.dao;

import com.shop.po.OsOrderProduct;

import java.util.List;

public interface OsOrderProductMapper {
    int deleteByPrimaryKey(Long orderProductId);

    int insert(OsOrderProduct record);

    int insertSelective(OsOrderProduct record);

    OsOrderProduct selectByPrimaryKey(Long orderProductId);

    List<OsOrderProduct> selectByOrderId(Long orderId);

    int updateByPrimaryKeySelective(OsOrderProduct record);

    int updateByPrimaryKey(OsOrderProduct record);
    
    
}