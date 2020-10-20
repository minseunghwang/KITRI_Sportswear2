//package com.java.productOrder.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.java.productOrder.service.ProductOrderService;
//
//
//@Component
//@Controller
//public class ProductOrderController {
//	
//	@Autowired
//	private ProductOrderService productOrderService;
//	
//	@RequestMapping(value="/productorder/1")
//	public ModelAndView productOrder(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("request",request);
//		
//		return mav;
//	}
//}
