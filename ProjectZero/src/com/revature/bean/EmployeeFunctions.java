package com.revature.bean;

public class EmployeeFunctions {
	public void addCarToLot(User user) {
		System.out.println("Add Car.");
	}
	public void removeCarFromLot(User user) {
		System.out.println("Removed.");
	}
	public void offerDecide(User user) {
		System.out.println("Accept/Decline");
	}
	public void viewPayments(User user) {
		System.out.println("View payments");
	}
/*	public void returnToMenu(User user) {
		System.out.println("Returned To Menu");
	}*/
	public void exitProgram(VariableCheck variable, User user) {
		user.setTravelTo("login");
		variable.setLoop(false);
		System.out.println("exiting.");
		//System.exit(0);
	}


}
