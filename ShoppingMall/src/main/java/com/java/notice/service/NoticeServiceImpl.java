package com.java.notice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.notice.dao.NoticeDao;
import com.java.notice.dto.NoticeDto;

@Component
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public void add(NoticeDto notice) {
		// TODO Auto-generated method stub
		noticeDao.insert(notice);
	}

	@Override
	public NoticeDto getNotice(int num) {
		// TODO Auto-generated method stub
		return noticeDao.select(num);
	}

	@Override
	public void editNotice(NoticeDto notice) {
		// TODO Auto-generated method stub
		noticeDao.update(notice);
	}

	@Override
	public void delNotice(int num) {
		// TODO Auto-generated method stub
		noticeDao.delete(num);
	}

	/*
	 * 시퀀스 사용안 할 때 num 생성하는 함수
	 * 
	 * @Override public int makeNum() { // TODO Auto-generated method stub return
	 * dao.selectNum(); }
	 */

	@Override
	public ArrayList<NoticeDto> getNoticeAll() {
		// TODO Auto-generated method stub
		return noticeDao.selectAll();
	}

	@Override
	public void updateViewCount(NoticeDto notice) {
		// TODO Auto-generated method stub
		noticeDao.updateViewCount(notice);
	}

	@Override
	public int getcountMine() {
		// TODO Auto-generated method stub
		return noticeDao.countallmine();
	}

	@Override
	public ArrayList<NoticeDto> getNoticeByPageNum(int page) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeByPageNum(page);
	}

	@Override
	public List<NoticeDto> getNoticeheader(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		List<NoticeDto> listnotices = noticeDao.selectNoticeheader();
		return listnotices;
	}
}
