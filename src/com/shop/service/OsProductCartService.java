package com.shop.service;

import com.shop.dao.OsProductMapper;
import com.shop.dao.OsProductSpecificationMapper;
import com.shop.dao.OsSpecificationAttributeMapper;
import com.shop.po.OsProduct;
import com.shop.po.OsProductSpecification;
import com.shop.po.OsSpecificationAttribute;
import com.shop.vo.CartVO;
import com.shop.vo.ShoppingCartVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 康健
 * @Date 2017/8/11 16:15
 */
@Service
public class OsProductCartService {

    @Autowired
    private OsProductSpecificationMapper osProductSpecificationMapper;
    @Autowired
    private OsProductMapper osProductMapper;
    @Autowired
    private OsSpecificationAttributeMapper osSpecificationAttributeMapper;

    //添加购物车商品
    public CartVO insertProductCart(Long productSpecNumber, HttpSession session) {
        OsProductSpecification osProductSpecification = osProductSpecificationMapper.selectByProductSpecNumber(productSpecNumber);

        CartVO cartVO = (CartVO) session.getAttribute("cart");
        //如果当前商品有规格，规格商品已在购物车 数量加1
        if(osProductSpecification != null && (!"".equals(osProductSpecification.getSpec()))) {
            Boolean flag = false;
            List<ShoppingCartVO> shoppingCartVOs = cartVO.getShoppingCartVOs();
            for (ShoppingCartVO vo : shoppingCartVOs) {
                if (osProductSpecification.getProductSpecNumber().longValue()==(vo.getProductSpecNumber().longValue())) {
                    vo.setBuyNumber(vo.getBuyNumber() + 1);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                //如果当前商品不在购物车 新建vo并加入
                ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
                shoppingCartVO.setProductSpecNumber(osProductSpecification.getProductSpecNumber());
                shoppingCartVO.setBuyNumber(1);
                shoppingCartVO.setStock(osProductSpecification.getStock());
                shoppingCartVO.setSalesVolume(osProductSpecification.getSalesVolume());
                shoppingCartVO.setPrice(osProductSpecification.getPrice());
                shoppingCartVO.setSpec(osProductSpecification.getSpec());

                shoppingCartVO.setProductNumber(osProductMapper.selectProductNumberByProductId(osProductSpecification.getProductId()));
                shoppingCartVO.setName(osProductMapper.selectNameByProductId(osProductSpecification.getProductId()));
                shoppingCartVO.setPicImg(osProductMapper.selectPicImgByProductId(osProductSpecification.getProductId()));
                //规格名称处理
                String s = osProductSpecification.getSpec();
                List<String> list = new ArrayList<String>();
                // 商品规格进行拆分
                if (s != null && (!s.equals(""))) {
                    String[] sp = s.split(",");
                    for (String ss : sp) {
                        OsSpecificationAttribute osSpecificationAttribute = osSpecificationAttributeMapper.selectByPrimaryKey(Long.parseLong(ss));
                        list.add(osSpecificationAttribute.getName());
                    }
                }
                shoppingCartVO.setSpecificationName(list);

                cartVO.getShoppingCartVOs().add(shoppingCartVO);
            }


        } else {
            //如果商品没有规格
            Boolean flag = false;
            List<ShoppingCartVO> shoppingCartVOs = cartVO.getShoppingCartVOs();
            for(ShoppingCartVO shop : shoppingCartVOs) {
                if (productSpecNumber.longValue()==(shop.getProductNumber().longValue())) {
                    shop.setBuyNumber(shop.getBuyNumber() + 1);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                //如果当前商品不在购物车 新建vo并加入
                ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
                shoppingCartVO.setProductSpecNumber(osProductSpecification.getProductSpecNumber());
                shoppingCartVO.setBuyNumber(1);
                shoppingCartVO.setStock(osProductSpecification.getStock());
                shoppingCartVO.setSalesVolume(osProductSpecification.getSalesVolume());
                shoppingCartVO.setPrice(osProductSpecification.getPrice());

                shoppingCartVO.setProductNumber(osProductMapper.selectProductNumberByProductId(osProductSpecification.getProductId()));
                shoppingCartVO.setName(osProductMapper.selectNameByProductId(osProductSpecification.getProductId()));
                shoppingCartVO.setPicImg(osProductMapper.selectPicImgByProductId(osProductSpecification.getProductId()));
                cartVO.getShoppingCartVOs().add(shoppingCartVO);
            }

        }
        return cartVO;
    }

    //查看购物车列表是否有该商品
    public Boolean getProductExsit(Long productSpecNumber, HttpSession session) {
        OsProductSpecification osProductSpecification = osProductSpecificationMapper.selectByProductSpecNumber(productSpecNumber);
        Boolean flag = false;
        CartVO cartVO = (CartVO) session.getAttribute("cart");
        //如果当前规格商品已在购物车 数量加1
        List<ShoppingCartVO> shoppingCartVOs = cartVO.getShoppingCartVOs();
        for (ShoppingCartVO vo : shoppingCartVOs) {
            if (osProductSpecification.getProductSpecNumber().longValue()==(vo.getProductSpecNumber().longValue())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //减少购物车商品
    public CartVO deProductCart(Long productSpecNumber, HttpSession session, Integer buyNumber) {
        OsProductSpecification osProductSpecification = osProductSpecificationMapper.selectByProductSpecNumber(productSpecNumber);

        CartVO cartVO = (CartVO) session.getAttribute("cart");
        //如果当前商品有规格，规格商品已在购物车 数量-1
        if(osProductSpecification != null && (!"".equals(osProductSpecification.getSpec()))) {
            List<ShoppingCartVO> shoppingCartVOs = cartVO.getShoppingCartVOs();
            for (ShoppingCartVO vo : shoppingCartVOs) {
                if (osProductSpecification.getProductSpecNumber().longValue()==(vo.getProductSpecNumber().longValue())) {
                    vo.setBuyNumber(buyNumber);
                    break;
                }
            }
        } else {
            //如果商品没有规格
            List<ShoppingCartVO> shoppingCartVOs = cartVO.getShoppingCartVOs();
            for(ShoppingCartVO shop : shoppingCartVOs) {
                if (productSpecNumber.longValue()==(shop.getProductNumber().longValue())) {
                    shop.setBuyNumber(buyNumber);
                    break;
                }
            }
        }
        return cartVO;
    }

    //增加购物车商品
    public CartVO insertProductCart(Long productSpecNumber, HttpSession session, Integer buyNumber) {
        OsProductSpecification osProductSpecification = osProductSpecificationMapper.selectByProductSpecNumber(productSpecNumber);

        CartVO cartVO = (CartVO) session.getAttribute("cart");
        //如果当前商品有规格，规格商品已在购物车 数量加1
        if(osProductSpecification != null && (!"".equals(osProductSpecification.getSpec()))) {
            Boolean flag = false;
            List<ShoppingCartVO> shoppingCartVOs = cartVO.getShoppingCartVOs();
            for (ShoppingCartVO vo : shoppingCartVOs) {
                if (osProductSpecification.getProductSpecNumber().longValue()==(vo.getProductSpecNumber().longValue())) {
                    vo.setBuyNumber(buyNumber);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                //如果当前商品不在购物车 新建vo并加入
                ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
                shoppingCartVO.setProductSpecNumber(osProductSpecification.getProductSpecNumber());
                shoppingCartVO.setBuyNumber(1);
                shoppingCartVO.setStock(osProductSpecification.getStock());
                shoppingCartVO.setSalesVolume(osProductSpecification.getSalesVolume());
                shoppingCartVO.setPrice(osProductSpecification.getPrice());
                shoppingCartVO.setSpec(osProductSpecification.getSpec());

                shoppingCartVO.setProductNumber(osProductMapper.selectProductNumberByProductId(osProductSpecification.getProductId()));
                shoppingCartVO.setName(osProductMapper.selectNameByProductId(osProductSpecification.getProductId()));
                shoppingCartVO.setPicImg(osProductMapper.selectPicImgByProductId(osProductSpecification.getProductId()));
                //规格名称处理
                String s = osProductSpecification.getSpec();
                List<String> list = new ArrayList<String>();
                // 商品规格进行拆分
                if (s != null && (!s.equals(""))) {
                    String[] sp = s.split(",");
                    for (String ss : sp) {
                        OsSpecificationAttribute osSpecificationAttribute = osSpecificationAttributeMapper.selectByPrimaryKey(Long.parseLong(ss));
                        list.add(osSpecificationAttribute.getName());
                    }
                }
                shoppingCartVO.setSpecificationName(list);

                cartVO.getShoppingCartVOs().add(shoppingCartVO);
            }


        } else {
            //如果商品没有规格
            Boolean flag = false;
            List<ShoppingCartVO> shoppingCartVOs = cartVO.getShoppingCartVOs();
            for(ShoppingCartVO shop : shoppingCartVOs) {
                if (productSpecNumber.longValue()==(shop.getProductNumber().longValue())) {
                    shop.setBuyNumber(buyNumber);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                //如果当前商品不在购物车 新建vo并加入
                ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
                shoppingCartVO.setProductSpecNumber(osProductSpecification.getProductSpecNumber());
                shoppingCartVO.setBuyNumber(1);
                shoppingCartVO.setStock(osProductSpecification.getStock());
                shoppingCartVO.setSalesVolume(osProductSpecification.getSalesVolume());
                shoppingCartVO.setPrice(osProductSpecification.getPrice());

                shoppingCartVO.setProductNumber(osProductMapper.selectProductNumberByProductId(osProductSpecification.getProductId()));
                shoppingCartVO.setName(osProductMapper.selectNameByProductId(osProductSpecification.getProductId()));
                shoppingCartVO.setPicImg(osProductMapper.selectPicImgByProductId(osProductSpecification.getProductId()));
                cartVO.getShoppingCartVOs().add(shoppingCartVO);
            }

        }
        return cartVO;
    }
    //完全删除购物车商品
    public CartVO deleteProductCart(Long productSpecNumber, HttpSession session) {
        OsProductSpecification osProductSpecification = osProductSpecificationMapper.selectByProductSpecNumber(productSpecNumber);

        CartVO cartVO = (CartVO) session.getAttribute("cart");
        //如果当前商品有规格，规格商品已在购物车
        if(osProductSpecification != null && (!"".equals(osProductSpecification.getSpec()))) {
            List<ShoppingCartVO> shoppingCartVOs = cartVO.getShoppingCartVOs();
            for (ShoppingCartVO vo : shoppingCartVOs) {
                if (osProductSpecification.getProductSpecNumber().longValue()==(vo.getProductSpecNumber().longValue())) {
                    shoppingCartVOs.remove(vo);
                    break;
                }
            }
        } else {
            //如果商品没有规格
            List<ShoppingCartVO> shoppingCartVOs = cartVO.getShoppingCartVOs();
            for(ShoppingCartVO shop : shoppingCartVOs) {
                if (productSpecNumber.longValue()==(shop.getProductNumber().longValue())) {
                    shoppingCartVOs.remove(shop);
                    break;
                }
            }
        }
        return cartVO;
    }
}


