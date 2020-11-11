package com.java.product.dto;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.java.common.ProductSizeVO;
import com.java.review.dto.ReviewDto;

import com.java.common.Common;

public class ProductDto {
	private int num;
	private String name;
	private int price;
	private String img;
	private String content;
	private Date e_date;
	private int record;
	private String category;
	private ArrayList<ReviewDto> reviews;
	private List<ProductSizeVO> sizes;
	
	public List<ProductSizeVO> getSizes() {
		return sizes;
	}

	public void setSizes(List<ProductSizeVO> productsSize) {
		this.sizes = productsSize;
	}

	private String priceView;
	
	public ProductDto() {}

	public ProductDto(int num, String name, int price, String img, String content, Date e_date, int record, String category) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.img = img;
		this.content = content;
		this.e_date = e_date;
		this.record = record;
		this.category = category;
		
		this.priceView = Common.priceView(price);

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getE_date() {
		return e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<ReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<ReviewDto> reviews) {
		this.reviews = reviews;
	}

	public String getPriceView() {
		return priceView;
	}

	public void setPriceView(int price) {
		this.priceView = Common.priceView(price);
	}

	@Override
	public String toString() {
		return "ProductDto [num=" + num + ", name=" + name + ", price=" + price + ", img=" + img + ", content=" + content
				+ ", e_date=" + e_date + ", record=" + record + ", category=" + category + ", reviews=" + reviews
				+ ", sizes=" + sizes + ", priceView=" + priceView + "]";
	}

	
}
