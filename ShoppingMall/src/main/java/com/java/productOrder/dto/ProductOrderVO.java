package com.java.productOrder.dto;

import java.sql.Date;

import com.java.common.Common;

public class ProductOrderVO {
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
	
	private String name;
	private String img;
	
	private int sum_total_price;
	private Date max_o_date;
	private int max_d_state;
	private int max_p_num;
	private int ctnrow; 	//�븳 二쇰Ц踰덊샇 �떦 二쇰Ц�븳 �긽�뭹 媛쒖닔
	
	private String priceView;
	private int rnum;
	
	public ProductOrderVO() {
		
	}
	
	public ProductOrderVO(int num, int p_num, int o_quantity, int total_price, String m_id, Date o_date, int o_state,
			int d_state, String p_size) {
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

	public ProductOrderVO(int num, int p_num, int o_quantity, int total_price, String m_id, Date o_date, int o_state,
			int d_state, String p_size, int r_state, String code_num) {
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

	public ProductOrderVO(int rnum, String code_num, Date max_o_date, int sum_total_price, int max_d_state, int max_p_num, int ctnrow) {
		this.rnum = rnum;
		this.code_num=code_num;
		this.max_o_date=max_o_date;
		this.max_d_state=max_d_state;
		this.sum_total_price=sum_total_price;
		this.max_p_num=max_p_num;
		this.ctnrow=ctnrow;
		
		this.priceView = Common.priceView(sum_total_price);
	}

	public ProductOrderVO(int num, int p_num, int o_quantity, int total_price, String m_id, Date o_date, int o_state,
			int d_state, String p_size, String prod_name, String prod_img) {
		this.num = num;
		this.p_num = p_num;
		this.o_quantity = o_quantity;
		this.total_price = total_price;
		this.m_id = m_id;
		this.o_date = o_date;
		this.o_state = o_state;
		this.d_state = d_state;
		this.p_size = p_size;
		this.name = prod_name;
		this.img = prod_img;
		
		this.priceView = Common.priceView(total_price);
	}

	public ProductOrderVO(int num, int p_num, int o_quantity, int total_price, String m_id, Date o_date, int o_state,
			int d_state, int r_state, String p_size, String prod_name, String prod_img) {
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
		this.name = prod_name;
		this.img = prod_img;
		
		this.priceView = Common.priceView(total_price);
	}
	
	public ProductOrderVO(String code_num, Date max_o_date, int sum_total_price, int max_d_state, int max_p_num, int ctnrow) {
		super();
		this.code_num=code_num;
		this.max_o_date=max_o_date;
		this.max_d_state=max_d_state;
		this.sum_total_price=sum_total_price;
		this.max_p_num=max_p_num;
		this.ctnrow=ctnrow;
		
		this.priceView = Common.priceView(sum_total_price);
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
		return name;
	}

	public void setProd_name(String prod_name) {
		this.name = prod_name;
	}

	public String getProd_img() {
		return img;
	}

	public void setProd_img(String prod_img) {
		this.img = prod_img;
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



	public void setPriceView(int price) {
		this.priceView = Common.priceView(price);
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
	

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;

	}

	@Override
	public String toString() {
		return "ProductOrderVO [num=" + num + ", p_num=" + p_num + ", o_quantity=" + o_quantity + ", total_price="
				+ total_price + ", m_id=" + m_id + ", o_date=" + o_date + ", o_state=" + o_state + ", d_state="
				+ d_state + ", p_size=" + p_size + ", r_state=" + r_state + ", code_num=" + code_num + ", name=" + name
				+ ", img=" + img + ", sum_total_price=" + sum_total_price + ", max_o_date=" + max_o_date
				+ ", max_d_state=" + max_d_state + ", max_p_num=" + max_p_num + ", ctnrow=" + ctnrow + ", priceView="
				+ priceView + ", rnum=" + rnum + "]";
	}
	
}
