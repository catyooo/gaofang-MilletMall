package com.shop.controller;

import com.shop.common.OsResult;
import com.shop.po.OsUser;
import com.shop.service.OsCategoryService;
import com.shop.service.OsUserService;
import com.shop.util.CreateImageCode;
import com.shop.util.GetRandom;
import com.shop.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 前台用户控制器
 *
 * @author kj
 */
@Controller
@RequestMapping("/pass")
public class OsUserLoginController {

    @Autowired
    OsCategoryService osCategoryService;
    @Autowired
    OsUserService osUserService;

    //登录访问
    @RequestMapping("/login")
    public String loginUI(HttpServletRequest request) {
        return "/user/user_login";
    }

    //注册
    @RequestMapping("/register")
    public String registerUI(HttpServletRequest request) {
        return "/user/user_register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@ModelAttribute("user") OsUser user, @RequestParam("registerCode") String registerCode, HttpSession session) {
        String code = (String) session.getAttribute("code");
        Long num = GetRandom.getNumber();
        user.setUserNumber(num);
        if (code.equals(registerCode)) {
            try {
                osUserService.insertUser(user);
                return new OsResult(1, user.getUserName());
            } catch (Exception e) {
                return new OsResult(0, "注册失败");
            }
        } else {
            return new OsResult(0, "验证码错误");
        }
    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam("loginName") String loginName,
                        @RequestParam("loginPassword") String loginPassword, HttpSession session) {
        OsUser user = osUserService.selectUser(loginName, loginPassword);
        if (loginPassword.equals(user.getLoginPassword())) {
            session.setAttribute("user", user);
            CartVO cartVO = new CartVO();
            session.setAttribute("cart", cartVO);
            return new OsResult(1, "");
        } else {
            return new OsResult(0, "登录失败，用户名或密码错误");
        }
    }

    //登出
    @RequestMapping("/logout")
    public String loginUI(HttpServletRequest request, HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

    @RequestMapping(value = "/captcha-image.jpg")
    @ResponseBody
    public void getImageCode(HttpServletRequest req, HttpServletResponse response, HttpSession session) throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        CreateImageCode vCode = new CreateImageCode(100, 30, 4, 8);
        System.out.println("code" + vCode.getCode());
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
    }

}
