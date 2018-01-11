package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.service.OsCategoryService;
import com.shop.vo.CategoryVO;

/**
 * 前台主页控制器
 * @author kj
 *
 */
@Controller
public class OsIndexController {
	
	@Autowired
    OsCategoryService osCategoryService;
	
	//首页访问
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpSession session) {
		//首页导航栏商品信息
		List<CategoryVO> category = osCategoryService.getindexCategory();
		session.setAttribute("categorys", category);
		return "/webfront/index";
	}
}
