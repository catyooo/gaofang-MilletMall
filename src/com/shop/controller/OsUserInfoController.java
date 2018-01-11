package com.shop.controller;

import com.shop.common.OsResult;
import com.shop.po.OsAddress;
import com.shop.po.OsCategory;
import com.shop.po.OsProduct;
import com.shop.po.OsUser;
import com.shop.service.OsAddressService;
import com.shop.vo.AddressVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author 康健
 * @Date 2017/8/12 14:33
 */
@Controller
@RequestMapping(value = "/uc/user")
public class OsUserInfoController {
    @Autowired
    private OsAddressService osAddressService;

    /**
     * GET 我的个人中心
     *
     * @return
     */
    @RequestMapping(value = "/portal")
    public String portal() {
        return "/usercenter/user_portal";
    }

    /**
     * GET 收货地址
     *
     * @return
     */
    @RequestMapping(value = "/address")
    public String address(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "3") Integer limit,
            HttpServletRequest request, HttpSession session) {
        OsUser user = (OsUser) session.getAttribute("user");
        List<OsAddress> addresses = osAddressService.pageAddressInfo(page, limit, user.getUserId());

        com.shop.common.PageInfo info = new com.shop.common.PageInfo(page.intValue(), limit.intValue(), "", "");
        info.setTotal((int) osAddressService.getL().getTotal());
        request.setAttribute("addresses", addresses);
        request.setAttribute("pageInfo", info);

        return "/usercenter/user_address";
    }


    /**
     * POST 创建收货地址
     * @return
     */
    @RequestMapping(value = "/address/insert" , method = RequestMethod.POST)
    @ResponseBody
    public Object addressCreate(OsAddress address, HttpSession session) {
        OsUser osUser = (OsUser) session.getAttribute("user");
        address.setUserId(osUser.getUserId());
        Integer count = osAddressService.insertAddress(address);
        if(count == 1) {
            return new OsResult(1, "新增收货地址成功");
        } else {
            return new OsResult(0, "新增收货地址失败");
        }

    }

    /**
     * PUT 更新收货地址
     * @return
     */
    @RequestMapping(value = "/address/update", method = RequestMethod.POST)
    @ResponseBody
    public Object addressUpdate(AddressVO addressvo, HttpSession session) {
        OsUser osUser = (OsUser) session.getAttribute("user");
        OsAddress osAddress = new OsAddress();
        BeanUtils.copyProperties(addressvo, osAddress);
        osAddress.setUserId(osUser.getUserId());
        int count = osAddressService.updatetAddress(osAddress);
        if(count == 1) {
            return new OsResult(1, "更新收货地址成功");
        } else {
            return new OsResult(0, "更新收货地址失败");
        }
    }

    /**
     * DELETE 删除收货地址
     * @return
     */
    @RequestMapping(value = "/address/{addressId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object addressDelete(@PathVariable("addressId") Long addressId, HttpSession session) {
        Integer count = osAddressService.deleteByAddressId(addressId);
        if(count == 1) {
            return new OsResult(1, "删除收货地址成功");
        } else {
            return new OsResult(0, "删除收货地址失败");
        }
    }

}
