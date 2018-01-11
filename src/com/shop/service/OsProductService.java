package com.shop.service;

import java.util.*;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.*;
import com.shop.po.*;
import com.shop.vo.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OsProductService {

    @Autowired
    private OsProductMapper osProductMapper;
    @Autowired
    private OsProductCategoryMapper osProductCategoryMappert;
    @Autowired
    private OsProductDetailMapper osProductDetailMapper;
    @Autowired
    private OsProductImageMapper osProductImageMapper;
    @Autowired
    private OsProductParameterMapper osProductParameterMapper;
    @Autowired
    private OsProductSpecificationMapper osProductSpecificationMapper;
    @Autowired
    private OsSpecificationAttributeMapper osSpecificationAttributeMapper;
    @Autowired
    private OsSpecificationMapper osSpecificationMapper;
    @Autowired
    private OsCategoryMapper osCategoryMapper;
    @Autowired
    private OsCategoryService osCategoryService;

    /**
     * 查询热门分类商品
     */
    public ArrayList<HotCategoryVO> getHotCategory() {
        //先查找大类的二级类  在查找父类下的商品
        ArrayList<HotCategoryVO> categorys = osProductMapper.getAllCategory();
        for (HotCategoryVO hot : categorys) {
            List<CategoryVO> child = hot.getChildrenCategorys();
            for (CategoryVO vo : child) {
                List<OsProduct> list = osProductMapper.getHotProduct(vo);
                vo.setProducts(list);
            }
        }
        return categorys;
    }

    /**
     * 查询商品详情
     */
    public OsProduct getProductDetil(Long productNumber) {
        OsProduct product = osProductMapper.selectByProductNumber(productNumber);
        return product;
    }

    /**
     * 查询商品图片
     */
    public List<OsProductImage> getProductImages(Long productId) {
        List<OsProductImage> product = (List<OsProductImage>) osProductImageMapper.selectByProductId(productId);
        return product;
    }

    /**
     * 查询商品参数
     */
    public List<OsProductParameter> getProductParameter(Long productId) {
        List<OsProductParameter> list = (List<OsProductParameter>) osProductParameterMapper.selectByProductId(productId);
        return list;
    }

    /**
     * 查询商品详细介绍
     */
    public OsProductDetail getProductDetail(Long productId) {
        OsProductDetail detail = osProductDetailMapper.selectByProductId(productId);
        return detail;
    }

    /**
     * 查询商品对应规格
     */
    public Map<String, Object> getProductSpecification(Long productId) {
        Map<String, Object> resultMap = new HashMap<>();
        // 商品规格进行拆分
        List<OsProductSpecification> osProductSpecification = osProductSpecificationMapper.selectByProductId(productId);
        for(OsProductSpecification ops : osProductSpecification) {
            if(ops.getSpec() != null && (!ops.getSpec().equals(""))){
                String[] sp = ops.getSpec().split(",");
                //reverseArray(sp);
                String s = changeArray(sp);
                resultMap.put(s, JSONObject.fromObject(ops));
            } else {
                resultMap.put("default", JSONObject.fromObject(ops));
            }
        }
        return resultMap;
    }

    /**
     * 查询分类规格组合
     */
    public List<KindVO> getProductKind(Long productId) {
        //先根据商品找出父类
        OsCategory osCategory = osCategoryMapper.selectParentCategoryByProductId(productId);
        //父类查找所有的规格组合
        List<KindVO> kindVOs = osProductSpecificationMapper.selectSpecByCategoryId(osCategory.getCategoryId());
        //查找当前商品的规格组合 去除不存在的规格
        List<OsProductSpecification> list = osProductSpecificationMapper.selectByProductId(productId);
        Set<String> sset = new HashSet<String>();
        Set<String> set = Collections.synchronizedSet(sset);
        for(OsProductSpecification ops : list) {
            if(ops.getSpec() != null && (!"".equals(ops.getSpec()))) {
                String[] sp = ops.getSpec().split(",");
                for(String s : sp) {
                    set.add(s);
                }
            }
        }
        for(KindVO k : kindVOs) {
            List<KindAttribute> l = k.getKindAttributes();
            List<KindAttribute> ll = new ArrayList<KindAttribute>();
            int[] index = null;
            for(int i= 0; i < l.size(); i++ ) {
                KindAttribute ka = l.get(i);
                Boolean flag = false;
                for(String s : set) {
                    if(Long.parseLong(s) == ka.getSpecAttrId()) {
                        flag = true;
                        break;
                    }
                }
                if(flag == false) {
                    ll.add(ka);
                }
            }
            for(int i= 0; i < ll.size(); i++) {
                l.remove(ll.get(i));
            }
        }
        return kindVOs;
    }

    /**
     * 根据规格id 查询商品基本信息
     */
    public OsProduct getProductBySpecNumber(Long productSpecNumber) {
        OsProduct osProduct = osProductMapper.getProductBySpecNumber(productSpecNumber);
        return osProduct;
    }

    private static void reverseArray(String[] Array) {
        ArrayList<String> array_list = new ArrayList<String>();
        for (int i = 0; i < Array.length; i++) {
            array_list.add(Array[Array.length - i - 1]);
        }
        Array = array_list.toArray(Array);
    }

    private static String changeArray(String[] Array) {
        String s = "";
        for(int i =0; i < Array.length; i++) {

            if(i == Array.length-1) {
                s = s + Array[i];
                break;
            }
            s = s + Array[i] + ",";
        }
        return s;
    }

    private Page<OsProduct> l ;

    public Page<OsProduct> getL() {
        return l;
    }

    public void setL(Page<OsProduct> l) {
        this.l = l;
    }

    //分页查询商品信息
    public List<OsProduct> pageProductInfo(Long categoryId, Integer sort, Integer page, Integer limit) {
        if(categoryId == 1) {
            PageHelper.startPage(page, 8);
            List<OsProduct> list = osProductMapper.selectAll();
            this. l = (Page<OsProduct>)list;
            return list;
        }
        // 根据类目ID查找子类目
        List<OsCategory> lowerCategories = osCategoryService.listLowerCategories(categoryId);
        List<String> categoryIds = new ArrayList<String>();
        //如果有子目录
        if(lowerCategories != null || lowerCategories.size() != 0) {
            for(OsCategory os : lowerCategories) {
                categoryIds.add(String.valueOf(os.getCategoryId()));
            }
        }
        if(lowerCategories.size() == 0){
            //没有子目录
            categoryIds.add(String.valueOf(categoryId));
        }
        PageHelper.startPage(page, limit);
        List<OsProduct> list = osProductMapper.listByPage(categoryIds);
        this. l = (Page<OsProduct>)list;
        return list;
    }

}
