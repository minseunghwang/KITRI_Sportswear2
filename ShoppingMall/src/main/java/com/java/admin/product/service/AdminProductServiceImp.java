package com.java.admin.product.service;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
//import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.java.admin.product.dao.AdminProductDao;
import com.java.common.PaginationVO;
import com.java.common.ProductImageVO;
import com.java.common.ProductSizeVO;
import com.java.product.dto.ProductDto;


@Configuration
@Component
public class AdminProductServiceImp implements AdminProductService{

	@Autowired
	private AdminProductDao adminProductDao;
	
	@Override
	public void productList(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int page = Integer.parseInt(request.getParameter("page"));	
		int startRange = (page - 1) * 8 + 1;
		int endRange = page * 8;
		
		List<ProductDto> products = adminProductDao.getProductManagementByPageNum(startRange,endRange);

		List<Object> allProducts = null;
		allProducts = adminProductDao.getProductAll();
		
		for (ProductDto product : products) {
			List<ProductSizeVO> productsSize = adminProductDao.getProductsSizeAll(product.getNum());
			product.setSizes(productsSize);
		}
		
		PaginationVO pn = new PaginationVO();
		
		// 페이징 처리
		pn.setPage(page);					// 현재 페이지
		pn.setCountList(8);					// 한 화면에 보여질 상품 수
		pn.setCountPage(3);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>
		
		pn.setTotalCount(allProducts.size());	// 전체 상품 수 ex) 35개
		
		pn.setTotalPage(pn.getTotalCount() / pn.getCountList());
		if(pn.getTotalCount() % pn.getCountList() > 0) {	// ex) 총 상품 35개, 한 페이지에 8개 표시 :: 4개의 페이지(8개 상품) + 1페이지(3개 상품)
			pn.setTotalPage(pn.getTotalPage() + 1);
		}
		
		if(pn.getTotalPage() < pn.getPage()) {
			pn.setPage(pn.getTotalPage());
		}
		
		pn.setStartPage((pn.getPage() - 1) / pn.getCountPage() * pn.getCountPage() + 1);
		pn.setEndPage(pn.getStartPage() + pn.getCountPage() - 1);

		if(pn.getEndPage() > pn.getTotalPage()) {
			pn.setEndPage(pn.getTotalPage());
		}
		
		mav.addObject("page", page);
		mav.addObject("products", products);
		mav.addObject("pn", pn);
		mav.setViewName("/admin/product/adminProductManagement");
	}

	@Override
	public void productWrite(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		mav.setViewName("admin/product/adminProductAddForm");
	}

	@Override
	public void productWriteOk(ModelAndView mav) {
		Map<String, Object>map= mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		
		ProductDto productDto = (ProductDto) map.get("productDto");
		ProductImageVO productImageVO = (ProductImageVO) map.get("productImageVO");
		
		int seqProductNum = adminProductDao.makeProductNum();
		productDto.setNum(seqProductNum);
		productImageVO.setP_num(seqProductNum);
//				
		String thumbnailImgName = "";
		String detailImgName = "";
		String inputTagName = "";
		
		int maxSize = 1024 * 1024 * 10;
		
//		String uploadPath = "C:\\spring3\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\upload_img";
		String uploadPath = "C:\\Users\\kit\\git\\KITRI_Sportswear3\\ShoppingMall\\src\\main\\webapp\\resources\\upload_img";
		
		
		try {
			
			productDto.setName(multipartHttpServletRequest.getParameter("name"));
			
			String[] categorys = multipartHttpServletRequest.getParameterValues("category");
			for (String category : categorys) {
				productDto.setCategory(category);
			}

			System.out.println(productDto.toString());
			productDto.setPrice(Integer.parseInt(multipartHttpServletRequest.getParameter("price")));
			productDto.setContent(multipartHttpServletRequest.getParameter("content"));

		    Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
			MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
			//MultipartFile multipartFile2 = multipartHttpServletRequest.getFile("file1");

			while(iterator.hasNext()){
				multipartFile = multipartHttpServletRequest.getFile(iterator.next());
				if(multipartFile.isEmpty() == false){
					productDto.setImg("/upload_img/" + multipartFile.getOriginalFilename());
					//break;
					String saveName =multipartFile.getOriginalFilename();
					
					File saveFile = new File(uploadPath, saveName);
					
					try {
						multipartFile.transferTo(saveFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
			
			// 대표이미지 업로드
			System.out.println(productDto.toString());
			adminProductDao.productInsert(productDto);

			// 전송한 전체 파일이름들을 가져옴
			Iterator<String> files = multipartHttpServletRequest.getFileNames();
			multipartFile = null;
			// 상세이미지 업로드
			while (files.hasNext()) {
				inputTagName = (String) files.next();
				if (!inputTagName.equals("file")) {
					multipartFile = multipartHttpServletRequest.getFile(inputTagName);
					if (multipartFile.isEmpty() == false) {
						productImageVO.setNum(adminProductDao.makeProductImgNum());
						productImageVO.setImg("/upload_img/" + multipartFile.getOriginalFilename());
						System.out.println(productImageVO.toString());
						adminProductDao.productImgInsert(productImageVO);
						
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
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//int check =adminProductDao.productWriteOk(productDto, productImageVO);
		int check = 1;
//		int check2 = adminProductDao.productImgInsert(productImageVO);

		// mav.addObject("check",check);
		mav.addObject("check", check);
//		mav.addObject("check2", check2);
		mav.setViewName("admin/product/adminProductAddFormOk");
	}

	@Override
	public void adminProductDeleteOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int num = Integer.parseInt(request.getParameter("num"));
		int page = Integer.parseInt(request.getParameter("page"));

		Map<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("num", request.getParameter("num"));
		hmap.put("page", request.getParameter("page"));
		
		adminProductDao.productDelete(hmap);
		
		mav.addObject("num", num);
		mav.addObject("page", page);
		mav.setViewName("admin/product/adminProductDeleteOk");
	}

	@Override
	public void adminProductManagementPopup(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int num = Integer.parseInt(request.getParameter("num"));
		int page = Integer.parseInt(request.getParameter("page"));

		ProductDto product = adminProductDao.productSelect(num);
		  
		mav.addObject("product",product); 
		mav.addObject("num",num);
		mav.addObject("page",page);
		mav.setViewName("admin/product/adminProductManagementPopup");
	}

	@Override
	public void adminProductSizeAdd(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int productNum = Integer.parseInt(request.getParameter("productNum"));
		
		String size = request.getParameter("size");
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		//System.out.println(quantity);
		
		ProductSizeVO ps = new ProductSizeVO();
		
		// 남은 재고의 수량
		int remainingQuantity = adminProductDao.checkQuantity(productNum, size);
		int page = Integer.parseInt(request.getParameter("page"));
		
		if(-1 == remainingQuantity) {	// 입고된 기록이 없음, insert
			ps.setNum(adminProductDao.makeProductSizeNum());
			System.out.println(ps.getNum());
			ps.setP_num(productNum);
			ps.setPsize(size);
			ps.setQuantity(quantity);
			adminProductDao.add(ps);
		}else {							// 재고가 남아있음, update
			ps.setP_num(productNum);
			ps.setPsize(size);
			ps.setQuantity(remainingQuantity + quantity);
			adminProductDao.addQuantity(ps);
		}
		int startRange = (page - 1) * 8 + 1;
		int endRange = page * 8;
		
		List<ProductDto> products = adminProductDao.getProductManagementByPageNum(startRange,endRange);

		List<Object> allProducts = null;
		allProducts = adminProductDao.getProductAll();
		
		for (ProductDto product : products) {
			List<ProductSizeVO> productsSize = adminProductDao.getProductsSizeAll(product.getNum());
			product.setSizes(productsSize);
		}
		
		PaginationVO pn = new PaginationVO();
		
		// 페이징 처리
		pn.setPage(page);					// 현재 페이지
		pn.setCountList(8);					// 한 화면에 보여질 상품 수
		pn.setCountPage(3);					// 하단 보여질 페이지 수 ex) << < 1 2 3 > >>
		
		pn.setTotalCount(allProducts.size());	// 전체 상품 수 ex) 35개
		
		pn.setTotalPage(pn.getTotalCount() / pn.getCountList());
		if(pn.getTotalCount() % pn.getCountList() > 0) {	// ex) 총 상품 35개, 한 페이지에 8개 표시 :: 4개의 페이지(8개 상품) + 1페이지(3개 상품)
			pn.setTotalPage(pn.getTotalPage() + 1);
		}
		
		if(pn.getTotalPage() < pn.getPage()) {
			pn.setPage(pn.getTotalPage());
		}
		
		pn.setStartPage((pn.getPage() - 1) / pn.getCountPage() * pn.getCountPage() + 1);
		pn.setEndPage(pn.getStartPage() + pn.getCountPage() - 1);

		if(pn.getEndPage() > pn.getTotalPage()) {
			pn.setEndPage(pn.getTotalPage());
		}

		mav.addObject("page", page);
		mav.addObject("products", products);
		mav.addObject("pn", pn);
		mav.setViewName("/admin/product/adminProductManagement");
		
	}
}
