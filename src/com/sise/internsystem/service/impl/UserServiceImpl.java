package com.sise.internsystem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sise.internsystem.base.DaoSupportImpl;
import com.sise.internsystem.entity.User;
import com.sise.internsystem.service.UserService;

@Service
@Transactional 
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {
	public User findByLoginNameAndPassword(String loginName, String password,String role) {
		// 使用密码的MD5摘要进行对比
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.no=? AND u.pwd=? AND role=?")//
				.setParameter(0, loginName)//
				.setParameter(1, password)//
				.setParameter(2, role)
				.uniqueResult();
	}
}
