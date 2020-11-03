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
import com.java.common.ProductSizeVO;
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
		int page = Integer.parseInt(request.getParameter("page"));
		Map<String, Object> hmap= new HashMap<String, Object>();
		hmap.put("id", id);
		hmap.put("o_state",o_state);
		List<ProductOrderVO> list = productOrderDao.productOrderMyCart(hmap);
		
		for(ProductOrderVO o:list) {
			o.setPriceView(o.getTotal_price());
		}
		
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
		
		request.setAttribute("pn", pn);
		
		
		mav.addObject("o_state", o_state);
		mav.addObject("list", list);
		mav.setViewName("/mypage/myCart");
	}

	@Override
	public void productOrderInquiry(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int page = Integer.parseInt(request.getParameter("page"));
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		int o_state = Integer.parseInt(request.getParameter("o_state"));
		Map<String, Object> hmap= new HashMap<String, Object>();
		hmap.put("id", id);
		hmap.put("o_state",o_state);
		
		int startRange = (page - 1) * 4 + 1;
		int endRange = page * 4;
		
		hmap.put("startRange", startRange);
		hmap.put("endRange", endRange);
		
		List<ProductOrderVO> list = productOrderDao.productOrderInquiry(hmap);
		
		
		for(ProductOrderVO o:list) {
			ProductDto p = productDao.select(o.getMax_p_num());
			System.out.println("========");
			System.out.println(p);
			System.out.println(o);
			System.out.println("========");
			o.setPriceView(o.getSum_total_price());
			o.setProd_name(p.getName());
			o.setProd_img(p.getImg());
		}
		
		
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
		ProductOrderVO po = new ProductOrderVO();

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
		if(m_id == null || m_id.length() == 0) {
			m_id = request.getParameter("u_id");
		}
		
		// 결제하고나면 세션이 없어져서 u_id를 못받아오는 현상이 있군
		
		System.out.println(m_id + " @@@@ " + o_state);
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
		int o_state = Integer.parseInt(request.getParameter("o_state"));
		Map<String, Object> hmap= new HashMap<String, Object>();
		hmap.put("id", id);
		hmap.put("o_state",o_state);
		List<ProductOrderVO> list = productOrderDao.productOrderMyCart(hmap);
		
		mav.addObject("o_state", 0);
		mav.addObject("list",list);
		mav.setViewName("/mypage/myCart");
	}
	
	@Override
	public void productOrderPaymentPage(ModelAndView mav) {
		Map<String, Object> map= mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session =request.getSession(false);
		
		
		String id = (String)session.getAttribute("id");
		MemberDto memberDto=memberDao.memberGetInfo(id);
		
		ArrayList<ProductOrderVO> list = new ArrayList<ProductOrderVO>();
		
		int productNum=Integer.parseInt(request.getParameter("productNum"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String size=request.getParameter("size");
		String orderName="주문번호 : "+request.getParameter("productNum");
		int order_totalQuantity = 0;
		int order_totalPrice = 0;
		
		ProductOrderVO po=new ProductOrderVO();
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
		
		productOrderDao.productOrderAdd(po);
		
		list.add(po);
		System.out.println(order_totalPrice);
		System.out.println(order_totalQuantity);
		System.out.println(orderName);
		System.out.println(list);
		System.out.println(memberDto);
		
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

	@Override
	public void productOrderDetail(ModelAndView mav) {
		Map<String, Object> map= mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		String code_num = request.getParameter("code_num");
		HttpSession session = request.getSession(false);
		String m_id = (String)session.getAttribute("id");
		List<ProductOrderVO> list = productOrderDao.orderListByCNum(m_id, code_num);

		for(ProductOrderVO o:list) {
			ProductDto p = productDao.select(o.getP_num());
			
			o.setProd_name(p.getName());
			o.setProd_img(p.getImg());
			o.setPriceView(o.getTotal_price());
		}
		
		mav.addObject("list", list);
		mav.addObject("code_num", code_num);
		mav.setViewName("/mypage/orderlist");
	}

	@Override
	public void productOrderDataSave(ModelAndView mav) {
		Map<String, Object> map= mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		
		String oi_name = request.getParameter("oi_name");
		String oi_phone = request.getParameter("oi_phone");

		String code_num = request.getParameter("code_num");
		
		String oi_howPay = request.getParameter("oi_howPay");
		int oi_totalPrice = Integer.parseInt(request.getParameter("oi_totalPrice"));
		String oi_status = request.getParameter("oi_status");
		String order_name = request.getParameter("order_name");
		String oi_email = request.getParameter("oi_email");
		String oi_addr_full = request.getParameter("oi_addr_full");
		String oi_addr_zipNo = request.getParameter("oi_addr_zipNo");
		String oi_addr_roadAddrPart1 = request.getParameter("oi_addr_roadAddrPart1");
		String oi_addr_roadAddrPart2 = request.getParameter("oi_addr_roadAddrPart2");
		String oi_addr_addrDetail = request.getParameter("oi_addr_addrDetail");
		String oi_deliMessage = request.getParameter("oi_deliMessage");
		int oi_originTotalPrice = Integer.parseInt(request.getParameter("oi_originTotalPrice"));
		int oi_usePoint = Integer.parseInt(request.getParameter("oi_usePoint"));
		String add_name = request.getParameter("add_name");
		String add_phone1 = request.getParameter("add_phone1");
		String add_phone2 = request.getParameter("add_phone2");
		String add_email = request.getParameter("add_email");
		String add_addr_full = request.getParameter("add_addr_full");
		String add_addr_zipNo = request.getParameter("add_addr_zipNo");
		String add_addr_roadAddrPart1 = request.getParameter("add_addr_roadAddrPart1");
		String add_addr_roadAddrPart2 = request.getParameter("add_addr_roadAddrPart2");
		String add_addr_addrDetail = request.getParameter("add_addr_addrDetail");
		
		String [] selection = request.getParameterValues("oi_productOrderNum[]");
		
		System.out.println(oi_name + " , " + oi_email + " , " + add_phone1);
		
		for (String sel:selection) {
			int num = Integer.parseInt(sel)+1;		// 이상하게 짜놔서 일단 물리적으로 1 더하게 해놓음
			ProductOrderVO po = productOrderDao.getOrder(num);
			
			po.setCode_num(code_num);		
			po.setO_state(1);
			productOrderDao.updateCode_num(po);
			
			//재고변경
			ProductSizeVO ps = new ProductSizeVO();
			int remainingQuantity = productDao.checkQuantity(po.getP_num(), po.getP_size());
			ps.setP_num(po.getP_num());
			ps.setPsize(po.getP_size());
			ps.setQuantity(remainingQuantity - po.getO_quantity());
			productDao.addQuantity(ps);
			
			//Record 카운트 up
			ProductDto productvo = productDao.select(po.getP_num());
			int currentRecord = productvo.getRecord();
			productvo.setRecord(currentRecord + po.getO_quantity());
			productDao.recordup(productvo);
		}
		
		//OrderInfo 테이블에 데이터 추가
		OrderInfoVO oivo = new OrderInfoVO();

		oivo.setNum(productOrderDao.selectOrderInfoNum());
		oivo.setOi_id(id);
		oivo.setOi_name(oi_name);
		oivo.setOi_phone(oi_phone);
		oivo.setOi_email(oi_email);
		oivo.setOi_addr_full(oi_addr_full);
		oivo.setOi_addr_zipno(oi_addr_zipNo);
		oivo.setOi_addr_roadAddrPart1(oi_addr_roadAddrPart1);
		oivo.setOi_addr_roadAddrPart2(oi_addr_roadAddrPart2);
		oivo.setOi_addr_addrDetail(oi_addr_addrDetail);
		oivo.setOi_deliMessage(oi_deliMessage);
		oivo.setOi_howPay(oi_howPay);
		oivo.setOi_usepoint(oi_usePoint);
		oivo.setOi_originTotalPrice(oi_originTotalPrice);
		oivo.setOi_totalPrice(oi_totalPrice);
		oivo.setOi_code_num(code_num);
		oivo.setAdd_name(add_name);
		oivo.setAdd_phone1(add_phone1);
		oivo.setAdd_phone2(add_phone2);
		oivo.setAdd_email(add_email);
		oivo.setAdd_addr_full(add_addr_full);
		oivo.setAdd_addr_zipNo(add_addr_zipNo);
		oivo.setAdd_addr_roadAddrPart1(add_addr_roadAddrPart1);
		oivo.setAdd_addr_roadAddrPart2(add_addr_roadAddrPart2);
		oivo.setAdd_addr_addrDetail(add_addr_addrDetail);
		System.out.println(oivo.toString());
		
		// 이거보면 oi_id 즉 로그인된 id가 없음 -> 세션이 또 날라가있는상태. 결제후에 세션날라가는거 해결해야할듯

		productOrderDao.addOrderInfo(oivo);
		
	}
}
