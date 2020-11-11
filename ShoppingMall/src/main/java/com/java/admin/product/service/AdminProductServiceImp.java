package com.java.admin.product.service;

import java.io.File;
import java.util.Enumeration;
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
		System.out.println("손목아퍼" + seqProductNum);
		productDto.setNum(seqProductNum);
		productImageVO.setP_num(seqProductNum);
//				
		String thumbnailImgName = "";
		String detailImgName = "";
		String inputTagName = "";
		
		int maxSize = 1024 * 1024 * 10;
		
		String uploadPath = "C:\\spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\upload_img";
//		String uploadPath = "C:\\Users\\kit\\git\\KITRI_Sportswear3\\ShoppingMall\\src\\main\\webapp\\resources\\upload_img";
		
		
		try {
//			multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			
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
			System.out.println("미춰버리겟네 진실 : " + multipartFile.getOriginalFilename());
			MultipartFile multipartFile2 = multipartHttpServletRequest.getFile("file1");
			System.out.println("미춰버리겟네 진실2 : " + multipartFile2.getOriginalFilename());
			
//			MultipartFile ms = null;
//			while(iterator.hasNext()) {
//				ms = multipartHttpServletRequest.getFile(iterator.next());
//				System.out.println("메롱" + ms.getOriginalFilename());
//			}

			while(iterator.hasNext()){
				multipartFile = multipartHttpServletRequest.getFile(iterator.next());
				//thumbnailImgName = multipartFile.getOriginalFileName("file"); //진실
				if(multipartFile.isEmpty() == false){
					productDto.setImg("/upload_img/" + multipartFile.getOriginalFilename());
					break;
				}
			}
			
			// 대표이미지 업로드
			System.out.println(productDto.toString());
			adminProductDao.productInsert(productDto);
			
//			파일 업로드
	//		File file = (File) multipartFile;
			File file = (File) multipartHttpServletRequest.getFile("file"); //진실
	//		multipartFile = multipartHttpServletRequest.getFile("file"); //진실

			
			// 전송한 전체 파일이름들을 가져옴
			Iterator<String> files = multipartHttpServletRequest.getFileNames();
			multipartFile = null;
			// 상세이미지 업로드
						while(files.hasNext()) {
							// form 태그에서 <input type="file" name="여기에 지정한 이름" />을 가져온다.
//							inputTagName = (String) files.nextElement();	// 파일 input에 지정한 이름을 가져옴

							if(!inputTagName.equals("file")) {
								// 그에 해당하는 실제 파일 이름을 가져옴
								multipartFile = multipartHttpServletRequest.getFile(files.next());
								if(multipartFile.isEmpty() == false) {
									//StringUtils.isNotBlank(detailImgName)
									productImageVO.setNum(adminProductDao.makeProductImgNum());
									productImageVO.setImg("/upload_img/" + multipartFile.getOriginalFilename());
									System.out.println(productImageVO.toString());

									adminProductDao.productImgInsert(productImageVO);
									//파일 업로드
									File file1 = (File) multipartHttpServletRequest.getFile(inputTagName);
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
}
