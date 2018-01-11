package com.shop.controller;

import com.shop.po.OsCategory;
import com.shop.po.OsProduct;
import com.shop.service.OsCategoryService;
import com.shop.service.OsProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author 康健
 * @Date 2017/8/12 15:04
 */
@Controller
public class OsCategoryListController {

    @Autowired
    private OsCategoryService osCategoryService;
    @Autowired
    private OsProductService osProductService;

    /**
     * GET 类目列表
     * @return
     * */
    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "categoryId", required = false, defaultValue = "1") String reqCategoryId,
            @RequestParam(value = "sort", required = false, defaultValue = "0") String reqSort,
            @RequestParam(value = "page", required = false, defaultValue = "1") String reqPage,
            @RequestParam(value = "limit", required = false, defaultValue = "4") Integer limit,
            HttpServletRequest request) {

        // 请求参数:类目ID,如果类目ID不存在或者不为Long类型,则默认1/全部商品
        Long categoryId = StringUtils.isNumeric(reqCategoryId) ? Long.valueOf(reqCategoryId) : 1;
        // 请求参数:排序方式,如果排序方式不存在或者不为Integer类型,则默认0/推荐排序
        Integer sort = StringUtils.isNumeric(reqSort) ? Integer.valueOf(reqSort) : 0;
        // 请求参数:分页,如果分页不存在或者不为Integer类型,则默认1/默认页数
        Integer page = StringUtils.isNumeric(reqPage) ? Integer.valueOf(reqPage) : 1;

        // 查找当前类目信息
        OsCategory category = osCategoryService.getByCategoryId(categoryId);
        if (category != null) {

            // 通过类目ID、排序、分页查找商品列表
            List<OsProduct> products = osProductService.pageProductInfo(categoryId,sort,page,limit);

            // 根据类目ID查找子类目
            List<OsCategory> lowerCategories = osCategoryService.listLowerCategories(categoryId);

            // 根据类目ID查找上级类目列表
            List<OsCategory> upperCategories = osCategoryService.listUpperCategories(categoryId);
            com.shop.common.PageInfo info = new  com.shop.common.PageInfo(page.intValue(), limit.intValue(), "", "");

            info.setTotal((int) osProductService.getL().getTotal());


            request.setAttribute("sort", reqSort);
            request.setAttribute("category", category);
            request.setAttribute("products", products);
            request.setAttribute("pageInfo", info);
            request.setAttribute("lowerCategories", lowerCategories);
            request.setAttribute("upperCategories", upperCategories);
        }
        return "/product/product_list";
    }

    /**
     * GET 搜索列表
     * @return
     *//*
    @ApiOperation(value = "搜索列表", notes = "搜索列表")
    @GetMapping(value = "/search")
    public String search(Model model,
                         @RequestParam(value = "search", required = false, defaultValue = "") String search,
                         @RequestParam(value = "sort", required = false, defaultValue = "0") String reqSort,
                         @RequestParam(value = "page", required = false, defaultValue = "1") String reqPage,
                         @RequestParam(value = "limit", required = false, defaultValue = "12") Integer limit) {
        // 请求参数:排序方式,如果排序方式不存在或者不为Integer类型,则默认0/推荐排序
        Integer sort = StringUtils.isNumeric(reqSort) ? Integer.valueOf(reqSort) : ProductSortEnum.RECOMMEND.getType();
        // 请求参数:分页,如果分页不存在或者不为Integer类型,则默认1/默认页数
        Integer page = StringUtils.isNumeric(reqPage) ? Integer.valueOf(reqPage) : 1;

        // 通过搜索内容、排序、分页查找商品列表
        PageInfo pageInfo = new PageInfo(page, limit, ProductSortEnum.typeOf(sort).getSort(),
                ProductSortEnum.typeOf(sort).getOrder());
        BasePageDTO<ProductVO> basePageDTO = productCategoryService.listBySearch(search, pageInfo);

        // 根据类目ID查找子类目
        List<Category> lowerCategories = categoryService.listLowerCategories(1L, StatusEnum.SHOW.getStatus());

        model.addAttribute("search", search); // 搜索内容
        model.addAttribute("sort", ProductSortEnum.typeOf(sort).getType());// 排序方式
        model.addAttribute("products", basePageDTO.getList());// 商品列表
        model.addAttribute("pageInfo", basePageDTO.getPageInfo()); // 分页信息
        model.addAttribute("lowerCategories", lowerCategories);// 子类目列表

        return "/modules/product/product_search";
    }*/
}
