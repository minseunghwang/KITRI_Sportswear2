package com.java.review.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
