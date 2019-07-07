package com.revature.bean;

public class User {
	protected String userName;
	protected String userPass;
	protected boolean employee;
	protected boolean customer;
	protected String travelTo ;
	private int userId;
	private String empCust;
	private int car_id;
	private int user_id;
	private int offer_price;
	private int offer_id;
	private int owned_amount_left;
	
	public int getOwned_amount_left() {
		return owned_amount_left;
	}
	public void setOwned_amount_left(int owned_amount_left) {
		this.owned_amount_left = owned_amount_left;
	}
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
	public void setType(String empCust) {
		this.empCust = empCust;
		
	}
	public String getType() {
		return empCust;
		
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOffer_price() {
		return offer_price;
	}
	public void setOffer_price(int offer_price) {
		this.offer_price = offer_price;
	}
	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}

}
