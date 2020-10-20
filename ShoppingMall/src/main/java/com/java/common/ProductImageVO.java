package com.java.common;

public class ProductImageVO {
	private int num;
	private int p_num;
	private String img;
	
	public ProductImageVO() {}
	
	public ProductImageVO(int num, int p_num, String img) {
		super();
		this.num = num;
		this.p_num = p_num;
		this.img = img;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ProductImageVO [num=" + num + ", p_num=" + p_num + ", img=" + img + "]";
	}
	
	
}
