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
	private String oi_deliMessage;
	private String oi_howPay;
	private int oi_usepoint;
	private int oi_originTotalPrice;
	private int oi_totalPrice;
	private Date oi_orderDate;
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
			String oi_deliMessage, String oi_howPay, int oi_usepoint, int oi_originTotalPrice, int oi_totalPrice,
			Date oi_orderDate, String oi_code_num, String add_name, String add_phone1, String add_phone2,
			String add_email, String add_addr_full, String add_addr_zipNo, String add_addr_roadAddrPart1,
			String add_addr_roadAddrPart2, String add_addr_addrDetail) {
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
		this.oi_deliMessage = oi_deliMessage;
		this.oi_howPay = oi_howPay;
		this.oi_usepoint = oi_usepoint;
		this.oi_originTotalPrice = oi_originTotalPrice;
		this.oi_totalPrice = oi_totalPrice;
		this.oi_orderDate = oi_orderDate;
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

	public String getOi_deliMessage() {
		return oi_deliMessage;
	}

	public void setOi_deliMessage(String oi_deliMessage) {
		this.oi_deliMessage = oi_deliMessage;
	}

	public String getOi_howPay() {
		return oi_howPay;
	}

	public void setOi_howPay(String oi_howPay) {
		this.oi_howPay = oi_howPay;
	}

	public int getOi_usepoint() {
		return oi_usepoint;
	}

	public void setOi_usepoint(int oi_usepoint) {
		this.oi_usepoint = oi_usepoint;
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

	public Date getOi_orderDate() {
		return oi_orderDate;
	}

	public void setOi_orderDate(Date oi_orderDate) {
		this.oi_orderDate = oi_orderDate;
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
				+ oi_addr_roadAddrPart2 + ", oi_addr_addrDetail=" + oi_addr_addrDetail + ", oi_deliMessage="
				+ oi_deliMessage + ", oi_howPay=" + oi_howPay + ", oi_usepoint=" + oi_usepoint
				+ ", oi_originTotalPrice=" + oi_originTotalPrice + ", oi_totalPrice=" + oi_totalPrice
				+ ", oi_orderDate=" + oi_orderDate + ", oi_code_num=" + oi_code_num + ", add_name=" + add_name
				+ ", add_phone1=" + add_phone1 + ", add_phone2=" + add_phone2 + ", add_email=" + add_email
				+ ", add_addr_full=" + add_addr_full + ", add_addr_zipNo=" + add_addr_zipNo
				+ ", add_addr_roadAddrPart1=" + add_addr_roadAddrPart1 + ", add_addr_roadAddrPart2="
				+ add_addr_roadAddrPart2 + ", add_addr_addrDetail=" + add_addr_addrDetail + "]";
	}
}
