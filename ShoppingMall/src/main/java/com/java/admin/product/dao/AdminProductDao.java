package com.java.admin.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.common.ProductSizeVO;
import com.java.product.dto.ProductDto;
import com.java.productSize.dto.ProductSizeDto;


@Component
public interface AdminProductDao {

	public List<Object> getProductAll();
	
	public ArrayList<ProductDto> getProductManagementByPageNum(int page);
	
	public ArrayList<ProductSizeVO> getProductsSizeAll(int p_num);

}
