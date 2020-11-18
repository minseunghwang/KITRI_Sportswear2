package com.java.admin.memberManage.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.java.member.dto.MemberDto;

@Component
public interface AdminMemberManageDao {

	public List<MemberDto> memberList();

}
