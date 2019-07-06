package com.revature.bean;

public class User {
	protected int userId;
	protected String userName;
	protected String userPass;
	
	public User() {
		super();
	}
	public User(int userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the pass
	 */
	public String getUserPass() {
		return userPass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String userPass) {
		this.userPass = userPass;
	}

}