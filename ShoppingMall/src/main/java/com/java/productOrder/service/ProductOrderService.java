package com.java.productOrder.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface ProductOrderService {
	
	public void productOrderMyCart(ModelAndView mav);
	public void productOrderInquiry(ModelAndView mav);
	public void productOrderAddCart(ModelAndView mav, HttpServletRequest request);
	public void productOrderList(ModelAndView mav);
	public void productOrderDelete(ModelAndView mav);
	public void productOrderPaymentPage(ModelAndView mav);
	public void productOrderPaymentInfo(ModelAndView mav);
	public void productOrderDetail(ModelAndView mav);
	public void productOrderDataSave(ModelAndView mav);
	public void productOrderCartPayment(ModelAndView mav);
	public void productOrderCheckPayment(ModelAndView mav, HttpServletRequest request);
}
