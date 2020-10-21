package com.java.productOrder.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.productOrder.dao.ProductOrderDao;
import com.java.productOrder.dto.ProductOrderDto;
import com.java.productOrder.dto.ProductOrderVO;

@Component
public class ProductOrderServiceImp implements ProductOrderService{

	@Autowired
	private ProductOrderDao productOrderDao;

	@Override
	public void productOrderMyCart(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		int o_state=Integer.parseInt(request.getParameter("o_state"));
		HttpSession session=request.getSession(false);
		String id =(String)session.getAttribute("id");
		System.out.println(id);
		List<ProductOrderVO> list=productOrderDao.productOrderMyCart(id);
		mav.addObject("o_state",o_state);
		mav.addObject("list",list);
		mav.setViewName("/mypage/myCart");
		
	}

	@Override
	public void productOrderInquiry(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session=request.getSession(false);
		String id =(String)session.getAttribute("id");
		System.out.println(id);
		List<ProductOrderVO> list=productOrderDao.productOrderInquiry(id);
		mav.addObject("list",list);
		mav.setViewName("/mypage/neworderlist");
	}
	
}
