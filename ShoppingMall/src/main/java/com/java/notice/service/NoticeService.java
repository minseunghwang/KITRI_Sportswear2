package com.java.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.java.notice.dto.NoticeDto;


public interface NoticeService {
	void add(NoticeDto notice);

	NoticeDto  getNotice(int num);

	void editNotice(NoticeDto notice);

	void delNotice(int num);

	ArrayList<NoticeDto> getNoticeAll();

	void updateViewCount(NoticeDto notice);

	int getcountMine();
	ArrayList<NoticeDto> getNoticeByPageNum(int page);
	List<NoticeDto> getNoticeheader(ModelAndView mav);

}
