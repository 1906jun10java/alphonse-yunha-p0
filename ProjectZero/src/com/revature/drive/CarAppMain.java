package com.revature.drive;

import com.revature.bean.User;
import com.revature.menu.CustomerHome;
import com.revature.menu.CustomerMenu;
import com.revature.menu.EmployeeMenu;
import com.revature.menu.Login;

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
				CustomerMenu customer = new CustomerMenu();
				customer.LoginCustomer(user);
			}
			else if(user.getEmployee() == true) {
				EmployeeMenu employee = new EmployeeMenu();
				employee.LoginEmployee(user);
			}
		}
		
		
	}


}
