package com.java.notice.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.java.common.PaginationVO;
import com.java.notice.dao.NoticeDao;
import com.java.notice.dto.NoticeDto;


@Component
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public void noticeWrite(ModelAndView mav) {

		//int num =0;
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		mav.setViewName("notice/addForm");
		
	}
	
	@Override
	public void noticeWriteOk(ModelAndView mav) {
		Map<String, Object>map= mav.getModelMap();
		NoticeDto noticeDto = (NoticeDto) map.get("noticeDto");
		//MultipartHttpServletRequest request = (MultipartHttpServletRequest) map.get("request");
		//MultipartHttpServletRequest 기존에 formfied 로 들어왔는지 확인하는 작업을 안해도 된다, 
		noticeDto.setN_date(new Date());
		noticeDto.setView_count(0);
		
		//noticeSelectNum(noticeDto);
		
//		MultipartFile upFile = request.getFile("file");//file : jsp단의 이름과 같게
//		
//		if(upFile.getSize()!=0) {//첨부된게 있으면
//			String fileName= Long.toString(System.currentTimeMillis())+"_"+upFile.getOriginalFilename(); //새로운 파일이 들어왔을때 기존 파일이 지워지지 않고 새로운 파일이 들어오도록
//			long fileSize=upFile.getSize();
//			
//			//파일이 따로 모일 폴더
//			File path = new File("C:\\pds\\");
//			
//			path.mkdir();
//			
//			if(path.exists() && path.isDirectory()) { //폴더가 있으면
//				File file = new File(path, fileName);
//				
//				try { //db적재 
//					upFile.transferTo(file);
//					noticeDto.setPath(file.getAbsolutePath()); //db에 넣기 위한 변환작업
//					noticeDto.setFileName(fileName);
//					noticeDto.setFileSize(fileSize);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		int check =noticeDao.noticeInsert(noticeDto);
		
		mav.addObject("check",check);
		mav.setViewName("notice/writeOk");
		
	}

	@Override
	public void noticeRead(ModelAndView mav) {
		Map<String, Object>map= mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int num=Integer.parseInt(request.getParameter("num"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		NoticeDto noticeDto = noticeDao.noticeSelect(num);
		
		mav.addObject("page",page);
		mav.addObject("notice",noticeDto);
		mav.setViewName("notice/search");
		
	}

	@Override
	public void noticeUpdate(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void noticeUpdateOk(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void noticeDelete(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void noticeDeleteOk(ModelAndView mav) {
		Map<String, Object> map= mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int num = Integer.parseInt(request.getParameter("num"));
		int page = Integer.parseInt(request.getParameter("page"));
		//int check =0;
		
		Map<String,String> hmap = new HashMap<String, String>();
		hmap.put("num", request.getParameter("num"));
		hmap.put("page", request.getParameter("page"));

		//String password = request.getParameter("password"); //jsp에 있음
		
		NoticeDto dto = noticeDao.noticeSelectNum(num);
//		if(password.equals(dto.getPassword())) {
//				//dto.delete();
//				check=1;
//			}
		  //mav.addObject("check",check);
		  mav.addObject("noticeDto",dto);
		  mav.addObject("page",page);
		  mav.addObject("num",num);
		  mav.setViewName("notice/deleteOk");
		
	}

	@Override
	public void noticeList(ModelAndView mav) {
		Map<String, Object>map= mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String page =request.getParameter("page");
		
		if(page==null) {
			page="1";
		}
		
		int currentPage = Integer.parseInt(page);
		int noticeSize=10; //한페이지에 10개 
		int startRow = (currentPage-1)*noticeSize+1; //글시작번호
		int endRow = currentPage*noticeSize; //끝번호
		int count = noticeDao.countallmine();

		List<NoticeDto> notices = null;
	
		notices=noticeDao.noticeList(startRow, endRow);
		
		mav.addObject("notices",notices);
		mav.addObject("currentPage",currentPage);
		mav.addObject("noticeSize",noticeSize);
		mav.addObject("count",count);
		mav.setViewName("notice/list");
		
	}

	@Override
	public void noticeUpdateViewCount(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getcountMine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<NoticeDto> getNoticeByPageNum(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeDto> getNoticeheader(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		List<NoticeDto> listnotices = noticeDao.selectNoticeheader();
		return listnotices;
	}

}
