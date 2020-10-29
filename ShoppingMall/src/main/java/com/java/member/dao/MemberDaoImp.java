package com.java.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.member.dto.MemberDto;

@Component
public class MemberDaoImp implements MemberDao {

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public String memberLogin(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberLogin", map);
	}

	@Override
	public int memberJoin(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int check=0;
		try {
			return sqlSessionTemplate.insert("memberJoin", map);
		}catch(Exception e) {
			return check;
		}
	}

	@Override
	public String memberGetId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberGetId",map);
	}

	@Override
	public String memberGetPwd(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberGetPwd",map);
	}
	
	@Override
	public int memberIdCheck(Map<String, String> map) {
		// TODO Auto-generated method stub
		int check=0;
		String id=sqlSessionTemplate.selectOne("memberIdCheck",map);
		if(id !=null) {
			check=1;
			
		}
		return check;
	}

	@Override
	public String memberGetPoint(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberGetPoint",map);
	}

	@Override
	public MemberDto memberGetInfo(String id) {
		return sqlSessionTemplate.selectOne("memberGetInfo",id);
	}

	@Override
	public void memberDelete(String id) {
		sqlSessionTemplate.update("memberDelete",id);
		
	}

	@Override
	public void memberUpdateInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("memberUpdateInfo",map);
		
	}



}
