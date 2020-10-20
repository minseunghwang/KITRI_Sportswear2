package com.java.productSize.dto;

public class ProductSizeDto {
	private int num;
	private int p_num;
	private String psize;
	private int quantity;
	
	public ProductSizeDto() {}
	
	public ProductSizeDto(int num, int p_num, String psize, int quantity) {
		super();
		this.num = num;
		this.p_num = p_num;
		this.psize = psize;
		this.quantity = quantity;
	}
	
	public ProductSizeDto(int p_num, String psize, int quantity) {
		super();
		this.p_num = p_num;
		this.psize = psize;
		this.quantity = quantity;
	} 

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getPsize() {
		return psize;
	}

	public void setPsize(String psize) {
		this.psize = psize;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductSizeVO [num=" + num + ", p_num=" + p_num + ", psize=" + psize + ", quantity=" + quantity + "]";
	}
	
	
	
}
