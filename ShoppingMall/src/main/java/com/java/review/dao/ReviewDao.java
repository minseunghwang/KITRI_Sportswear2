package com.java.review.dao;

import java.util.ArrayList;
import java.util.List;

import com.java.review.dto.ReviewDto;




public interface ReviewDao {
	int selectNum();
	int selectP_Num(int r_num);
	void insert(ReviewDto review);

	ReviewDto select(int num);
	
	List<ReviewDto> selectByP_Num(int p_num);
	List<ReviewDto> selectReviewInProductByPageNum(int p_num, int page);

	void update(ReviewDto notice);

	void delete(int num);
	
	ArrayList<ReviewDto> selectAll();

	ArrayList<ReviewDto> myselectAll(String m_id, int page);
	int countallmine(String m_id);
	int countreviewByP_Num(int p_num);
}
