package com.java.notice.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.notice.dto.NoticeDto;

@Component
public class NoticeDaoImpl implements NoticeDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int noticeSelectNum() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("notice_update_number");
	}

	@Override
	public int noticeInsert(NoticeDto noticeDto) {
		return sqlSessionTemplate.insert("notice_insert",noticeDto);
	}

	@Override
	public NoticeDto noticeSelect(int num) {
		sqlSessionTemplate.update("notice_view",num);
		return sqlSessionTemplate.selectOne("notice_read",num);
	}

	@Override
	public void noticeUpdate(NoticeDto noticeDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void noticeDelete(int num) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<NoticeDto> noticeList(int startRow, int endRow) {
		Map<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		return sqlSessionTemplate.selectList("notice_list",hMap);
	}

	@Override
	public int noticeUpdateViewCount(NoticeDto noticeDto) {
		return sqlSessionTemplate.update("noticeUpdateViewCount");
		
	}

	@Override
	public int countallmine() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("countallmine");
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

	@Override
	public NoticeDto noticeSelectNum(int num) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("notice_read",num);
	}


}
