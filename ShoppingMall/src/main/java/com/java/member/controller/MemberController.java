package com.java.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.member.dto.MemberDto;
import com.java.member.service.MemberService;

@Component
@Controller
public class MemberController {

	
	@Autowired
	private MemberService memberService;
	
	//로그인관련 메소드	
	@RequestMapping(value="/member/login.do")
	public ModelAndView memberLogin(HttpServletRequest request, HttpServletResponse response) {		
		return new ModelAndView("member/login");
	}
	
	@RequestMapping(value="/member/loginOk.do")
	public ModelAndView memberLoginOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberLoginOk(mav);
		return mav;
	}
	
	@RequestMapping(value="/member/logout.do")
	public ModelAndView memberLogout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberLogout(mav);
		return mav;
	}
	
	@RequestMapping(value="/member/join.do")
	public ModelAndView memberJoin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/signup");
	}
	
	@RequestMapping(value="/member/joinOk.do")
	public ModelAndView memberJoinOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberJoinOk(mav);
		return mav;
	}
	
	@RequestMapping(value="/member/searchId.do")
	public ModelAndView memberSearchId(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/member/searchId");
	}

	@RequestMapping(value="/member/searchPwd.do")
	public ModelAndView memberSearchPwd(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("/member/searchPwd");
	}
	
	@RequestMapping(value="/member/getId.do")
	public ModelAndView memberGetId(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberGetId(mav);
		return mav; 
	}
	
	@RequestMapping(value="/member/getPwd.do")
	public ModelAndView memberGetPwd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberGetPwd(mav);
		return mav; 
	}
	
	@RequestMapping(value="/member/idCheck.do")
	public ModelAndView memberIdCheck(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberIdCheck(mav);
		return mav;
	}
	
	
	//마이페이지
	@RequestMapping(value="/member/myPage.do")
	public ModelAndView memberMypage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberMyPage(mav);
		return mav;
	}

	@RequestMapping(value="/member/editPage.do")
	public ModelAndView memberEditPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberEditPage(mav);
		return mav;
	}
	
	@RequestMapping(value="/member/editOk.do")
	public ModelAndView memberEditOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberEditOk(mav);
		return mav;
		
	}
	
	@RequestMapping(value="/member/delete.do")
	public ModelAndView memberDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		memberService.memberDelete(mav);
		return mav;
	}
	

	


}
