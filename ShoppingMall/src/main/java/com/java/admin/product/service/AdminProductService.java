package com.java.admin.product.service;

import org.springframework.web.servlet.ModelAndView;

public interface AdminProductService {

	public void productList(ModelAndView mav);

	public void productWrite(ModelAndView mav);

	public void productWriteOk(ModelAndView mav);

}
