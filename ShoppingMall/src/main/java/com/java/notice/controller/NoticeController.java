package com.java.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.notice.dto.NoticeDto;
import com.java.notice.service.NoticeService;

@Component
@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/notice/addForm.do")
	public ModelAndView noticeWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		noticeService.noticeWrite(mav);
		return mav;
	}
	
	@RequestMapping(value="/notice/writeOk.do")
	public ModelAndView noticeWriteOk(HttpServletRequest request, HttpServletResponse response, NoticeDto noticeDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		mav.addObject("noticeDto",noticeDto);
		noticeService.noticeWriteOk(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/notice/list.do")
	public ModelAndView noticeList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		noticeService.noticeList(mav);
		return mav;
		//return new ModelAndView("notice/list");
	}
	
	@RequestMapping(value="/notice/search.do")
	public ModelAndView noticeRead(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		noticeService.noticeRead(mav);
		return mav;
	}
	
	
	
//	@RequestMapping(value="/notice/delete.do")
//	public ModelAndView noticeDelete(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("request",request);
//		noticeService.noticeDelete(mav);;
//		return mav;
//	}
	@RequestMapping(value="/notice/deleteOk.do")
	public ModelAndView noticeDeleteOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		noticeService.noticeDeleteOk(mav);
		return mav;
	}
	@RequestMapping(value="/notice/update.do")
	public ModelAndView noticeUpdate(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		noticeService.noticeUpdate(mav);
		return mav;
	}
	@RequestMapping(value="/notice/UpdateOk.do")
	public ModelAndView noticeUpdateOk(HttpServletRequest request, HttpServletResponse response, NoticeDto noticeDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		mav.addObject("noticeDto",noticeDto);
		noticeService.noticeUpdateOk(mav);
		return mav;
	}
	
}
