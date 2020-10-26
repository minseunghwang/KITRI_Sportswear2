package com.java.productOrder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import com.java.productOrder.service.ProductOrderService;


@Component
@Controller
public class ProductOrderController {
	
	@Autowired
	private ProductOrderService productOrderService;
	
	@RequestMapping(value="/productorder/myCart.do")
	public ModelAndView productOrderMyCart(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("request",request);
		productOrderService.productOrderMyCart(mav);
		return mav;
	}
	
	@RequestMapping(value="/productorder/orderInquiry.do") //�ֹ���ȸ
	public ModelAndView productOrderInquiry(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("request",request);
		productOrderService.productOrderInquiry(mav);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/productorder/addCart.do")
	public ModelAndView productOrderAddCart(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav= new ModelAndView("jsonView");
		productOrderService.productOrderAddCart(mav,request);
		return mav;
	}
	
	@RequestMapping(value="/productorder/orderList.do") //�ֹ���ȸ
	public ModelAndView productOrderList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("request",request);
		productOrderService.productOrderList(mav);
		return mav;
	}

	@RequestMapping(value="/productorder/deleteOrder.do") //�ֹ���ȸ
	public ModelAndView productOrderDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("request",request);
		productOrderService.productOrderDelete(mav);
		return mav;
	}
	
}
