package com.java.productOrder.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.common.OrderInfoVO;
import com.java.productOrder.dto.ProductOrderDto;
import com.java.productOrder.dto.ProductOrderVO;

@Component
public class ProductOrderDaoImp  implements ProductOrderDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<ProductOrderVO> productOrderMyCart(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("productOrderMyCart",map);
	}

	@Override
	public List<ProductOrderVO> productOrderInquiry(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("productOrderInquiry",map);
	}

	@Override
	public int findProductQuantity(int p_num, String size) {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("p_num", Integer.toString(p_num));
		hmap.put("size", size);
		Integer check = sqlSessionTemplate.selectOne("findProductQuantity",hmap); 
		return check == null ? 0 : check;
	}

	@Override
	public int findProductInCartNum(String id, int p_num, String size) {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("id", id);
		hmap.put("p_num", Integer.toString(p_num));
		hmap.put("size", size);
		Integer check = sqlSessionTemplate.selectOne("findProductInCartNum", hmap);
		return check == null ? 0 : check;
	}

	@Override
	public int makeProductOrderNum() {
		return sqlSessionTemplate.selectOne("makeProductOrderNum");
	}

	@Override
	public void productOrderAdd(ProductOrderDto po) {
		sqlSessionTemplate.insert("productOrderAdd",po);
	}

	@Override
	public List<ProductOrderVO> orderList(String m_id, int o_state) {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("m_id", m_id);
		hmap.put("o_state", Integer.toString(o_state));
		return sqlSessionTemplate.selectList("orderList",hmap);
	}

	@Override
	public void delOrder(int num) {
		sqlSessionTemplate.delete("delOrder",num);
	}

	@Override
	public List<ProductOrderVO> productOrderGetInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("productOrderGetInfo", map);
	}

	@Override
	public OrderInfoVO getPaymentInfo(String code_num) {
		return sqlSessionTemplate.selectOne("getPaymentInfo", code_num); 
	}

	@Override
	public List<Integer> productOrdergetctnrow(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("productOrdergetctnrow", map);
	}

	@Override
	public List<ProductOrderVO> orderListByCNum(String m_id, String code_num) {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("m_id", m_id);
		hmap.put("code_num", code_num);
		return sqlSessionTemplate.selectList("orderCode", hmap);
	}

	@Override
	public ProductOrderVO getOrder(int num) {
		return sqlSessionTemplate.selectOne("getOrder", num); 
	}

	@Override
	public void updateCode_num(ProductOrderVO po) {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("code_num",po.getCode_num());
		hmap.put("o_state",Integer.toString(po.getO_state()));
		hmap.put("num",Integer.toString(po.getNum()));
		sqlSessionTemplate.update("updateCode_num", po); 
	}

	@Override
	public int selectOrderInfoNum() {
		return sqlSessionTemplate.selectOne("selectOrderInfoNum");
	}

	@Override
	public void addOrderInfo(OrderInfoVO oivo) {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("num", Integer.toString(oivo.getNum()));
		sqlSessionTemplate.insert("addOrderInfo",hmap);
	}
}
