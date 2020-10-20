package com.java.notice.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.notice.dto.NoticeDto;

@Component
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int selectNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(NoticeDto notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NoticeDto select(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(NoticeDto notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<NoticeDto> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateViewCount(NoticeDto notice) {
		// TODO Auto-generated method stub
	}

	@Override
	public int countallmine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<NoticeDto> selectNoticeByPageNum(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeDto> selectNoticeheader() {
		return sqlSessionTemplate.selectList("notice_header");
	}
	
	
}