package com.java.notice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java.notice.dto.NoticeDto;

public interface NoticeDao {


	public int noticeInsert(NoticeDto noticeDto);

	public NoticeDto noticeSelect(int num);

	public int noticeUpdate(NoticeDto noticeDto);

	public int noticeDelete(Map<String, Object> hmap);

	public List<NoticeDto> noticeList(int startRow, int endRow);
	
	public int noticeUpdateViewCount(NoticeDto noticeDto);

	public int countallmine();

	public ArrayList<NoticeDto> selectNoticeByPageNum(int page);
	public List<NoticeDto> selectNoticeheader();
	
	public NoticeDto noticeSelectNum(int num);

}
