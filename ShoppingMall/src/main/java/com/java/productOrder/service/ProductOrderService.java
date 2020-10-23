package com.java.productOrder.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface ProductOrderService {
	
	public void productOrderMyCart(ModelAndView mav);
	public void productOrderInquiry(ModelAndView mav);
	public void productOrderAddCart(ModelAndView mav, HttpServletRequest request);
	public void productOrderList(ModelAndView mav);

}
