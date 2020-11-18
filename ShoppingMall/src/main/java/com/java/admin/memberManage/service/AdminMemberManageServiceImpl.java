package com.java.admin.memberManage.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.admin.memberManage.dao.AdminMemberManageDao;
import com.java.common.PaginationVO;
import com.java.common.ProductSizeVO;
import com.java.member.dto.MemberDto;
import com.java.product.dto.ProductDto;

@Configuration
@Component
public class AdminMemberManageServiceImpl implements AdminMemberManageService{
	@Autowired
	private AdminMemberManageDao adminMemberManageDao;
	
	@Override
	public void memberList(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		List<MemberDto> members = null;
		members = adminMemberManageDao.memberList();
				
		mav.addObject("members", members);
		mav.setViewName("/admin/member/memberManage");
		
	}
	

//	@Override
//	public void memberManagePopup(ModelAndView mav) {
//		Map<String, Object> map = mav.getModelMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//
//		int num = Integer.parseInt(request.getParameter("num"));
//		int page = Integer.parseInt(request.getParameter("page"));
//
//		ProductDto product = adminProductDao.productSelect(num);
//		  
//		mav.addObject("product",product); 
//		mav.addObject("num",num);
//		mav.addObject("page",page);
//		mav.setViewName("admin/member/memberManagePopup");
//	}

}
