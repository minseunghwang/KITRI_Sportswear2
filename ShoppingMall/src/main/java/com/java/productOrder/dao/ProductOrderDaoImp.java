package com.java.productOrder.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
	public void productOrderAdd(ProductOrderVO po) {
		sqlSessionTemplate.insert("productOrderAdd",po);
	}

	@Override
	public List<ProductOrderVO> orderList(String m_id, int o_state) {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("m_id", m_id);
		hmap.put("o_state", Integer.toString(o_state));
		System.out.println("mId : " + m_id);
		System.out.println("o_state : " + o_state);
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
		sqlSessionTemplate.update("updateCode_num", hmap); 
	}

	@Override
	public int selectOrderInfoNum() {
		return sqlSessionTemplate.selectOne("selectOrderInfoNum");
	}

	@Override
	public void addOrderInfo(OrderInfoVO oivo) {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("num", Integer.toString(oivo.getNum()));
		hmap.put("oi_id",oivo.getOi_id());
		hmap.put("oi_name",oivo.getOi_name());
		hmap.put("oi_phone",oivo.getOi_phone());
		hmap.put("oi_email",oivo.getOi_addr_full());
		hmap.put("oi_addr_full",oivo.getOi_addr_full());
		hmap.put("oi_addr_zipno",oivo.getOi_addr_zipno());
		hmap.put("oi_addr_roadAddPart1",oivo.getOi_addr_roadAddrPart1());
		hmap.put("oi_addr_roadAddPart2",oivo.getOi_addr_roadAddrPart2());
		hmap.put("oi_addr_addrDetail",oivo.getOi_addr_addrDetail());
		hmap.put("oi_deliMessage",oivo.getOi_deliMessage());
		hmap.put("oi_howPay",oivo.getOi_howPay());
		hmap.put("oi_usepoint", Integer.toString(oivo.getOi_usepoint()));
		hmap.put("oi_originTotalPrice", Integer.toString(oivo.getOi_originTotalPrice()));
		hmap.put("oi_totalPrice", Integer.toString(oivo.getOi_totalPrice()));
		hmap.put("oi_code_num",oivo.getOi_code_num());
		hmap.put("add_name",oivo.getAdd_name());
		hmap.put("add_phone1",oivo.getAdd_phone1());
		hmap.put("add_phone2",oivo.getAdd_phone2());
		hmap.put("add_email",oivo.getAdd_email());
		hmap.put("add_addr_full",oivo.getAdd_addr_full());
		hmap.put("add_addr_zipNo",oivo.getAdd_addr_zipNo());
		hmap.put("add_addr_roadAddPart1",oivo.getAdd_addr_roadAddrPart1());
		hmap.put("add_addr_roadAddPart2",oivo.getAdd_addr_roadAddrPart2());
		hmap.put("add_addr_addrDetail",oivo.getAdd_addr_addrDetail());
		
		sqlSessionTemplate.insert("addOrderInfo",hmap);
	}
}
