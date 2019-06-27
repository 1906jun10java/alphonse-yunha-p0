package com.revature.menu;

import com.revature.employee.*;

public class CarAppMain{

	public static void main(String[] args) {
		//turn methods for menus to return types
		CarApp();
		
	}
	public static void CarApp() {
		//VariableCheck variables = new VariableCheck();
		
		boolean continueLoop = true;
	//	if(variables.getTravelTo() == null) {
	//		variables.setTravelTo("login");
	//	}
		Login login = new Login();
		User user = login.LoginPage();
		
	//	System.out.println(user.getUser()+"###########################");
		
		
		
		while(continueLoop == true) {
	//		System.out.println(variables.getTravelTo());
			if(user.getTravelTo().equals("login")) {
				Login newLogin = new Login();
				user = newLogin.LoginPage();
			}
			else if(user.getCustomer() == true) {
				CustomerHome customer = new CustomerHome();
				customer.LoginCustomer(user);
			}
			else if(user.getEmployee() == true) {
				EmployeeMenu employee = new EmployeeMenu();
				employee.LoginEmployee(user);
			}
		}
		
		
	}


}
