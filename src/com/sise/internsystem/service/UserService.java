package com.sise.internsystem.service;

import com.sise.internsystem.base.DaoSupport;
import com.sise.internsystem.entity.User;

public interface UserService extends DaoSupport<User> {
	public User findByLoginNameAndPassword(String loginName, String password,String role);
}
