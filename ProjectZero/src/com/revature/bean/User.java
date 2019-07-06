package com.revature.bean;

public class User {
	protected String userName;
	protected String userPass;
	protected boolean employee;
	protected boolean customer;
	protected String travelTo ;
	private int userId;
	
	public User() {
		super();
	}
	public User(int userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public String getUser() {
		return userName;
	}
	public void setUser(String user) {
		this.userName = user;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return userPass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.userPass = pass;
	}
	/**
	 * @return the employee
	 */
	public boolean getEmployee() {
		return employee;
	}
	public void setEmployee(boolean employee) {
		this.employee = employee;
	}
	/**
	 * @return the customer
	 */
	public boolean getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(boolean customer) {
		this.customer = customer;
	}
	public String getTravelTo() {
		return travelTo;
	}
	/**
	 * @param travelTo the travelTo to set
	 */
	public void setTravelTo(String travelTo) {
		this.travelTo = travelTo;
	}
	public int getUserId() {
		
		return userId;
	}
	public void setUserId(int userId) {
		
		this.userId = userId;
	}
}
