package com.java.admin.memberManage.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface AdminMemberManageService {

	public void memberList(ModelAndView mav);

	public void memberManagePopup(ModelAndView mav);

	public void memberManagementPopupEdit(ModelAndView mav, HttpServletRequest request);

	public void memberManagePopupDelete(ModelAndView mav);

}
