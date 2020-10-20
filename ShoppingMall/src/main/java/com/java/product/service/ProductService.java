package com.java.product.service;

import java.util.ArrayList;

import org.springframework.web.servlet.ModelAndView;

import com.java.common.ProductImageVO;
import com.java.common.ProductSizeVO;
import com.java.product.dto.ProductDto;


public interface ProductService {

	public void getProductAll(ModelAndView mav);
	
	ArrayList<ProductSizeVO> getProductsSizeAll(int p_num);
	
	ArrayList<ProductDto> getProductManagementByPageNum(int page);
	
	public void getBestProducts(ModelAndView mav, int numberItems);
	
	public void getNewProducts(ModelAndView mav, int numberItems);
	
	public void getCategoryProducts(ModelAndView mav);
	
	ArrayList<ProductDto> getCategoryProductsByPageNum(String category, int page);
	
	ArrayList<ProductDto> getCategoryProductsSort(String category, int page, String orderBy);
	
	ArrayList<ProductDto> getKeywordProductsByPageNum(String keyword, int page);
	
	ArrayList<ProductDto> getKeywordProductsSort(String keyword, int page, String orderBy);
	
	ArrayList<ProductImageVO> getDetailImgAll(int p_num);
	
	public void getProductDetail(ModelAndView mav);
	
	int checkQuantity(int productNum, String size);
	
	int makeProductNum();
	
	int makeProductImgNum();
	
	int makeProductSizeNum();
	
	void add(ProductDto p);
	
	void add(ProductImageVO pi);
	
	void add(ProductSizeVO ps);
	
	void addQuantity(ProductSizeVO ps);
	
	void delProduct(int num);
	
	void recordup(ProductDto productvo);
}
