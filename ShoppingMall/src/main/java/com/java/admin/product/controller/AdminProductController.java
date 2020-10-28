package com.java.admin.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.admin.product.service.AdminProductService;
import com.java.product.dto.ProductDto;

@Component
@Controller
public class AdminProductController {
	@Autowired
	private AdminProductService adminProductService;
	
	@RequestMapping(value="/admin/product/adminProductManagement.do")
	public ModelAndView noticeList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		adminProductService.productList(mav);
		return mav;
		//return new ModelAndView("admin/product/adminProductMangement");
	}
	
	@RequestMapping(value="/admin/product/write.do")
	public ModelAndView fileBoardWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		adminProductService.productWrite(mav);
		return mav;
	}
	
	@RequestMapping(value="/fileBoard/writeOk.do")
	public ModelAndView fileBoardWriteOk(HttpServletRequest request, HttpServletResponse response, ProductDto productDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		mav.addObject("productDto",productDto);
		adminProductService.productWriteOk(mav);
		return mav;
	}
}
