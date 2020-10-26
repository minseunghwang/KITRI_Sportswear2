package com.java.productOrder.dao;

import java.util.List;
import java.util.Map;

import com.java.productOrder.dto.ProductOrderDto;
import com.java.productOrder.dto.ProductOrderVO;

public interface ProductOrderDao {
	
	public List<ProductOrderVO> productOrderMyCart(String id);
	public List<ProductOrderVO> productOrderInquiry(Map<String, Object> map);
	public int findProductQuantity(int p_num, String size);
	public int findProductInCartNum(String id, int p_num, String size);
	public int makeProductOrderNum();
	public void productOrderAdd(ProductOrderDto po);
	public List<ProductOrderVO> productOrderGetInfo(Map<String, Object> map);
	public void delOrder(int num);
	public List<ProductOrderVO> orderList(String m_id, int o_state);
}
