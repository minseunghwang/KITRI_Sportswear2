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
	public List<MemberDto> memberList(int startRange, int endRange) {
		Map<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("startPage", startRange);
		hMap.put("endPage", endRange);
		return sqlSessionTemplate.selectList("memberList", hMap);
	}

}
