package org.tookerski.webstore.service;

import org.tookerski.webstore.model.User;

public interface LoginService {

	public User getUser(String userName, String userPassword);
	
}
