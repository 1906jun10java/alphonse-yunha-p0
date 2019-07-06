	package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.User;
import com.revature.util.ConnFactory;

public class UserDAOImpl implements UserDAO {

	public List<User> getUser(){
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM USERS";
		
		try(Connection conn = ConnFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			while(rs.next()) {
				User u = new User();
				String userName = rs.getString("USER_NAME");
				u.setUserName(userName);
				
				String userPass = rs.getString("USER_PASS");
				u.setPass(userPass);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	public User getUserById(String id) {
		User u = null;
		String sql = "SELECT * FROM USERS WHERE USER_NAME = ?";
		ResultSet rs = null;
		try(Connection conn = ConnFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String userPass = rs.getString("USER_PASS");
				u = new User(userId,userName, userPass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!= null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return u;
	}

	@Override
	public User getUserById(String id, Connection conn) {
		User u = null;
		String sql = "SELECT * FROM USERS WHERE USER_NAME = ?";
		ResultSet rs = null;
		try(PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String userPass = rs.getString("USER_PASS");
				u = new User(userId,userName, userPass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!= null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return u;
	}

	@Override
	public int createUser(User user) {
		int usersCreated = 0;
		String sql = "INSERT INTO USERS(USER_NAME, USER_PASS) VALUES (?,?)";
		try(Connection conn = ConnFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPass());
			usersCreated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersCreated;
	}

	@Override
	public int userType(User user) {
		// TODO Auto-generated method stub
		return 0;
	}


}