package com.java.admin.product.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	public int productDelete(Map<String, Object> hmap);

	public ProductDto productSelect(int num);

	public int checkQuantity(int productNum, String size);

	public int makeProductSizeNum();

	public void add(ProductSizeVO ps);

	public void addQuantity(ProductSizeVO ps);
}
