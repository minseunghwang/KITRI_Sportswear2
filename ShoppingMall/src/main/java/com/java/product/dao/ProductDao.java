package com.java.product.dao;

import java.util.ArrayList;
import java.util.List;

import com.java.common.ProductImageVO;
import com.java.common.ProductSizeVO;
import com.java.product.dto.ProductDto;


public interface ProductDao {
	
	List<ProductDto> selectAll();
	ArrayList<ProductSizeVO> selectSizeAll(int p_num);
	ArrayList<ProductDto> selectAllByPageNum(int page);
	List<ProductDto> selectBestProducts(int numberItems);
	List<ProductDto> selectNewProducts(int numberItems);
	List<ProductDto> selectCategoryProducts(String category);
	List<ProductDto> selectCategoryProductsByPageNum(String category, int page);
	List<ProductDto> selectCategoryProductsSort(String category, int page, String orderBy);
	ArrayList<ProductDto> selectKeywordProductsByPageNum(String keyword, int page);
	ArrayList<ProductDto> selectKeywordProductsSort(String keyword, int page, String orderBy);
	List<ProductImageVO> selectDetailImages(int p_num);
	int selectProductNum();
	int selectProductImgNum();
	int selectProductSizeNum();
	void insert(ProductDto p);
	void insert(ProductImageVO pi);
	void insert(ProductSizeVO ps);
	void update(ProductSizeVO ps);
	ProductDto select(int num);
	int selectQuantity(int productNum, String size);
	void delete(int num);
	void recordCount(ProductDto productvo);
	List<ProductDto> searchProduct(String keyword, int page, String orderBy);
}
