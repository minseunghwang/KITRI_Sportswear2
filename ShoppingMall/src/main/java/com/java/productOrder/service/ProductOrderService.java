package com.java.productOrder.service;

import org.springframework.web.servlet.ModelAndView;

public interface ProductOrderService {
	
	public void productOrderMyCart(ModelAndView mav);
	public void productOrderInquiry(ModelAndView mav);
}
