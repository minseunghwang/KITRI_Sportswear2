package com.java.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.java.notice.dto.NoticeDto;

public interface NoticeService {

	public void noticeWrite(ModelAndView mav);
	//void add(NoticeVO notice);
	
	public void noticeWriteOk(ModelAndView mav);
	
	public void noticeRead(ModelAndView mav);
	//NoticeVO  getNotice(int num);

	public void noticeUpdate(ModelAndView mav);
	//void editNotice(NoticeVO notice);

	public void noticeUpdateOk(ModelAndView mav);
	
	public void noticeDelete(ModelAndView mav);
	//void delNotice(int num);

	public void noticeDeleteOk(ModelAndView mav);
	
	public void noticeList(ModelAndView mav);
	//public ArrayList<NoticeDto> getNoticeAll();
	//ArrayList<NoticeVO> getNoticeAll();

	// int makeNum();
	
	public void noticeUpdateViewCount(ModelAndView mav);
	//void updateViewCount(NoticeVO notice);

	public int getcountMine();
	//int getcountMine();
	
	public ArrayList<NoticeDto> getNoticeByPageNum(int page);
	//ArrayList<NoticeVO> getNoticeByPageNum(int page);
	
	public List<NoticeDto> getNoticeheader(ModelAndView mav);
	//ArrayList<NoticeVO> getNoticeheader();
	
}
