package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.bean.User;

public interface UserDAO {
	
	public List<User> getUser();
	public User getUserById(String id);
	public User getUserById(String id, Connection conn);
	public int createUser(User user);
	public int userType(User user);
}
