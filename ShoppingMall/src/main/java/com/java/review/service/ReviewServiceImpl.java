package com.java.review.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.common.PaginationVO;
import com.java.review.dao.ReviewDao;
import com.java.review.dto.ReviewDto;


@Component
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public void add(ReviewDto review) {
		reviewDao.insert(review);
	}

	@Override
	public ReviewDto getReview(int num) {
		return reviewDao.select(num);
	}
	
	@Override
	public List<ReviewDto> getReviewByProductNum(int p_num) {
		return reviewDao.selectByP_Num(p_num);
	}
	
	@Override
	public List<ReviewDto> getReviewInProductByPageNum(int p_num, int page) {
		return reviewDao.selectReviewInProductByPageNum(p_num, page);
	}

	@Override
	public void editReview(ReviewDto review) {
		reviewDao.update(review);
	}

	@Override
	public void delReview(int num) {
		reviewDao.delete(num);
	}

	@Override
	public ArrayList<ReviewDto> getReviewAll() {
		return reviewDao.selectAll();
	}

	@Override
	public int makeNum() {
		return reviewDao.selectNum();
	}

	@Override
	public ArrayList<ReviewDto> getMyReviewAll(String m_id, int page) {
		return reviewDao.myselectAll(m_id, page);
	}

	@Override
	public int getSelectedP_num(int r_num) {
		return reviewDao.selectP_Num(r_num);
	}

	@Override
	public int getcountMine(String m_id) {
		return reviewDao.countallmine(m_id);
	}

	@Override
	public int getcountByP_Num(int p_num) {
		return reviewDao.countreviewByP_Num(p_num);
	}

	@Override
	public void reviewMyList(ModelAndView mav) {
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session = request.getSession(false);
		String m_id = (String)session.getAttribute("id");
		
		int page = Integer.parseInt(request.getParameter("page"));
		ArrayList<ReviewDto> list = reviewDao.getMyReviewAll(m_id, page);
		
		
		PaginationVO pn = new PaginationVO();
		
		// 페이징 처리
		pn.setPage(page);					// 현재 페이지
		pn.setCountList(4);					// 한 화면에 보여질 상품 수
		pn.setCountPage(3);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>

		pn.setTotalCount(reviewDao.getcountMine(m_id));	// 전체 상품 수 ex) 35개

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
		
		mav.addObject("pn",pn);
		mav.addObject("list",list);
		mav.setViewName("/review/myReviewList");
	}

	@Override
	public void AddReview(ModelAndView mav) {
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		int p_num = Integer.parseInt(request.getParameter("p_num"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		mav.addObject("p_num", p_num);
		mav.addObject("num", num);
		mav.setViewName("/review/addForm");
	}
}
