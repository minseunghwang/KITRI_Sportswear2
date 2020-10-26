package com.java.productOrder.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.common.OrderInfoVO;
import com.java.common.PaginationVO;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;
import com.java.product.dao.ProductDao;
import com.java.product.dto.ProductDto;
import com.java.productOrder.dao.ProductOrderDao;
import com.java.productOrder.dto.ProductOrderDto;
import com.java.productOrder.dto.ProductOrderVO;

@Component
public class ProductOrderServiceImp implements ProductOrderService {

	@Autowired
	private ProductOrderDao productOrderDao;

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public void productOrderMyCart(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		int o_state = Integer.parseInt(request.getParameter("o_state"));
		Map<String, Object> hmap= new HashMap<String, Object>();
		System.out.println(id);
		hmap.put("id", id);
		hmap.put("o_state",o_state);
		List<ProductOrderVO> list = productOrderDao.productOrderMyCart(hmap);
		mav.addObject("o_state", o_state);
		mav.addObject("list", list);
		mav.setViewName("/mypage/myCart");
	}

	@Override
	public void productOrderInquiry(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int page = Integer.parseInt(request.getParameter("page"));
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		int o_state = Integer.parseInt(request.getParameter("o_state"));
		Map<String, Object> hmap= new HashMap<String, Object>();
		hmap.put("id", id);
		hmap.put("o_state",o_state);
		List<ProductOrderVO> list = productOrderDao.productOrderInquiry(hmap);
		
//		List<Integer> ctnlist =  productOrderDao.productOrdergetctnrow(hmap);
		
		System.out.println(list);
		
		PaginationVO pn = new PaginationVO();
		
		// 페이징 처리
		pn.setPage(page);					// 현재 페이지
		pn.setCountList(4);					// 한 화면에 보여질 상품 수
		pn.setCountPage(3);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>

		pn.setTotalCount(productOrderDao.orderList(id, o_state).size());	// 전체 상품 수 ex) 35개

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
		
		mav.addObject("list", list);
		mav.setViewName("/mypage/neworderlist");
	}

	@Override
	public void productOrderAddCart(ModelAndView mav, HttpServletRequest request) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletResponse response = (HttpServletResponse) map.get("response");

		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		
		int p_num = Integer.parseInt(request.getParameter("productNum"));
		String size = request.getParameter("size");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		ProductDto p = productDao.select(p_num);
		ProductOrderDto po = new ProductOrderDto();

		Map resultMap = new HashMap();

		// product_size �뀒�씠釉붿쓽 �옱怨� �솗�씤 ( return 媛믪씠 -1 �씠硫� �븘吏� �엯怨좏븯吏� �븡�� �긽�깭 )
		int findProductQuantity = productOrderDao.findProductQuantity(p_num, size);
		int findCartNum = productOrderDao.findProductInCartNum(id, p_num, size);

		if (findProductQuantity >= quantity) { // 재고 >= 주문수량 :: 주문 가능

			if (0 == findCartNum) { // 장바구니에 해당삼품이 존재하지 않음 :: 장바구니 추가

				po.setNum(productOrderDao.makeProductOrderNum());
				po.setP_num(p_num);
				po.setO_quantity(quantity);
				po.setTotal_price(p.getPrice() * quantity);
				po.setM_id(id);
				po.setO_state(0); // o_state 媛�: 0 == �옣諛붽뎄�땲, 1 == 寃곗젣�셿猷�
				po.setD_state(0); // d_state 媛�: 0 == 諛곗넚 �쟾, 1 == 諛곗넚 �셿猷�
				po.setP_size(size);
				po.setProd_name(p.getName());
				po.setProd_img(p.getImg());
				po.setR_state(0); // r_state 값: 0 == 리뷰작성 전, 1 == 리뷰 작성 완료
//	        		po.setCode_num(service.makeProductOrderCodeNum());	// TODO CodeNum 정확한 용도 확인 후 수정
				System.out.println(po);
				productOrderDao.productOrderAdd(po);
				mav.addObject("ans", "AddCart Success");
			} else { // 장바구니에 해당상품 존재
				mav.addObject("ans", "Already Existed");
			}
		} else { // 재고 < 주문수량 :: 주문 불가
			mav.addObject("ans", "Sold Out");
		}
	}

	@Override
	public void productOrderList(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int o_state = Integer.parseInt(request.getParameter("o_state"));
		HttpSession session = request.getSession(false);
		String m_id = (String)session.getAttribute("id");
		
		List<ProductOrderVO> list = productOrderDao.orderList(m_id, o_state);

		
		for(ProductOrderVO o:list) {
			ProductDto p = productDao.select(o.getP_num());
			
			o.setProd_name(p.getName());
			o.setProd_img(p.getImg());
		}
		
		String path=null;
		if(o_state==1) {
			path="/mypage/orderlist";
		}else if(o_state==0){
			path="/mypage/myCart";
		}
		
		mav.addObject("list",list);
		mav.addObject("o_state",o_state);
		mav.setViewName(path);
	}

	@Override
	public void productOrderDelete(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		productOrderDao.delOrder(num);
		
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		int o_state = Integer.parseInt(request.getParameter("o_state"));
		Map<String, Object> hmap= new HashMap<String, Object>();
		System.out.println(id);
		hmap.put("id", id);
		hmap.put("o_state",o_state);
		List<ProductOrderVO> list = productOrderDao.productOrderMyCart(hmap);
		
		mav.addObject("o_state", 0);
		mav.addObject("list",list);
		mav.setViewName("/mypage/myCart");
	}
	@Override
	public void productOrderPaymentPage(ModelAndView mav) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map= mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session =request.getSession(false);
		ProductOrderVO po=new ProductOrderVO();
		ArrayList<ProductOrderVO> list = new ArrayList<ProductOrderVO>();
		
		int productNum=Integer.parseInt(request.getParameter("productNum"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String size=request.getParameter("size");
		String orderName="주문번호: "+request.getParameter("productNum");
		int order_totalQuantity = 0;
		int order_totalPrice = 0;
		
		String id = (String)session.getAttribute("id");
		MemberDto memberDto=memberDao.memberGetInfo(id);
		ProductDto productDto=productDao.select(productNum);
		
		po.setNum(productOrderDao.makeProductOrderNum());
		po.setP_num(productNum);
		po.setO_quantity(quantity);
		po.setTotal_price(productDto.getPrice()*quantity);
		po.setM_id(id);
		
		po.setO_state(2);	// o_state 값: 0 == 장바구니, 1 == 결제완료, 2 == 구매하기취소
		po.setD_state(0);	// d_state 값: 0 == 배송 전, 1 == 배송 완료
		po.setP_size(size);
		po.setProd_name(productDto.getName());
		po.setProd_img(productDto.getImg());
		po.setR_state(0);	// r_state 값: 0 == 리뷰작성 전, 1 == 리뷰 작성 완료
		order_totalPrice += po.getTotal_price();
		order_totalQuantity += po.getO_quantity();
		
		
		System.out.println(po.toString());
		list.add(po);
		System.out.println(id);
		System.out.println(productNum);
		
		
		mav.addObject("order_totalPrice", order_totalPrice);
		mav.addObject("order_totalQuantity", order_totalQuantity);
		mav.addObject("orderName",orderName);
		mav.addObject("list",list);
		mav.addObject("member",memberDto);
		mav.setViewName("/mypage/cartOrderPage");
		
	}

	@Override
	public void productOrderPaymentInfo(ModelAndView mav) {
		Map<String, Object> map= mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session =request.getSession(false);
		String m_id = (String)session.getAttribute("id");
        String code_num = request.getParameter("code_num");
        
        OrderInfoVO orderinfo = productOrderDao.getPaymentInfo(code_num);
        System.out.println(orderinfo);
        
        mav.addObject("orderinfo",orderinfo);
        mav.setViewName("/mypage/paymentInfoForm");
	}

}
