package com.java.productOrder.service;

import java.io.IOException;
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

	@Override
	public void productOrderMyCart(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int o_state = Integer.parseInt(request.getParameter("o_state"));
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		List<ProductOrderVO> list = productOrderDao.productOrderMyCart(id);
		mav.addObject("o_state", o_state);
		mav.addObject("list", list);
		mav.setViewName("/mypage/myCart");
	}

	@Override
	public void productOrderInquiry(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		List<ProductOrderVO> list = productOrderDao.productOrderInquiry(id);
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

		// product_size 테이블의 재고 확인 ( return 값이 -1 이면 아직 입고하지 않은 상태 )
		int findProductQuantity = productOrderDao.findProductQuantity(p_num, size);
		int findCartNum = productOrderDao.findProductInCartNum(id, p_num, size);
		
		if (findProductQuantity >= quantity) { // 재고 >= 주문수량 :: 주문 가능

			if (0 == findCartNum) { // 장바구니에 해당삼품이 존재하지 않음 :: 장바구니 추가
				po.setNum(productOrderDao.makeProductOrderNum());
				po.setP_num(p_num);
				po.setO_quantity(quantity);
				po.setTotal_price(p.getPrice() * quantity);
				po.setM_id(id);
				po.setO_state(0); // o_state 값: 0 == 장바구니, 1 == 결제완료
				po.setD_state(0); // d_state 값: 0 == 배송 전, 1 == 배송 완료
				po.setP_size(size);
				po.setProd_name(p.getName());
				po.setProd_img(p.getImg());
				po.setR_state(0); // r_state 값: 0 == 리뷰작성 전, 1 == 리뷰 작성 완료
//	        		po.setCode_num(service.makeProductOrderCodeNum());	// TODO CodeNum 정확한 용도 확인 후 수정
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
		productOrderDao.delOrder(num);
		
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		List<ProductOrderVO> list = productOrderDao.productOrderInquiry(id);
		
		mav.addObject("o_state", 0);
		mav.addObject("list",list);
		mav.setViewName("/mypage/myCart");
	}
}
