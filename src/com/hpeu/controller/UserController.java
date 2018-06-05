package com.hpeu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	
	@RequestMapping("login")
	public ModelAndView goLogin() {
		//ModelAndView mv = new ModelAndView();
		
		//设置需要返回的数据
		//mv.addObject(attributeName, attributeValue);
		//设置视图名
//		mv.setViewName(viewName);
		System.out.println("UserController.goLogin()");
		return new ModelAndView("login");
	}
}
