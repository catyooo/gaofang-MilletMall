package com.shop.dao;

import java.util.List;

import com.shop.po.OsProductSpecification;
import com.shop.vo.KindVO;

public interface OsProductSpecificationMapper {
    int deleteByPrimaryKey(Long productSpecId);

    int insert(OsProductSpecification record);

    int insertSelective(OsProductSpecification record);

    OsProductSpecification selectByPrimaryKey(Long productSpecId);

    OsProductSpecification selectByProductSpecNumber(Long productSpecNumber);

    int updateByPrimaryKeySelective(OsProductSpecification record);

    int updateByPrimaryKey(OsProductSpecification record);
    
    List<OsProductSpecification> selectByProductNumber(Long productNumber);

    List<OsProductSpecification> selectByProductId(Long productId);

    List<KindVO> selectSpecByCategoryId(Long categoryId);
}