package com.java.product.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.common.ProductImageVO;
import com.java.common.ProductSizeVO;
import com.java.product.dto.ProductDto;

@Component
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<ProductDto> selectAll(){
		return sqlSessionTemplate.selectList("mainpage_product");
	}

	@Override
	public ArrayList<ProductSizeVO> selectSizeAll(int p_num) {
		return null;
	}

	@Override
	public ArrayList<ProductDto> selectAllByPageNum(int page) {
		return null;
	}

	@Override
	public List<ProductDto> selectNewProducts(int numberItems) {
		return sqlSessionTemplate.selectList("new_product", numberItems);
	}

	@Override
	public ArrayList<ProductDto> selectBestProducts(int numberItems) {
		return null;
	}

	@Override
	public List<ProductDto> selectCategoryProducts(String category) {
		return sqlSessionTemplate.selectList("category_product", category);
	}

	@Override
	public List<ProductDto> selectCategoryProductsByPageNum(String category, int page) {
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("category", category);
		int startRange = (page - 1) * 8 + 1;
		hmap.put("page", Integer.toString(startRange));
		int endRange = page * 8;
		hmap.put("num", Integer.toString(endRange));
		return sqlSessionTemplate.selectList("category_product_pageNum",hmap);
	}

	@Override
	public List<ProductDto> selectCategoryProductsSort(String category, int page, String orderBy) {
		int startRange = (page - 1) * 8 + 1;
		int endRange = page * 8;
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("category", category);
		hmap.put("startRange", Integer.toString(startRange));
		hmap.put("endRange", Integer.toString(endRange));
		hmap.put("orderBy", orderBy);
		System.out.println(category + " "+ startRange + " "+ endRange + " "+ orderBy);
		return sqlSessionTemplate.selectList("category_product_Sort",hmap);
	}

	@Override
	public ArrayList<ProductDto> selectKeywordProductsByPageNum(String keyword, int page) {
		return null;
	}

	@Override
	public ArrayList<ProductDto> selectKeywordProductsSort(String keyword, int page, String orderBy) {
		return null;
	}

	@Override
	public List<ProductImageVO> selectDetailImages(int p_num) {
		return sqlSessionTemplate.selectList("detail_image",p_num);
	}

	@Override
	public int selectProductNum() {
		return 0;
	}

	@Override
	public int selectProductImgNum() {
		return 0;
	}

	@Override
	public int selectProductSizeNum() {
		return 0;
	}

	@Override
	public void insert(ProductDto p) {
		
	}

	@Override
	public void insert(ProductImageVO pi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(ProductSizeVO ps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProductSizeVO ps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductDto select(int num) {
		return sqlSessionTemplate.selectOne("detail_product", num);
	}

	@Override
	public int selectQuantity(int productNum, String size) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recordCount(ProductDto productvo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDto> searchProduct(String keyword, int page, String orderBy) {
		int startRange = (page - 1) * 8 + 1;
		int endRange = page * 8;
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("keyword", keyword);
		hmap.put("startRange", Integer.toString(startRange));
		hmap.put("endRange", Integer.toString(endRange));
		hmap.put("orderBy", orderBy);
		return sqlSessionTemplate.selectList("search_product", hmap);
	}

}