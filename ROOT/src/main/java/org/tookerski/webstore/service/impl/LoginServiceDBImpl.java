package org.tookerski.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tookerski.webstore.dao.LoginDao;
import org.tookerski.webstore.model.User;
import org.tookerski.webstore.service.LoginService;

@Service
public class LoginServiceDBImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public void setUserDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public User getUser(String userName, String userPassword) {
		return loginDao.selectUser(userName, userPassword);
	}

}
