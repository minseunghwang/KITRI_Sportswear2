package com.java.admin.memberManage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.java.member.dto.MemberDto;

@Component
public interface AdminMemberManageDao {

	public List<MemberDto> memberList();

	public MemberDto memberSelect(String id);

	public void memberManagementPopupEdit(MemberDto memberDto);

	public void memberManagementPopupDelete(Map<String, Object> hmap);

}
