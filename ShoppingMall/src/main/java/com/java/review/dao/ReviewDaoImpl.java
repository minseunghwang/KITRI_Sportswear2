package com.java.review.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.review.dto.ReviewDto;


@Component
public class ReviewDaoImpl implements ReviewDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int selectNum() {
		return 0;
	}

	@Override
	public int selectP_Num(int r_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(ReviewDto review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReviewDto select(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ReviewDto> selectByP_Num(int pnum) {
		return sqlSessionTemplate.selectList("pNum_Review",pnum);
	}

	@Override
	public List<ReviewDto> selectReviewInProductByPageNum(int p_num, int page) {
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("p_num", p_num);
		int start = (page-1) * 3 +1;
		int end = page * 3;
		hmap.put("start", start);
		hmap.put("end", end);
		return sqlSessionTemplate.selectList("ReviewInProduct",hmap);
	}

	@Override
	public void update(ReviewDto notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ReviewDto> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReviewDto> myselectAll(String m_id, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countallmine(String m_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countreviewByP_Num(int p_num) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
