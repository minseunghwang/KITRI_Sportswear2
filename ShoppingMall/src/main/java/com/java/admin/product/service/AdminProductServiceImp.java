package com.java.admin.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.admin.product.dao.AdminProductDao;
import com.java.common.PaginationVO;
import com.java.common.ProductSizeVO;
import com.java.product.dto.ProductDto;
import com.java.productSize.dto.ProductSizeDto;

@Component
public class AdminProductServiceImp implements AdminProductService{

	@Autowired
	private AdminProductDao adminProductDao;
	
	@Override
	public void productList(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int page = Integer.parseInt(request.getParameter("page"));
		
		//ArrayList<ProductDto> allProducts = service.getProductAll();
		//ArrayList<ProductDto> products = service.getProductManagementByPageNum(page);
		
		ArrayList<ProductDto>products = adminProductDao.getProductManagementByPageNum(page);
		List<Object> allProducts = null;
		allProducts = adminProductDao.getProductAll();
		
		for (ProductDto product : products) {
			ArrayList<ProductSizeVO> productsSize = adminProductDao.getProductsSizeAll(product.getNum());
			product.setSizes(productsSize);
		}
		
		request.setAttribute("products", products);		
		
		PaginationVO pn = new PaginationVO();
		
		// 페이징 처리
		pn.setPage(page);					// 현재 페이지
		pn.setCountList(8);					// 한 화면에 보여질 상품 수
		pn.setCountPage(3);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>
		
		pn.setTotalCount(allProducts.size());	// 전체 상품 수 ex) 35개
		
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
		
//		String page = request.getParameter("page");
//
//		if (page == null) {
//			page = "1";
//		}
//		
//		int currentPage = Integer.parseInt(page);
//		int noticeSize = 10; // �븳�럹�씠吏��뿉 10媛�
//		int startRow = (currentPage - 1) * noticeSize + 1; // 湲��떆�옉踰덊샇
//		int endRow = currentPage * noticeSize; // �걹踰덊샇
//		int count = noticeDao.countallmine();
//
//		List<NoticeDto> notices = null;
//
//		notices = noticeDao.noticeList(startRow, endRow);
//		
//		mav.addObject("notices", notices);
//		mav.addObject("currentPage", currentPage);
//		mav.addObject("noticeSize", noticeSize);
//		mav.addObject("count", count);
//		mav.setViewName("notice/list");
	}

	@Override
	public void productWrite(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void productWriteOk(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

}
