package com.java.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;
import com.java.product.dao.ProductDao;
import com.java.product.dto.ProductDto;
import com.java.productOrder.dao.ProductOrderDao;
import com.java.productOrder.dto.ProductOrderVO;


@Component
public class MemberServiceImp implements MemberService {

	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private ProductOrderDao productorderDao;
	
	@Autowired
	private ProductDao productDao;

	@Override
	public void memberLoginOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		Map<String, String> hmap=new HashMap<String, String>();
		HttpSession session=request.getSession();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		hmap.put("id",id);
		hmap.put("pwd",pwd);
		
		
		String value=memberDao.memberLogin(hmap);
		//���� ���� 
		session.setAttribute("id", id);
		session.setAttribute("pwd", pwd);
		session.setAttribute("memberType", value);
				
		mav.addObject("type",value);
		mav.addObject("id",hmap.get("id"));
		mav.setViewName("member/loginOk");
		
	}

	@Override
	public void memberLogout(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		HttpSession session=request.getSession(false);
		session.invalidate();
		mav.setViewName("member/logout");

	}

	@Override
	public void memberJoinOk(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		Map<String, Object> hmap=new HashMap<String, Object>();
		
		int check=0;
		String id = request.getParameter("id"); //기본키
        String pwd=request.getParameter("pwd");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String addr=request.getParameter("addr");
        int type=1;//일반 회원
        int point=2000;
        
        
        if(id==null|| id.equals("")|| id.equals("null")) {
        	check=0;
        }else if(pwd==null|| pwd.equals("")||pwd.equals("null")) {
        	check=0;
        }else if(name==null|| name.equals("")|| name.equals("null")) {
        	check=0;
        }else if(email==null|| email.equals("")|| email.equals("null")) {
        	check=0;
        }else if(addr==null|| addr.equals("")|| addr.equals("null")) {
        	check=0;
        }else {
	        hmap.put("id",id);
	        hmap.put("pwd",pwd);
		    hmap.put("name",name);
		    hmap.put("email",email);
		    hmap.put("addr",addr);
		    hmap.put("type",type);
		    hmap.put("point",point);    
		    check=memberDao.memberJoin(hmap);
        }
        mav.addObject("check",check);
        mav.setViewName("member/signupOk");
         
        
        
	}

	@Override
	public void memberGetId(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		Map<String, String> hmap=new HashMap<String, String>();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		hmap.put("name", name);
		hmap.put("email",email);
		String id =memberDao.memberGetId(hmap);
		
		mav.addObject("name",name);
		mav.addObject("email",email);
		mav.addObject("id",id);
		
		mav.setViewName("/member/getId");
		
		
	}

	@Override
	public void memberGetPwd(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		Map<String, String> hmap=new HashMap<String, String>();
		
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		
		hmap.put("id", id);
		hmap.put("email",email);
		String pwd = memberDao.memberGetPwd(hmap);
		
		
		mav.addObject("id",id);
		mav.addObject("email",email);
		mav.addObject("pwd",pwd);
		
		mav.setViewName("/member/getPwd");
	
	}

	@Override
	public void memberIdCheck(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		Map<String, String> hmap=new HashMap<String, String>();
		String id=request.getParameter("id");
		
		hmap.put("id", id);
		int check=memberDao.memberIdCheck(hmap);
		
		mav.addObject("id",id);
		mav.addObject("check", check);
		mav.setViewName("/member/idCheck");
		
	}	
	
	
	@Override
	public void memberMyPage(ModelAndView mav) {
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		Map<String, String> hmap=new HashMap<String, String>();
		HttpSession session=request.getSession(false);
		String id=(String) session.getAttribute("id");
		
		hmap.put("id", id);
		String point=memberDao.memberGetPoint(hmap);
		
		List<ProductOrderVO> recentList = productorderDao.getRecentOrderList(id);
		
		for(ProductOrderVO o:recentList) {
			ProductDto p = productDao.select(o.getMax_p_num());
			o.setProd_name(p.getName());
			o.setProd_img(p.getImg());
			o.setPriceView(o.getSum_total_price());
		}
		
		mav.addObject("list", recentList);
		mav.addObject("point",point);
		mav.setViewName("/mypage/myInfo");
		
	}

	@Override
	public void memberEditPage(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session=request.getSession(false);
		String id=(String) session.getAttribute("id");
		MemberDto dto=memberDao.memberGetInfo(id);
		
		mav.addObject("memberDto",dto);
		mav.setViewName("/mypage/edit");
		
	}
	
	@Override
	public void memberEditOk(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map =mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		Map<String, Object> hmap=new HashMap<String, Object>();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String addr=request.getParameter("addr");
		
		hmap.put("id", id);
		hmap.put("pwd", pwd);
		hmap.put("email", email);
		hmap.put("addr", addr);
		
		memberDao.memberUpdateInfo(hmap);
		
		
		mav.setViewName("/main/main");
		
		
	}

	@Override
	public void memberDelete(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		HttpSession session=request.getSession(false);
		String id=(String) session.getAttribute("id");
		memberDao.memberDelete(id);
		
		session.invalidate();
		mav.setViewName("/main/main");
		
	}
}
