package com.java.productOrder.dao;

import java.util.List;

import com.java.productOrder.dto.ProductOrderDto;
import com.java.productOrder.dto.ProductOrderVO;

public interface ProductOrderDao {
	
	public List<ProductOrderVO> productOrderMyCart(String id);
	public List<ProductOrderVO> productOrderInquiry(String id);
}
