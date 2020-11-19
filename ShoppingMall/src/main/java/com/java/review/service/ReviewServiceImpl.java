package com.java.review.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.java.common.PaginationVO;
import com.java.productOrder.dao.ProductOrderDao;
import com.java.productOrder.dto.ProductOrderVO;
import com.java.review.dao.ReviewDao;
import com.java.review.dto.ReviewDto;


@Component
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ProductOrderDao productorderDao;

	@Override
	public void add(ReviewDto review) {
		reviewDao.insert(review);
	}

	@Override
	public ReviewDto getReview(int num) {
		return reviewDao.select(num);
	}
	
	@Override
	public List<ReviewDto> getReviewByProductNum(int p_num) {
		return reviewDao.selectByP_Num(p_num);
	}
	
	@Override
	public List<ReviewDto> getReviewInProductByPageNum(int p_num, int page) {
		return reviewDao.selectReviewInProductByPageNum(p_num, page);
	}


	@Override
	public void delReview(int num) {
		reviewDao.delete(num);
	}

	@Override
	public ArrayList<ReviewDto> getReviewAll() {
		return reviewDao.selectAll();
	}

	@Override
	public int makeNum() {
		return reviewDao.selectNum();
	}

	@Override
	public ArrayList<ReviewDto> getMyReviewAll(String m_id, int page) {
		return reviewDao.myselectAll(m_id, page);
	}

	@Override
	public int getSelectedP_num(int r_num) {
		return reviewDao.selectP_Num(r_num);
	}

	@Override
	public int getcountByP_Num(int p_num) {
		return reviewDao.countreviewByP_Num(p_num);
	}

	@Override
	public void reviewMyList(ModelAndView mav) {
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session = request.getSession(false);
		String m_id = (String)session.getAttribute("id");
		
		int page = Integer.parseInt(request.getParameter("page"));
		List<ReviewDto> list = reviewDao.getMyReviewAll(m_id, page);
		
		PaginationVO pn = new PaginationVO();
		
		// 페이징 처리
		pn.setPage(page);					// 현재 페이지
		pn.setCountList(4);					// 한 화면에 보여질 상품 수
		pn.setCountPage(3);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>

		pn.setTotalCount(reviewDao.getcountMine(m_id));	// 전체 상품 수 ex) 35개

		pn.setTotalPage(pn.getTotalCount() / pn.getCountList());
		if(pn.getTotalCount() % pn.getCountList() > 0) {	// ex) 총 상품 35개, 한 페이지에 8개 표시 :: 4개의 페이지(8개 상품) + 1페이지(3개 상품)
			pn.setTotalPage(pn.getTotalPage() + 1);
		}
		
		if(pn.getTotalPage() < pn.getPage()) {
			pn.setPage(pn.getTotalPage());
		}
		
		pn.setStartPage((pn.getPage() - 1) / pn.getCountPage() * pn.getCountPage() + 1);
		pn.setEndPage(pn.getStartPage() + pn.getCountPage() - 1);
		
		
		/*
		 *  아래 조건이 없으면 다음과 같은 대참사가 발생
		 *  현재 4페이지에 위치하면, startPage == 4, endPage == 5 로 나와야함. << < 4 5 > >>
		 *  아래 조건이 없을 경우, endPage = 4 + 3 - 1 >> endPage == 6..    :: << < 4 5 6 > >>  
		 *  6페이지를 누르면 아무런 값도 나오지 않음
		 *  아래 조건을 넣어야 if( 6 > 5 ) 조건을 만족하여 endPage는 5가 됨
		 */
		
		if(pn.getEndPage() > pn.getTotalPage()) {
			pn.setEndPage(pn.getTotalPage());
		}
		
		mav.addObject("pn",pn);
		mav.addObject("page",page);
		mav.addObject("list",list);
		mav.setViewName("/review/myReviewList");
	}

	@Override
	public void AddReview(ModelAndView mav) {
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		int p_num = Integer.parseInt(request.getParameter("p_num"));
		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession(false);
		String m_id = (String)session.getAttribute("id");

		int page = Integer.parseInt(request.getParameter("page"));
		
		PaginationVO pn = new PaginationVO();
		
		// 페이징 처리
		pn.setPage(page);					// 현재 페이지
		pn.setCountList(4);					// 한 화면에 보여질 상품 수
		pn.setCountPage(3);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>

		pn.setTotalCount(reviewDao.getcountMine(m_id));	// 전체 상품 수 ex) 35개

		pn.setTotalPage(pn.getTotalCount() / pn.getCountList());
		if(pn.getTotalCount() % pn.getCountList() > 0) {	// ex) 총 상품 35개, 한 페이지에 8개 표시 :: 4개의 페이지(8개 상품) + 1페이지(3개 상품)
			pn.setTotalPage(pn.getTotalPage() + 1);
		}
		
		if(pn.getTotalPage() < pn.getPage()) {
			pn.setPage(pn.getTotalPage());
		}
		
		pn.setStartPage((pn.getPage() - 1) / pn.getCountPage() * pn.getCountPage() + 1);
		pn.setEndPage(pn.getStartPage() + pn.getCountPage() - 1);
		
		
		/*
		 *  아래 조건이 없으면 다음과 같은 대참사가 발생
		 *  현재 4페이지에 위치하면, startPage == 4, endPage == 5 로 나와야함. << < 4 5 > >>
		 *  아래 조건이 없을 경우, endPage = 4 + 3 - 1 >> endPage == 6..    :: << < 4 5 6 > >>  
		 *  6페이지를 누르면 아무런 값도 나오지 않음
		 *  아래 조건을 넣어야 if( 6 > 5 ) 조건을 만족하여 endPage는 5가 됨
		 */
		
		if(pn.getEndPage() > pn.getTotalPage()) {
			pn.setEndPage(pn.getTotalPage());
		}
		
		mav.addObject("pn",pn);
		mav.addObject("p_num", p_num);
		mav.addObject("num", num);
		mav.setViewName("/review/addForm");
	}

	@Override
	public void CreateReview(ModelAndView mav, HttpServletRequest request) {
		Map<String, Object> map =mav.getModelMap();
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		HttpSession session = request.getSession(false);
	    String m_id = (String) session.getAttribute("id");
	    
	    ReviewDto review = new ReviewDto();
	    
	    review.setM_id(m_id);
	    
//	    String uploadPath = "C:\\spring2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\review_img";
	    String uploadPath = "C:\\Users\\KITRI\\git\\KITRI_Sportswear2\\ShoppingMall\\src\\main\\webapp\\resources\\review_img";
	    
	    String reviewImgName = "";
	    String inputTagName = "";
	    
	    int maxSize = 1024 * 1024 * 10;
   
	    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while(iterator.hasNext()){
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false){
				review.setImg("/review_img/" + multipartFile.getOriginalFilename());
			}
			
			String saveName =multipartFile.getOriginalFilename();
			
			File saveFile = new File(uploadPath, saveName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		review.setP_num(Integer.parseInt(multipartHttpServletRequest.getParameter("p_num")));
		review.setContent(multipartHttpServletRequest.getParameter("message"));
		review.setRate(Integer.parseInt(multipartHttpServletRequest.getParameter("rate")));
		
		reviewDao.add(review);
		productorderDao.editR_State(m_id,Integer.parseInt(multipartHttpServletRequest.getParameter("num")));
		int o_num = Integer.parseInt(multipartHttpServletRequest.getParameter("num"));
		ProductOrderVO po = new ProductOrderVO();
		productorderDao.editPoint(m_id, o_num);
		
	}

	@Override
	public void UpdateReview(ModelAndView mav) {
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session = request.getSession(false);
		String m_id = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num")); 	//리뷰pk
		
		ReviewDto r = reviewDao.select(num);
		
		mav.addObject("r", r);
		mav.addObject("num", num);
		mav.setViewName("/review/updateForm");
	}

	@Override
	public void EditReview(ModelAndView mav, HttpServletRequest request2) {
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)request2;
		HttpSession session = request.getSession(false);
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		String m_id = (String)session.getAttribute("id");
		int page = Integer.parseInt(request.getParameter("page"));

		
		ReviewDto review = new ReviewDto();
		review.setM_id(m_id);
		
		int num = Integer.parseInt(multipartHttpServletRequest.getParameter("num"));
		int p_num = reviewDao.selectP_Num(num);
		review.setP_num(p_num);
		review.setNum(num);
		review.setContent(multipartHttpServletRequest.getParameter("message"));
		review.setRate(Integer.parseInt(multipartHttpServletRequest.getParameter("rate")));
		review.setR_date(review.getR_date());

	    int maxSize =1024 *1024 *10;
	    
	    String uploadPath = "C:\\Users\\KITRI\\git\\KITRI_Sportswear2\\ShoppingMall\\src\\main\\webapp\\resources\\review_img";

	    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
	    System.out.println("파일이름: " + multipartHttpServletRequest.getFileNames());
		MultipartFile multipartFile = null;
		while(iterator.hasNext()){
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false){
				if (!review.equals("/review_img/null")) {
					review.setImg("/review_img/" + multipartFile.getOriginalFilename());
				} else {
					review.setImg(review.getImg());
				}
				
				// 저장하는 부분
//				UUID uid = UUID.randomUUID();		// 이름앞에 랜덤 난수 추가할때
				String saveName =multipartFile.getOriginalFilename();
				
				File saveFile = new File(uploadPath, saveName);
				
				try {
					multipartFile.transferTo(saveFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		PaginationVO pn = new PaginationVO();
		
		// 페이징 처리
		pn.setPage(page);					// 현재 페이지
		pn.setCountList(4);					// 한 화면에 보여질 상품 수
		pn.setCountPage(3);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>

		pn.setTotalCount(reviewDao.getcountMine(m_id));	// 전체 상품 수 ex) 35개

		pn.setTotalPage(pn.getTotalCount() / pn.getCountList());
		if(pn.getTotalCount() % pn.getCountList() > 0) {	// ex) 총 상품 35개, 한 페이지에 8개 표시 :: 4개의 페이지(8개 상품) + 1페이지(3개 상품)
			pn.setTotalPage(pn.getTotalPage() + 1);
		}
		
		if(pn.getTotalPage() < pn.getPage()) {
			pn.setPage(pn.getTotalPage());
		}
		
		pn.setStartPage((pn.getPage() - 1) / pn.getCountPage() * pn.getCountPage() + 1);
		pn.setEndPage(pn.getStartPage() + pn.getCountPage() - 1);
		
		
		/*
		 *  아래 조건이 없으면 다음과 같은 대참사가 발생
		 *  현재 4페이지에 위치하면, startPage == 4, endPage == 5 로 나와야함. << < 4 5 > >>
		 *  아래 조건이 없을 경우, endPage = 4 + 3 - 1 >> endPage == 6..    :: << < 4 5 6 > >>  
		 *  6페이지를 누르면 아무런 값도 나오지 않음
		 *  아래 조건을 넣어야 if( 6 > 5 ) 조건을 만족하여 endPage는 5가 됨
		 */
		
		if(pn.getEndPage() > pn.getTotalPage()) {
			pn.setEndPage(pn.getTotalPage());
		}
				
		reviewDao.editReview(review);
		
		mav.addObject("pn",pn);
	}
}
