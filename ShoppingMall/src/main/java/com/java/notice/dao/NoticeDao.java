package com.java.notice.dao;

import java.util.ArrayList;
import java.util.List;

import com.java.notice.dto.NoticeDto;

public interface NoticeDao {

	public int noticeSelectNum();

	public int noticeInsert(NoticeDto noticeDto);

	public NoticeDto noticeSelect(int num);

	public void noticeUpdate(NoticeDto noticeDto);

	public void noticeDelete(int num);

	public List<NoticeDto> noticeList(int startRow, int endRow);
	
	public int noticeUpdateViewCount(NoticeDto noticeDto);

	public int countallmine();

	public ArrayList<NoticeDto> selectNoticeByPageNum(int page);
	public List<NoticeDto> selectNoticeheader();
	
	public NoticeDto noticeSelectNum(int num);

}
