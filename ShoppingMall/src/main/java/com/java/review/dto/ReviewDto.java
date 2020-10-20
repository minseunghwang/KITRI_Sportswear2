package com.java.review.dto;

import java.sql.Date;

public class ReviewDto {
	private int num;
	private String m_id;
	private int p_num;
	private int rate;
	private String content;
	private String img;
	private Date r_date;
	
	public ReviewDto() {
		
	}
	
	public ReviewDto(int num, String m_id, int p_num, int rate, String content, String img, Date r_date) {
		this.num = num;
		this.m_id = m_id;
		this.p_num=p_num;
		this.rate = rate;
		this.content = content;
		this.img = img;
		this.r_date = r_date;
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	@Override
	public String toString() {
		return "ReviewDto [num=" + num + ", m_id=" + m_id + ", p_num=" + p_num + ", rate=" + rate + ", content="
				+ content + ", img=" + img + ", r_date=" + r_date + "]";
	}
	
}
