package com.java.review.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.java.review.service.ReviewService;

@Component
@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="/review/myReviewList.do")
	public ModelAndView myReviewList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav =new ModelAndView();
		mav.addObject("request",request);
		reviewService.reviewMyList(mav);
		return mav;
	}
	
	@RequestMapping(value="/review/AddReview.do")
	public ModelAndView AddReview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav =new ModelAndView();
		mav.addObject("request",request);
		reviewService.AddReview(mav);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/review/CreateReview.do")
	public ModelAndView CreateReview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav =new ModelAndView("jsonView");
		reviewService.CreateReview(mav,request);
		return mav;
	}
	
	
	@RequestMapping(value="/review/EachReviewPopup.do")
	public ModelAndView UpdateReview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav =new ModelAndView();
		mav.addObject("request",request);
		reviewService.UpdateReview(mav);
		return mav;
	}
}
