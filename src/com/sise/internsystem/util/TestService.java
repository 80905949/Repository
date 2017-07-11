package com.sise.internsystem.util;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sise.internsystem.entity.User;

@Service("testService")
public class TestService {

	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void saveTwoUsers() {
		Session session = sessionFactory.openSession();
//		session.save(new User());
//		userServic
//		// int a = 1 / 0; // 这行会抛异常
//		session.save(new User());
	}
}
