package com.java.common;

import java.sql.Date;

public class OrderInfoVO {
	private int num;
	private String oi_id;
	private String oi_name;
	private String oi_phone;
	private String oi_email;
	private String oi_addr_full;
	private String oi_addr_zipno;
	private String oi_addr_roadAddrPart1;
	private String oi_addr_roadAddrPart2;
	private String oi_addr_addrDetail;
	private String deliMessage;
	private String howPay;
	private int oi_userPoint;
	private int oi_originTotalPrice;
	private int oi_totalPrice;
	private Date orderDate;
	private String oi_code_num;
	private String add_name;
	private String add_phone1;
	private String add_phone2;
	private String add_email;
	private String add_addr_full;
	private String add_addr_zipNo;
	private String add_addr_roadAddrPart1;
	private String add_addr_roadAddrPart2;
	private String add_addr_addrDetail;
	
	
	public OrderInfoVO() {
		
	}
	
	
	
	public OrderInfoVO(int num, String oi_id, String oi_name, String oi_phone, String oi_email, String oi_addr_full,
			String oi_addr_zipno, String oi_addr_roadAddrPart1, String oi_addr_roadAddrPart2, String oi_addr_addrDetail,
			String deliMessage, String howPay, int oi_userPoint, int oi_originTotalPrice, int oi_totalPrice,
			Date orderDate, String oi_code_num, String add_name, String add_phone1, String add_phone2, String add_email,
			String add_addr_full, String add_addr_zipNo, String add_addr_roadAddrPart1, String add_addr_roadAddrPart2,
			String add_addr_addrDetail) {
		super();
		this.num = num;
		this.oi_id = oi_id;
		this.oi_name = oi_name;
		this.oi_phone = oi_phone;
		this.oi_email = oi_email;
		this.oi_addr_full = oi_addr_full;
		this.oi_addr_zipno = oi_addr_zipno;
		this.oi_addr_roadAddrPart1 = oi_addr_roadAddrPart1;
		this.oi_addr_roadAddrPart2 = oi_addr_roadAddrPart2;
		this.oi_addr_addrDetail = oi_addr_addrDetail;
		this.deliMessage = deliMessage;
		this.howPay = howPay;
		this.oi_userPoint = oi_userPoint;
		this.oi_originTotalPrice = oi_originTotalPrice;
		this.oi_totalPrice = oi_totalPrice;
		this.orderDate = orderDate;
		this.oi_code_num = oi_code_num;
		this.add_name = add_name;
		this.add_phone1 = add_phone1;
		this.add_phone2 = add_phone2;
		this.add_email = add_email;
		this.add_addr_full = add_addr_full;
		this.add_addr_zipNo = add_addr_zipNo;
		this.add_addr_roadAddrPart1 = add_addr_roadAddrPart1;
		this.add_addr_roadAddrPart2 = add_addr_roadAddrPart2;
		this.add_addr_addrDetail = add_addr_addrDetail;
	}
	
	
	
	
	
	
	
	public int getNum() {
		return num;
	}







	public void setNum(int num) {
		this.num = num;
	}







	public String getOi_id() {
		return oi_id;
	}







	public void setOi_id(String oi_id) {
		this.oi_id = oi_id;
	}







	public String getOi_name() {
		return oi_name;
	}







	public void setOi_name(String oi_name) {
		this.oi_name = oi_name;
	}







	public String getOi_phone() {
		return oi_phone;
	}







	public void setOi_phone(String oi_phone) {
		this.oi_phone = oi_phone;
	}







	public String getOi_email() {
		return oi_email;
	}







	public void setOi_email(String oi_email) {
		this.oi_email = oi_email;
	}







	public String getOi_addr_full() {
		return oi_addr_full;
	}







	public void setOi_addr_full(String oi_addr_full) {
		this.oi_addr_full = oi_addr_full;
	}







	public String getOi_addr_zipno() {
		return oi_addr_zipno;
	}







	public void setOi_addr_zipno(String oi_addr_zipno) {
		this.oi_addr_zipno = oi_addr_zipno;
	}







	public String getOi_addr_roadAddrPart1() {
		return oi_addr_roadAddrPart1;
	}







	public void setOi_addr_roadAddrPart1(String oi_addr_roadAddrPart1) {
		this.oi_addr_roadAddrPart1 = oi_addr_roadAddrPart1;
	}







	public String getOi_addr_roadAddrPart2() {
		return oi_addr_roadAddrPart2;
	}







	public void setOi_addr_roadAddrPart2(String oi_addr_roadAddrPart2) {
		this.oi_addr_roadAddrPart2 = oi_addr_roadAddrPart2;
	}







	public String getOi_addr_addrDetail() {
		return oi_addr_addrDetail;
	}







	public void setOi_addr_addrDetail(String oi_addr_addrDetail) {
		this.oi_addr_addrDetail = oi_addr_addrDetail;
	}







	public String getDeliMessage() {
		return deliMessage;
	}







	public void setDeliMessage(String deliMessage) {
		this.deliMessage = deliMessage;
	}







	public String getHowPay() {
		return howPay;
	}







	public void setHowPay(String howPay) {
		this.howPay = howPay;
	}







	public int getOi_userPoint() {
		return oi_userPoint;
	}







	public void setOi_userPoint(int oi_userPoint) {
		this.oi_userPoint = oi_userPoint;
	}







	public int getOi_originTotalPrice() {
		return oi_originTotalPrice;
	}







	public void setOi_originTotalPrice(int oi_originTotalPrice) {
		this.oi_originTotalPrice = oi_originTotalPrice;
	}







	public int getOi_totalPrice() {
		return oi_totalPrice;
	}







	public void setOi_totalPrice(int oi_totalPrice) {
		this.oi_totalPrice = oi_totalPrice;
	}







	public Date getOrderDate() {
		return orderDate;
	}







	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}







	public String getOi_code_num() {
		return oi_code_num;
	}







	public void setOi_code_num(String oi_code_num) {
		this.oi_code_num = oi_code_num;
	}







	public String getAdd_name() {
		return add_name;
	}







	public void setAdd_name(String add_name) {
		this.add_name = add_name;
	}







	public String getAdd_phone1() {
		return add_phone1;
	}







	public void setAdd_phone1(String add_phone1) {
		this.add_phone1 = add_phone1;
	}







	public String getAdd_phone2() {
		return add_phone2;
	}







	public void setAdd_phone2(String add_phone2) {
		this.add_phone2 = add_phone2;
	}







	public String getAdd_email() {
		return add_email;
	}







	public void setAdd_email(String add_email) {
		this.add_email = add_email;
	}







	public String getAdd_addr_full() {
		return add_addr_full;
	}







	public void setAdd_addr_full(String add_addr_full) {
		this.add_addr_full = add_addr_full;
	}







	public String getAdd_addr_zipNo() {
		return add_addr_zipNo;
	}







	public void setAdd_addr_zipNo(String add_addr_zipNo) {
		this.add_addr_zipNo = add_addr_zipNo;
	}







	public String getAdd_addr_roadAddrPart1() {
		return add_addr_roadAddrPart1;
	}







	public void setAdd_addr_roadAddrPart1(String add_addr_roadAddrPart1) {
		this.add_addr_roadAddrPart1 = add_addr_roadAddrPart1;
	}







	public String getAdd_addr_roadAddrPart2() {
		return add_addr_roadAddrPart2;
	}







	public void setAdd_addr_roadAddrPart2(String add_addr_roadAddrPart2) {
		this.add_addr_roadAddrPart2 = add_addr_roadAddrPart2;
	}







	public String getAdd_addr_addrDetail() {
		return add_addr_addrDetail;
	}







	public void setAdd_addr_addrDetail(String add_addr_addrDetail) {
		this.add_addr_addrDetail = add_addr_addrDetail;
	}







	@Override
	public String toString() {
		return "OrderInfoVO [num=" + num + ", oi_id=" + oi_id + ", oi_name=" + oi_name + ", oi_phone=" + oi_phone
				+ ", oi_email=" + oi_email + ", oi_addr_full=" + oi_addr_full + ", oi_addr_zipno=" + oi_addr_zipno
				+ ", oi_addr_roadAddrPart1=" + oi_addr_roadAddrPart1 + ", oi_addr_roadAddrPart2="
				+ oi_addr_roadAddrPart2 + ", oi_addr_addrDetail=" + oi_addr_addrDetail + ", deliMessage=" + deliMessage
				+ ", howPay=" + howPay + ", oi_userPoint=" + oi_userPoint + ", oi_originTotalPrice="
				+ oi_originTotalPrice + ", oi_totalPrice=" + oi_totalPrice + ", orderDate=" + orderDate
				+ ", oi_code_num=" + oi_code_num + ", add_name=" + add_name + ", add_phone1=" + add_phone1
				+ ", add_phone2=" + add_phone2 + ", add_email=" + add_email + ", add_addr_full=" + add_addr_full
				+ ", add_addr_zipNo=" + add_addr_zipNo + ", add_addr_roadAddrPart1=" + add_addr_roadAddrPart1
				+ ", add_addr_roadAddrPart2=" + add_addr_roadAddrPart2 + ", add_addr_addrDetail=" + add_addr_addrDetail
				+ "]";
	}
	
	
	
	
	
	
	
	
	
}
