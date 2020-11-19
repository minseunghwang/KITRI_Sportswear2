package com.java.admin.memberManage.service;

import java.util.HashMap;
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
import com.java.notice.dto.NoticeDto;
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

	@Override
	public void memberManagePopup(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = request.getParameter("id");
		//int page = Integer.parseInt(request.getParameter("page"));

		MemberDto member = adminMemberManageDao.memberSelect(id);
		  
		mav.addObject("member",member); 
		mav.addObject("id",id);
		//mav.addObject("page",page);
		mav.setViewName("/admin/member/memberManagePopup");
	}

	@Override
	public void memberManagementPopupEdit(ModelAndView mav, HttpServletRequest request) {
		Map<String, Object> map = mav.getModelMap();

//		MemberDto memberDto = (MemberDto) map.get("memberDto");
		
        MemberDto memberDto = new MemberDto();
        memberDto.setId(request.getParameter("id"));
        memberDto.setPwd(request.getParameter("pwd"));
        memberDto.setName(request.getParameter("name"));
        memberDto.setEmail(request.getParameter("email"));
        memberDto.setAddr(request.getParameter("addr"));
		
		adminMemberManageDao.memberManagementPopupEdit(memberDto);		
		
		mav.addObject("id", memberDto.getId());
//		mav.setViewName("/admin/member/memberManage");
	}

	@Override
	public void memberManagePopupDelete(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = request.getParameter("id");

		Map<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("id", request.getParameter("id"));

		adminMemberManageDao.memberManagementPopupDelete(hmap);

		mav.addObject("id", id);
		mav.setViewName("/admin/member/memberManage");
	}

}
