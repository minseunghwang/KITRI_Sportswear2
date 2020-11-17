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

		int page = Integer.parseInt(request.getParameter("page"));	
		int startRange = (page - 1) * 8 + 1;
		int endRange = page * 8;
		
		List<MemberDto> members = null;
		members = adminMemberManageDao.memberList(startRange,endRange);
		
		PaginationVO pn = new PaginationVO();
		
		// 페이징 처리
		pn.setPage(page);					// 현재 페이지
		pn.setCountList(8);					// 한 화면에 보여질 상품 수
		pn.setCountPage(3);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>
		
		pn.setTotalCount(members.size());	// 전체 상품 수 ex) 35개
		
		pn.setTotalPage(pn.getTotalCount() / pn.getCountList());
		if(pn.getTotalCount() % pn.getCountList() > 0) {	// ex) 총 상품 35개, 한 페이지에 8개 표시 :: 4개의 페이지(8개 상품) + 1페이지(3개 상품)
			pn.setTotalPage(pn.getTotalPage() + 1);
		}
		
		if(pn.getTotalPage() < pn.getPage()) {
			pn.setPage(pn.getTotalPage());
		}
		
		pn.setStartPage((pn.getPage() - 1) / pn.getCountPage() * pn.getCountPage() + 1);
		pn.setEndPage(pn.getStartPage() + pn.getCountPage() - 1);

		if(pn.getEndPage() > pn.getTotalPage()) {
			pn.setEndPage(pn.getTotalPage());
		}
		
		mav.addObject("page", page);
		mav.addObject("members", members);
		mav.addObject("pn", pn);
		mav.setViewName("/admin/member/memberManage");
		
	}

}
