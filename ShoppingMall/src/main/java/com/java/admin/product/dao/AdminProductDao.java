package com.java.admin.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.common.ProductImageVO;
import com.java.common.ProductSizeVO;
import com.java.product.dto.ProductDto;
import com.java.productSize.dto.ProductSizeDto;


@Component
public interface AdminProductDao {

	public List<Object> getProductAll();
	
	public List<ProductDto> getProductManagementByPageNum(int startPage, int endPage);
	
	public List<ProductSizeVO> getProductsSizeAll(int p_num);

//	public int productWriteOk(ProductDto productDto, ProductImageVO productImageVO);

	public int makeProductNum();

	public int productInsert(ProductDto productDto);

	public int productImgInsert(ProductImageVO productImageVO);

	public int makeProductImgNum();
}
