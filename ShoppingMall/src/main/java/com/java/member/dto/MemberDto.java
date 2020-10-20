package com.java.member.dto;

public class MemberDto {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String addr;
	private int type;
	private int point;
	
	public MemberDto() {
		
	}
	public MemberDto(String id) {
		
	}
	
	public MemberDto(String id, String pwd, String name, String email, String addr, int type, int point) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.addr = addr;
		this.type = type;
		this.point = point;
	}
	
	public MemberDto(String id, String pwd, String name, String email, String addr) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.addr = addr;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", addr=" + addr
				+ ", type=" + type + ", point=" + point + "]";
	}
	
}
