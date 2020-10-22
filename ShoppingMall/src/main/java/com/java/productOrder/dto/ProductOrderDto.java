package com.java.productOrder.dto;

import java.sql.Date;

import com.java.common.Common;

public class ProductOrderDto {
	private int num;
	private int p_num;
	private int o_quantity;
	private int total_price;
	private String m_id;
	private Date o_date;
	private int o_state;
	private int d_state;
	private String p_size;
	private int r_state;
	private String code_num;
	private String prod_name;
	private String prod_img;
	
	private int sum_total_price;
	private Date max_o_date;
	private int max_d_state;
	private int max_p_num;
	private int ctnrow; 	//�� �ֹ���ȣ �� �ֹ��� ��ǰ ����
	
	private String priceView;
	
	public ProductOrderDto() {
		
	}
	
	

	public ProductOrderDto(int num, int p_num, int o_quantity, int total_price, String m_id, Date o_date, int o_state,
			int d_state, String p_size) {
		super();
		this.num = num;
		this.p_num = p_num;
		this.o_quantity = o_quantity;
		this.total_price = total_price;
		this.m_id = m_id;
		this.o_date = o_date;
		this.o_state = o_state;
		this.d_state = d_state;
		this.p_size = p_size;
		
		this.priceView = Common.priceView(total_price);
	}

	public ProductOrderDto(int num, int p_num, int o_quantity, int total_price, String m_id, Date o_date, int o_state,
			int d_state, String p_size, int r_state, String code_num) {
		super();
		this.num = num;
		this.p_num = p_num;
		this.o_quantity = o_quantity;
		this.total_price = total_price;
		this.m_id = m_id;
		this.o_date = o_date;
		this.o_state = o_state;
		this.d_state = d_state;
		this.p_size = p_size;
		this.r_state=r_state;
		this.code_num=code_num;
		
		this.priceView = Common.priceView(total_price);
	}

	public ProductOrderDto(String code_num, Date max_o_date, int sum_total_price, int max_d_state, int max_p_num, int ctnrow) {
		super();
		this.code_num=code_num;
		this.max_o_date=max_o_date;
		this.max_d_state=max_d_state;
		this.sum_total_price=sum_total_price;
		this.max_p_num=max_p_num;
		this.ctnrow=ctnrow;
		
		this.priceView = Common.priceView(sum_total_price);
	}

	public ProductOrderDto(int num, String prod_name,String prod_img, String p_size, int o_quantity, int total_price) {
		super();
		this.num = num;
		this.o_quantity = o_quantity;
		this.total_price = total_price;
		this.p_size = p_size;
		this.prod_name = prod_name;
		this.prod_img = prod_img;
		this.priceView = Common.priceView(total_price);
	}

	public ProductOrderDto(int num, int p_num, int o_quantity, int total_price, String m_id, Date o_date, int o_state,
			int d_state, int r_state, String p_size, String prod_name, String prod_img) {
		super();
		this.num = num;
		this.p_num = p_num;
		this.o_quantity = o_quantity;
		this.total_price = total_price;
		this.m_id = m_id;
		this.o_date = o_date;
		this.o_state = o_state;
		this.d_state = d_state;
		this.r_state = r_state;
		this.p_size = p_size;
		this.prod_name = prod_name;
		this.prod_img = prod_img;
		
		this.priceView = Common.priceView(total_price);
	}
	
	public ProductOrderDto(int num, int p_num, int o_quantity, int total_price, String m_id, Date o_date, int o_state,
		 String p_size, String prod_name, String prod_img) {
		super();
		this.num = num;
		this.p_num = p_num;
		this.o_quantity = o_quantity;
		this.total_price = total_price;
		this.m_id = m_id;
		this.o_date = o_date;
		this.o_state = o_state;
		this.d_state = d_state;
		this.r_state = r_state;
		this.p_size = p_size;
		this.prod_name = prod_name;
		this.prod_img = prod_img;
		
		this.priceView = Common.priceView(total_price);
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

	public int getO_quantity() {
		return o_quantity;
	}

	public void setO_quantity(int o_quantity) {
		this.o_quantity = o_quantity;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public int getO_state() {
		return o_state;
	}

	public void setO_state(int o_state) {
		this.o_state = o_state;
	}

	public int getD_state() {
		return d_state;
	}

	public void setD_state(int d_state) {
		this.d_state = d_state;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_img() {
		return prod_img;
	}

	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}

	public int getR_state() {
		return r_state;
	}

	public void setR_state(int r_state) {
		this.r_state = r_state;
	}

	public String getPriceView() {
		return priceView;
	}



	public void setPriceView(String priceView) {
		this.priceView = priceView;
	}



	public String getCode_num() {
		return code_num;
	}



	public void setCode_num(String code_num) {
		this.code_num = code_num;
	}



	public int getSum_total_price() {
		return sum_total_price;
	}



	public void setSum_total_price(int sum_total_price) {
		this.sum_total_price = sum_total_price;
	}



	public Date getMax_o_date() {
		return max_o_date;
	}



	public void setMax_o_date(Date max_o_date) {
		this.max_o_date = max_o_date;
	}



	public int getMax_d_state() {
		return max_d_state;
	}



	public void setMax_d_state(int max_d_state) {
		this.max_d_state = max_d_state;
	}



	public int getMax_p_num() {
		return max_p_num;
	}



	public void setMax_p_num(int max_p_num) {
		this.max_p_num = max_p_num;
	}



	public int getCtnrow() {
		return ctnrow;
	}



	public void setCtnrow(int ctnrow) {
		this.ctnrow = ctnrow;
	}



	@Override
	public String toString() {
		return "ProductOrderDto [num=" + num + ", p_num=" + p_num + ", o_quantity=" + o_quantity + ", total_price="
				+ total_price + ", m_id=" + m_id + ", o_date=" + o_date + ", o_state=" + o_state + ", d_state="
				+ d_state + ", r_state=" + r_state + ", p_size=" + p_size + ", code_num=" + code_num + ", prod_name="
				+ prod_name + ", prod_img=" + prod_img + ", sum_total_price=" + sum_total_price + ", max_o_date="
				+ max_o_date + ", max_d_state=" + max_d_state + ", max_p_num=" + max_p_num + ", ctnrow=" + ctnrow
				+ ", priceView=" + priceView + "]";
	}


	
	
}
