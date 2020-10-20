package com.java.notice.dao;

import java.util.ArrayList;
import java.util.List;

import com.java.notice.dto.NoticeDto;

public interface NoticeDao {
	int selectNum();

	void insert(NoticeDto notice);

	NoticeDto select(int num);

	void update(NoticeDto notice);

	void delete(int num);

	ArrayList<NoticeDto> selectAll();
	
	void updateViewCount(NoticeDto notice);

	int countallmine();

	ArrayList<NoticeDto> selectNoticeByPageNum(int page);
	List<NoticeDto> selectNoticeheader();
}
