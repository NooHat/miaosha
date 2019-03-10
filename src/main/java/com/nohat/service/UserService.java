package com.nohat.service;

import com.nohat.dao.UserDao;
import com.nohat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public User getUserById(int id) {
		 return userDao.getUserById(id);
	}

	@Transactional
	public boolean addUser() {
		User u1= new User();
		u1.setId(2);
		u1.setName("2222");
		userDao.AddUser(u1);
		User u2= new User();
		u2.setId(1);
		u2.setName("11111");
		userDao.AddUser(u2);
		return true;
	}
	
}
