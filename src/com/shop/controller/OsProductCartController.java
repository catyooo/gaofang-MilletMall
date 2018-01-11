package com.shop.controller;

import com.shop.common.OsResult;
import com.shop.po.OsProduct;
import com.shop.service.OsProductCartService;
import com.shop.service.OsProductService;
import com.shop.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author 康健
 * @Date 2017/8/11 15:35
 */
@Controller
@RequestMapping("/cart")
public class OsProductCartController {

    @Autowired
    private OsProductCartService osProductCartService;
    @Autowired
    private OsProductService osProductService;

    /**
     * GET 成功加入购物车
     * @return
     */
    @RequestMapping(value = "/{productSpecNumber}")
    public String view(@PathVariable Long productSpecNumber, HttpSession session, HttpServletRequest request) {
        // 用户已登录,查看购物车列表是否有该商品
        Boolean flag = osProductCartService.getProductExsit(productSpecNumber, session);
        OsProduct osProduct = osProductService.getProductBySpecNumber(productSpecNumber);
        request.setAttribute("product", osProduct);
        if (flag == false) {
            // 重定向到购物车列表
            System.out.println("flag is false");
            return "/product/product_cart_info";
        }
        return "/product/product_cart_info";
    }

    /**
     * POST 添加购物车商品
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestParam(value = "productSpecNumber", required = true) Long productSpecNumber,
                         HttpSession session) {
        if(session.getAttribute("user") != null) {
            CartVO cartVO = osProductCartService.insertProductCart(productSpecNumber, session);
            session.setAttribute("cart", cartVO);
            System.out.println(cartVO.toString());
            return new OsResult(1, productSpecNumber.toString());
        } else {
            return new OsResult(401,"还未登录");
        }
    }

    /**
     * DELETE 删除购物车商品
     *
     * @return
     */
    @RequestMapping(value = "/{productSpecNumber}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteProductNumber(@PathVariable Long productSpecNumber,
                         HttpSession session) {
        if(session.getAttribute("user") != null) {
            CartVO cartVO = osProductCartService.deleteProductCart(productSpecNumber, session);
            session.setAttribute("cart", cartVO);
            System.out.println(cartVO.toString());
            return new OsResult(1, productSpecNumber.toString());
        } else {
            return new OsResult(401,"还未登录");
        }
    }



    /**
     * GET 购物车列表
     * @return
     */
    @RequestMapping(value = "/list")
    public String list() {
        return "/product/product_cart_list";
    }

    /**
     *  修改购物车商品数量 新增
     *
     * @return
     */
    @RequestMapping(value = "/add/{productSpecNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Object addProductNumber(@PathVariable(value = "productSpecNumber") Long productSpecNumber,Integer buyNumber,
                         HttpSession session) {
        if(session.getAttribute("user") != null) {
            CartVO cartVO = osProductCartService.insertProductCart(productSpecNumber, session, buyNumber);
            session.setAttribute("cart", cartVO);
            System.out.println(cartVO.toString());
            return new OsResult(1, productSpecNumber.toString());
        } else {
            return new OsResult(401,"还未登录");
        }
    }
    /**
     *  修改购物车商品数量 去除
     *
     * @return
     */
    @RequestMapping(value = "/delete/{productSpecNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Object deProductNumber(@PathVariable(value = "productSpecNumber") Long productSpecNumber,
                                      Integer buyNumber, HttpSession session) {
        if(session.getAttribute("user") != null) {
            CartVO cartVO = osProductCartService.deProductCart(productSpecNumber, session, buyNumber);
            session.setAttribute("cart", cartVO);
            System.out.println(cartVO.toString());
            return new OsResult(1, productSpecNumber.toString());
        } else {
            return new OsResult(401,"还未登录");
        }
    }
}
