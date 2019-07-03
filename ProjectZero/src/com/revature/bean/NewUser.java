package com.revature.bean;

public class NewUser {

	private boolean loop;
	private int menuOption;
	private String userName;
	private String password;
	private boolean confirmPassword;
	private String firstName;
	private String LastName;

	public boolean getLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public int getMenuOption() {
		return menuOption;
	}

	public void setMenuOption(int menuOption) {
		this.menuOption = menuOption;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(boolean confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

}
