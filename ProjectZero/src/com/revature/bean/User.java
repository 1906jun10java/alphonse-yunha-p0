package com.revature.bean;

public class User {
	protected String user;
	protected String pass;
	protected boolean employee;
	protected boolean customer;
	protected String travelTo ;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
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
}
