package com.java.admin.memberManage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.member.dto.MemberDto;

@Component
public class AdminMemberManageDaoImpl implements AdminMemberManageDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<MemberDto> memberList() {
		return sqlSessionTemplate.selectList("memberList");
	}

	@Override
	public MemberDto memberSelect(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("member_read",id);
	}

	@Override
	public void memberManagementPopupEdit(MemberDto memberDto) {
		sqlSessionTemplate.update("member_edit", memberDto);
	}

	@Override
	public void memberManagementPopupDelete(Map<String, Object> hmap) {
		sqlSessionTemplate.delete("member_delete", hmap);
	}

}
