package com.java.member.dao;

import java.util.Map;

import com.java.member.dto.MemberDto;

public interface MemberDao {
	
	public String memberLogin(Map<String,String> map);
	public int memberJoin(Map<String, Object> map);
	public String memberGetId(Map<String,String> map);
	public String memberGetPwd(Map<String,String> map);
	public int memberIdCheck(Map<String, String> map);
	
	public String memberGetPoint(Map<String,String> map);
	public MemberDto memberGetInfo(String id);
	public void memberDelete(String id);
	public void memberUpdateInfo(Map<String, Object> map);
}
