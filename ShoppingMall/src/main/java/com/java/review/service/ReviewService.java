package com.java.review.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.java.review.dto.ReviewDto;



public interface ReviewService {
	void add(ReviewDto notice);

	ReviewDto getReview(int num);
	
	List<ReviewDto> getReviewByProductNum(int p_num);
	List<ReviewDto> getReviewInProductByPageNum(int p_num, int page);


	void delReview(int num);

	ArrayList<ReviewDto> getReviewAll();

	int makeNum();
	int getSelectedP_num(int r_num);
	ArrayList<ReviewDto> getMyReviewAll(String m_id, int page);
	int getcountByP_Num(int p_num);
	
	public void reviewMyList(ModelAndView mav);
	public void AddReview(ModelAndView mav);
	public void CreateReview(ModelAndView mav,HttpServletRequest request);
	public void UpdateReview(ModelAndView mav);
	public void EditReview(ModelAndView mav, HttpServletRequest request);
}
