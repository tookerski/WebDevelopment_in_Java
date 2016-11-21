package org.tookerski.webstore.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tookerski.webstore.model.User;



public interface LoginDao {

	@Select("select id, username, password, usertype, nickname from person where userName=#{userName} and password=#{password}")
	public User selectUser(@Param("userName") String userName, @Param("password") String password);
	
}
