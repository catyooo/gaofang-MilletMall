package com.shop.dao;

import com.shop.po.OsOrder;
import com.shop.vo.OrderVO;

import java.util.List;

public interface OsOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(OsOrder record);

    int insertSelective(OsOrder record);

    OsOrder selectByPrimaryKey(Long orderId);

    OsOrder selectByOrderNumber(OsOrder osOrder);

    int updateByPrimaryKeySelective(OsOrder record);

    int updateByPrimaryKey(OsOrder record);

    List<OrderVO> selectByUserId(Long userId);

    OrderVO selectOrderVOByOrderNumber(Long orderNumber);
}