package com.java.admin.memberManage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.admin.memberManage.service.AdminMemberManageService;

@Component
@Controller
public class AdminMemberManageController {
	@Autowired
	private AdminMemberManageService adminMemberManageService;
	
	@RequestMapping(value="/admin/member/memberManage.do")
	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		adminMemberManageService.memberList(mav);
		return mav;
	}
}
