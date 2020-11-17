package com.java.admin.product.dao;

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
	public List<ProductDto> getProductManagementByPageNum(int startPage, int endPage) {
		Map<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("startPage", startPage);
		hMap.put("endPage", endPage);
		return sqlSessionTemplate.selectList("getProductManagementByPageNum", hMap);
	}

	@Override
	public List<ProductSizeVO> getProductsSizeAll(int p_num) {
		return sqlSessionTemplate.selectList("getProductsSizeAll", p_num);
	}

//	@Override
//	public int productWriteOk(ProductDto productDto, ProductImageVO productImageVO) {
//		if(productDto.getName()==null) { //파일첨부를 안했을때
//			return sqlSessionTemplate.insert("product_insert",productDto);
//		}
//		return sqlSessionTemplate.insert("product_insert_file",productDto); //파일첨부를 했을때
//	}

	@Override
	public int makeProductNum() {
		return sqlSessionTemplate.selectOne("selectProductNum");
	}

	@Override
	public int productInsert(ProductDto productDto) {
		return sqlSessionTemplate.insert("product_insert", productDto);
	}

	@Override
	public int productImgInsert(ProductImageVO productImageVO) {
		return sqlSessionTemplate.insert("product_insert_Img", productImageVO);
	}

	@Override
	public int makeProductImgNum() {
		return sqlSessionTemplate.selectOne("selectProductImgNum");
	}

	@Override
	public int productDelete(Map<String, Object> hmap) {
		return sqlSessionTemplate.delete("product_delete",hmap);
	}

	@Override
	public ProductDto productSelect(int num) {
		return sqlSessionTemplate.selectOne("product_read",num);
	}

	@Override
	public int checkQuantity(int productNum, String size) {
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("productNum", Integer.toString(productNum));
		hMap.put("size", size);
		Integer check = sqlSessionTemplate.selectOne("selectQuantity", hMap);
		if (check == null) {
			check = -1;
		}
		return check;
	}
	

	@Override
	public int makeProductSizeNum() {
		return sqlSessionTemplate.selectOne("selectProductSizeNum");
	}

	@Override
	public void add(ProductSizeVO ps) {
		sqlSessionTemplate.insert("productSize_insert",ps);
	}

	@Override
	public void addQuantity(ProductSizeVO ps) {
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("productNum", Integer.toString(ps.getP_num()));
		hMap.put("size", ps.getPsize());
		hMap.put("quantity", Integer.toString(ps.getQuantity()));
		sqlSessionTemplate.update("productSize_update",hMap);
	}
}
