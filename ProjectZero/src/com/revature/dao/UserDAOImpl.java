	package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bean.CustomerFunctions;
import com.revature.bean.Offer;
import com.revature.bean.Owned;
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
				u.setUser(userName);
				
				String userPass = rs.getString("USER_PASS");
				u.setPass(userPass);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
public List<User> getUserid(User user){
		
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM USERS";
		
		try(Connection conn = ConnFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			while(rs.next()) {
				
				int userId = rs.getInt("USER_ID");
				
				user.setUser_id(userId);
				
				System.out.println(user.getUser_id()+"******************");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	
//	public List<Owned> getOwnedList() throws SQLException {
//		List<Owned> ownedList = new ArrayList<Owned>();
//		Connection conn = ConnFactory.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM OWNED");
//		ResultSetMetaData rsmd = rs.getMetaData();
//		int columnsNumber = rsmd.getColumnCount();
//		String colName;
//		
//		Owned s = null;
//		while (rs.next()) {
//			for (int i = 1; i <= columnsNumber; i++) {
//				colName = rsmd.getColumnName(i);
//				System.out.print(colName+" ["+rs.getString(i) + "] ");
//			}
//			System.out.println();
//			ownedList.add(s);
//		}
//		return ownedList;	
//	}
	
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
			ps.setString(1, user.getUser());
			ps.setString(2, user.getPass());
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
	
	public static boolean loginConfirm(String userName, String userPass) {
		List<User> userList = new ArrayList<>();
		try(Connection conn = ConnFactory.getConnection();){
			String sql = "SELECT * FROM USERS";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUser(rs.getString(2));
				temp.setPass(rs.getString(3));
				userList.add(temp);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			e.printStackTrace();
		}
		for(User u : userList ) {
			if(u.getUser().equals(userName) && u.getPass().equals(userPass)) {
				return true;
			}
		}
		
		return false;
		
	}
	public void retreiveUserId(User user) {

		try(Connection conn = ConnFactory.getConnection();){
			String sql = "SELECT USER_ID, USER_NAME FROM USERS";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String user_name = rs.getString("USER_NAME");
				int user_id = rs.getInt("USER_ID");
				if(user_name.equals(user.getUser())) {
					user.setUserId(user_id);
				}
			}	
		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			e.printStackTrace();
		}

	}
	public void removeCarFromLot() {
		Scanner scanner = new Scanner(System.in);
		int remove = scanner.nextInt();
		CustomerFunctions customer = new CustomerFunctions();
		customer.ViewCarLot();
		int usersCreated = 1;
		String sql = "DELETE FROM LOT WHERE CAR_ID = ? ;";
		try(Connection conn = ConnFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, remove);
			usersCreated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
		}
		

		
	}
		
		

	

