package com.java.productOrder.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.productOrder.dto.ProductOrderDto;
import com.java.productOrder.dto.ProductOrderVO;

@Component
public class ProductOrderDaoImp  implements ProductOrderDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<ProductOrderVO> productOrderMyCart(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("productOrderMyCart",id);
	}

	@Override
	public List<ProductOrderVO> productOrderInquiry(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("productOrderInquiry",id);
	}
}
