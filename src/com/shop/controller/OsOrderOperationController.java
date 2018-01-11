package com.shop.controller;

import com.shop.po.OsUser;
import com.shop.service.OsOrderService;
import com.shop.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author 康健
 * @Date 2017/8/12 22:42
 */
@Controller
@RequestMapping(value = "/uc/order")
public class OsOrderOperationController {

    @Autowired
    private OsOrderService orderService;

    @RequestMapping(value = "/list")
    public String orderUI(HttpSession session, HttpServletRequest request,
                          @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                          @RequestParam(value = "limit", required = false, defaultValue = "8") Integer limit) {
        OsUser user = (OsUser) session.getAttribute("user");
        List<OrderVO> orderVOs = orderService.getPageOrderByUserId(user.getUserId(), page, limit);
        com.shop.common.PageInfo info = new  com.shop.common.PageInfo(page.intValue(), limit.intValue(), "", "");

        info.setTotal((int) orderService.getL().getTotal());
        request.setAttribute("pageInfo", info);
        request.setAttribute("orderVOs", orderVOs);
        return "/usercenter/user_order";
    }

    @RequestMapping(value = "//{orderNumber}")
    public String orderUI(@PathVariable Long orderNumber, HttpSession session, HttpServletRequest request) {
        OrderVO orderVO = orderService.getOrderByOrderNumber(orderNumber);
        request.setAttribute("orderVO", orderVO);
        return "/usercenter/user_order_view";
    }



    /*@Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderShipmentService orderShipmentService;

    *//**
     * PUT 取消订单
     * @return
     *//*
    @ApiOperation(value = "取消订单", notes = "根据URL传过来的订单编号取消订单")
    @PutMapping(value = "/cancelOrder")
    @ResponseBody
    public Object cancelOrder(Model model, @RequestParam(value = "orderNumber", required = true) Long orderNumber) {
        Integer count = orderService.updateCancelOrder(orderNumber, SingletonLoginUtils.getUserId());
        return new OsResult(CommonReturnCode.SUCCESS, count);
    }

    *//**
     * PUT 修改送货时间
     * @return
     *//*
    @ApiOperation(value = "修改送货时间", notes = "根据URL传过来的订单编号修改送货时间")
    @PutMapping(value = "/time")
    @ResponseBody
    public Object timeOrder(Model model, @RequestParam(value = "orderNumber", required = true) Long orderNumber,
                            @RequestParam(value = "shipmentTime", required = true) Integer shipmentTime) {
        Integer count = orderService.updateShipmentTime(orderNumber, shipmentTime, SingletonLoginUtils.getUserId());
        return new OsResult(CommonReturnCode.SUCCESS, count);
    }

    *//**
     * PUT 修改收货地址
     * @return
     *//*
    @ApiOperation(value = "修改收货地址", notes = "根据URL传过来的收货地址信息修改收货地址")
    @PutMapping(value = "/shipment")
    @ResponseBody
    public Object orderShipment(Model model, OrderShipment orderShipment) {
        Integer count = orderShipmentService.update(orderShipment, SingletonLoginUtils.getUserId());
        return new OsResult(CommonReturnCode.SUCCESS, count);
    }*/
}
