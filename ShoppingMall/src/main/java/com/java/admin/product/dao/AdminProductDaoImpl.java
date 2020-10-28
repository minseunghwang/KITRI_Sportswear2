package com.java.admin.product.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.common.ProductSizeVO;
import com.java.product.dto.ProductDto;
import com.java.productSize.dto.ProductSizeDto;

@Component
public class AdminProductDaoImpl implements AdminProductDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Object> getProductAll() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		return sqlSessionTemplate.selectList("product_list",map);
	}

	@Override
	public ArrayList<ProductDto> getProductManagementByPageNum(int page) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("getProductManagementByPageNum", page);
	}

	@Override
	public ArrayList<ProductSizeVO> getProductsSizeAll(int p_num) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("getProductsSizeAll", p_num);
	}

	
}
