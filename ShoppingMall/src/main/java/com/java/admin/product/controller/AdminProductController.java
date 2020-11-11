package com.java.admin.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.admin.product.service.AdminProductService;
import com.java.common.ProductImageVO;
import com.java.product.dto.ProductDto;

@Component
@Controller
public class AdminProductController {
	@Autowired
	private AdminProductService adminProductService;
	
	@RequestMapping(value="/admin/product/adminProductManagement.do")
	public ModelAndView productList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		adminProductService.productList(mav);
		return mav;
		//return new ModelAndView("admin/product/adminProductMangement");
	}
	
	@RequestMapping(value="/admin/product/adminProductAddForm.do")
	public ModelAndView productWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		adminProductService.productWrite(mav);
		return mav;
	}
	
	@RequestMapping(value="/admin/product/adminProductAddFormOk.do")
	public ModelAndView productWriteOk(HttpServletRequest request, HttpServletResponse response, ProductDto productDto, ProductImageVO productImageVO ) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		mav.addObject("productDto",productDto);
		mav.addObject("productImageVO", productImageVO);
		adminProductService.productWriteOk(mav);
		return mav;
	}
}
