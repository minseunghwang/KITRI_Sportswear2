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
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public void noticeWrite(ModelAndView mav) {

		// int num =0;
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		mav.setViewName("notice/addForm");

	}

	@Override
	public void noticeWriteOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		NoticeDto noticeDto = (NoticeDto) map.get("noticeDto");
		// MultipartHttpServletRequest request = (MultipartHttpServletRequest)
		// map.get("request");
		// MultipartHttpServletRequest 湲곗〈�뿉 formfied 濡� �뱾�뼱�솕�뒗吏� �솗�씤�븯�뒗 �옉�뾽�쓣
		// �븞�빐�룄 �맂�떎,
		noticeDto.setN_date(new Date());
		noticeDto.setView_count(0);

		// noticeSelectNum(noticeDto);

//		MultipartFile upFile = request.getFile("file");//file : jsp�떒�쓽 �씠由꾧낵 媛숆쾶
//		
//		if(upFile.getSize()!=0) {//泥⑤��맂寃� �엳�쑝硫�
//			String fileName= Long.toString(System.currentTimeMillis())+"_"+upFile.getOriginalFilename(); //�깉濡쒖슫 �뙆�씪�씠 �뱾�뼱�솕�쓣�븣 湲곗〈 �뙆�씪�씠 吏��썙吏�吏� �븡怨� �깉濡쒖슫 �뙆�씪�씠 �뱾�뼱�삤�룄濡�
//			long fileSize=upFile.getSize();
//			
//			//�뙆�씪�씠 �뵲濡� 紐⑥씪 �뤃�뜑
//			File path = new File("C:\\pds\\");
//			
//			path.mkdir();
//			
//			if(path.exists() && path.isDirectory()) { //�뤃�뜑媛� �엳�쑝硫�
//				File file = new File(path, fileName);
//				
//				try { //db�쟻�옱 
//					upFile.transferTo(file);
//					noticeDto.setPath(file.getAbsolutePath()); //db�뿉 �꽔湲� �쐞�븳 蹂��솚�옉�뾽
//					noticeDto.setFileName(fileName);
//					noticeDto.setFileSize(fileSize);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}

		int check = noticeDao.noticeInsert(noticeDto);

		mav.addObject("check", check);
		mav.setViewName("notice/writeOk");

	}

	@Override
	public void noticeRead(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int num = Integer.parseInt(request.getParameter("num"));
		//int page = Integer.parseInt(request.getParameter("page"));

		NoticeDto noticeDto = noticeDao.noticeSelect(num);

		//mav.addObject("page", page);
		// mav.addObject("num",num);
		mav.addObject("notice", noticeDto);
		mav.setViewName("notice/search");

	}

	@Override
	public void noticeUpdate(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int num = Integer.parseInt(request.getParameter("num"));
		int page = Integer.parseInt(request.getParameter("page"));

		System.out.println(num + "ㅇㅅㅇ" + page);

		
		 NoticeDto dto = noticeDao.noticeSelectNum(num);
		  
		 mav.addObject("notice",dto); mav.addObject("num",num);
		 mav.addObject("page",page);
		 
		mav.setViewName("notice/update");

	}

	@Override
	public void noticeUpdateOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int num = Integer.parseInt(request.getParameter("num"));
		int page = Integer.parseInt(request.getParameter("page"));

		NoticeDto noticeDto = (NoticeDto) map.get("noticeDto");

		int check = noticeDao.noticeUpdate(noticeDto);
		mav.addObject("check", check);
		mav.addObject("num", num);
		mav.addObject("page", page);
		mav.setViewName("notice/updateOk");
	}

	@Override
	public void noticeDelete(ModelAndView mav) {
		// TODO Auto-generated method stub

	}

	@Override
	public void noticeDeleteOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int num = Integer.parseInt(request.getParameter("num"));
		int page = Integer.parseInt(request.getParameter("page"));
		// int check =0;

		Map<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("num", request.getParameter("num"));
		hmap.put("page", request.getParameter("page"));

		int check = noticeDao.noticeDelete(hmap);
		// String password = request.getParameter("password"); //jsp�뿉 �엳�쓬

		// NoticeDto dto = noticeDao.noticeSelectNum(num);
//		if(password.equals(dto.getPassword())) {
//				//dto.delete();
//				check=1;
//			}
		mav.addObject("check", check);
		// mav.addObject("notice",dto);
		mav.addObject("page", page);
		mav.addObject("num", num);
		mav.setViewName("notice/deleteOk");

	}

	@Override
	public void noticeList(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String page = request.getParameter("page");

		if (page == null) {
			page = "1";
		}

		int currentPage = Integer.parseInt(page);
		int noticeSize = 10; // �븳�럹�씠吏��뿉 10媛�
		int startRow = (currentPage - 1) * noticeSize + 1; // 湲��떆�옉踰덊샇
		int endRow = currentPage * noticeSize; // �걹踰덊샇
		int count = noticeDao.countallmine();

		List<NoticeDto> notices = null;

		notices = noticeDao.noticeList(startRow, endRow);

		mav.addObject("notices", notices);
		mav.addObject("currentPage", currentPage);
		mav.addObject("noticeSize", noticeSize);
		mav.addObject("count", count);
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
		 HttpServletRequest request = (HttpServletRequest) map.get("request");
		List<NoticeDto> listnotices = noticeDao.selectNoticeheader();
		return listnotices;
	}

}
