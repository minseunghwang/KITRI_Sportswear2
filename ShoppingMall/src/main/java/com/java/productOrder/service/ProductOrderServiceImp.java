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
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		int o_state = Integer.parseInt(request.getParameter("o_state"));
		Map<String, Object> hmap= new HashMap<String, Object>();
		System.out.println(id);
		hmap.put("id", id);
		hmap.put("o_state",o_state);
		List<ProductOrderVO> list = productOrderDao.productOrderInquiry(hmap);
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

}
