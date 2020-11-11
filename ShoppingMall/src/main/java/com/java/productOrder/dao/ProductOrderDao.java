package com.java.productOrder.dao;

import java.util.List;
import java.util.Map;

import com.java.common.OrderInfoVO;
import com.java.product.dto.ProductDto;
import com.java.productOrder.dto.ProductOrderDto;
import com.java.productOrder.dto.ProductOrderVO;

public interface ProductOrderDao {
	
	public List<ProductOrderVO> productOrderMyCart(Map<String, Object> map);
	public List<ProductOrderVO> productOrderInquiry(Map<String, Object> map);
	public int findProductQuantity(int p_num, String size);
	public int findProductInCartNum(String id, int p_num, String size);
	public void productOrderAdd(ProductOrderVO po);
	public List<ProductOrderVO> productOrderGetInfo(Map<String, Object> map);
	public void delOrder(int num);
	public int makeProductOrderNum();
	public List<ProductOrderVO> orderList(String m_id, int o_state);
	public OrderInfoVO getPaymentInfo(String code_num);
	public List<Integer> productOrdergetctnrow(Map<String, Object> map);
	public List<ProductOrderVO> orderListByCNum(String m_id, String code_num);
	public ProductOrderVO getOrder(int num);
	public void updateCode_num(ProductOrderVO po);
	public int selectOrderInfoNum();
	public void addOrderInfo(OrderInfoVO oivo);
	public void editR_State(String m_id, int num);
	public void editPoint(String m_id, int o_num);
	public int getCartItemCount(String m_id);
}
