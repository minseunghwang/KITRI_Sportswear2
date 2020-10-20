package com.java.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.common.PaginationVO;
import com.java.common.ProductImageVO;
import com.java.common.ProductSizeVO;
import com.java.member.service.MemberService;
import com.java.pagenation.dto.PaginationDto;
import com.java.product.dao.ProductDao;
import com.java.product.dto.ProductDto;
import com.java.review.dao.ReviewDao;
import com.java.review.dto.ReviewDto;
import com.java.review.service.ReviewService;


@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private MemberService memberService;
	
	
	@Override
	public void getProductAll(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		List<ProductDto> mainpageItem = productDao.selectAll();
		mav.addObject("mainpageItem",mainpageItem);
		mav.setViewName("main/main");
	}
	
	@Override
	public void getNewProducts(ModelAndView mav, int numberItems) {
		Map<String, Object> map = mav.getModelMap();
		List<ProductDto> newProducts = productDao.selectNewProducts(numberItems);
		mav.addObject("newProducts", newProducts);
		mav.setViewName("main/main");
	}
	
	@Override
	public ArrayList<ProductSizeVO> getProductsSizeAll(int p_num) {
		return productDao.selectSizeAll(p_num);
	}
	
	@Override
	public ArrayList<ProductDto> getProductManagementByPageNum(int page) {
		return productDao.selectAllByPageNum(page);
	}

	@Override
	public void getBestProducts(ModelAndView mav, int numberItems) {
	}

	@Override
	public void getCategoryProducts(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String category = request.getParameter("category");
		int page = Integer.parseInt(request.getParameter("page"));
		
		String orderBy = request.getParameter("orderBy");
		if(request.getParameter("orderBy") == "") {
			orderBy = null;
		}
		List<ProductDto> categoryProducts = productDao.selectCategoryProducts(category);
		List<ProductDto> products = new ArrayList<ProductDto>();
		
		if(orderBy == null) {
			products = productDao.selectCategoryProductsByPageNum(category,page);
		} else {
			products = productDao.selectCategoryProductsSort(category,page,orderBy);
		}
		
		
		for(ProductDto product:products) {
			ArrayList<ReviewDto> reviews = (ArrayList<ReviewDto>) reviewDao.selectByP_Num(product.getNum());
			product.setReviews(reviews);
			product.setPriceView(product.getPrice());
		}
		
		PaginationDto pn = new PaginationDto();
		
		pn.setPage(page);
		pn.setCountList(8);
		pn.setCountPage(3);
		
		pn.setTotalCount(categoryProducts.size());
		
		pn.setTotalPage(pn.getTotalCount() / pn.getCountList());
		if(pn.getTotalCount() % pn.getCountList() > 0) {	// ex) 총 상품 35개, 한 페이지에 8개 표시 :: 4개의 페이지(8개 상품) + 1페이지(3개 상품)
			pn.setTotalPage(pn.getTotalPage() + 1);
		}
		
		if(pn.getTotalPage() < pn.getPage()) {
			pn.setPage(pn.getTotalPage());
		}
		
		pn.setStartPage((pn.getPage() - 1) / pn.getCountPage() * pn.getCountPage() + 1);
		pn.setEndPage(pn.getStartPage() + pn.getCountPage() - 1);
		
		if(pn.getEndPage() > pn.getTotalPage()) {
			pn.setEndPage(pn.getTotalPage());
		}
		
//		request.setAttribute("pn", pn);
		mav.addObject("products", products);
		mav.addObject("pn", pn);
		mav.setViewName("product/categoryList");
	}
	
	@Override
	public ArrayList<ProductDto> getCategoryProductsByPageNum(String category, int page) {
		return (ArrayList<ProductDto>) productDao.selectCategoryProductsByPageNum(category, page);
	}
	
	@Override
	public ArrayList<ProductDto> getCategoryProductsSort(String category, int page, String orderBy) {
		return (ArrayList<ProductDto>) productDao.selectCategoryProductsSort(category, page, orderBy);
	}

	@Override
	public ArrayList<ProductDto> getKeywordProductsByPageNum(String keyword, int page) {
		return productDao.selectKeywordProductsByPageNum(keyword, page);
	}

	@Override
	public ArrayList<ProductDto> getKeywordProductsSort(String keyword, int page, String orderBy) {
		return productDao.selectKeywordProductsSort(keyword, page, orderBy);
	}
	
	@Override
	public void getDetailImgAll(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int p_num = Integer.parseInt(request.getParameter("p_num"));
		List<ProductImageVO> imgs = productDao.selectDetailImages(p_num);
		mav.addObject("imgs", imgs);
		mav.setViewName("json/detailImgList_JSON");
	}

	@Override
	public int checkQuantity(int productNum, String size) {
		return productDao.selectQuantity(productNum, size);
	}
	
	@Override
	public int makeProductNum() {
		return productDao.selectProductNum();
	}

	@Override
	public int makeProductImgNum() {
		return productDao.selectProductImgNum();
	}

	@Override
	public int makeProductSizeNum() {
		return productDao.selectProductSizeNum();
	}
	
	@Override
	public void add(ProductDto p) {
		productDao.insert(p);
	}	
	
	@Override
	public void add(ProductImageVO pi) {
		productDao.insert(pi);
	}
	
	@Override
	public void add(ProductSizeVO ps) {
		productDao.insert(ps);
	}

	@Override
	public void getProductDetail(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int num = Integer.parseInt(request.getParameter("num"));
		
		int page = 0;
		if(request.getParameter("page") == null) {
			page = 1;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ProductDto product = productDao.select(num);
		product.setPriceView(product.getPrice());
		
		List<ReviewDto> reviewsAll = reviewDao.selectByP_Num(num);
		
		if(reviewsAll.size() != 0) {
			mav.addObject("reviewsAll", reviewsAll);
			
			PaginationVO pn = new PaginationVO();
			
			// 페이징 처리
			pn.setPage(page);					// 현재 페이지
			pn.setCountList(3);					// 한 화면에 보여질 상품 수
			pn.setCountPage(10);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>
			
			pn.setTotalCount(reviewsAll.size());	// 전체 상품 수 ex) 35개
			
			pn.setTotalPage(pn.getTotalCount() / pn.getCountList());
			if(pn.getTotalCount() % pn.getCountList() > 0) {	// ex) 총 상품 35개, 한 페이지에 8개 표시 :: 4개의 페이지(8개 상품) + 1페이지(3개 상품)
				pn.setTotalPage(pn.getTotalPage() + 1);
			}
			
			if(pn.getTotalPage() < pn.getPage()) {
				pn.setPage(pn.getTotalPage());
			}
			
			pn.setStartPage((pn.getPage() - 1) / pn.getCountPage() * pn.getCountPage() + 1);
			pn.setEndPage(pn.getStartPage() + pn.getCountPage() - 1);
			
			
			/*
			 *  아래 조건이 없으면 다음과 같은 대참사가 발생
			 *  현재 4페이지에 위치하면, startPage == 4, endPage == 5 로 나와야함. << < 4 5 > >>
			 *  아래 조건이 없을 경우, endPage = 4 + 3 - 1 >> endPage == 6..    :: << < 4 5 6 > >>  
			 *  6페이지를 누르면 아무런 값도 나오지 않음
			 *  아래 조건을 넣어야 if( 6 > 5 ) 조건을 만족하여 endPage는 5가 됨
			 */
			if(pn.getEndPage() > pn.getTotalPage()) {
				pn.setEndPage(pn.getTotalPage());
			}
		}
		
		List<ReviewDto> reviews = reviewDao.selectReviewInProductByPageNum(num, page);
		
		product.setReviews((ArrayList<ReviewDto>) reviews);
		
		mav.addObject("product", product);
		mav.addObject("reviews", reviews);
		mav.setViewName("product/detail");
		
	}

	@Override
	public void addQuantity(ProductSizeVO ps) {
		productDao.update(ps);
	}

	@Override
	public void delProduct(int num) {
		productDao.delete(num);
	}

	@Override
	public void recordup(ProductDto productvo) {
		productDao.recordCount(productvo);
	}

}
