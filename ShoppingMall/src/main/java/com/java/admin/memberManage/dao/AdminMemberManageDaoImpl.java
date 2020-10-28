package com.java.admin.memberManage.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.admin.product.service.AdminProductService;

@Component
public class AdminMemberManageDaoImpl implements AdminMemberManageDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

}
