package com.revature.menu;
import java.util.List;
import java.util.Scanner;

import com.revature.bean.Car;
import com.revature.bean.User;
import com.revature.bean.VariableCheck;
import com.revature.bean.*;
public class EmployeeMenu extends EmployeeFunctions{
	public User LoginEmployee(User user) {
		Login drive = new Login();
		VariableCheck variables = new VariableCheck();
		EmployeeFunctions employeefunctions = new EmployeeFunctions();
		Car car = new Car();
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		variables.setLogin(false);

		while (variables.getLoop() == true) {

			if (variables.getLogin() == false) {
				System.out.println("1. Add Car \n2. Remove Car \n3. Accept/Decline Offer \n4. Show remaining payments \n5. Return to Menu \n6. Exit");
				while (!sc.hasNextInt()) {
					System.out.println("1. Add Car \n2. Remove Car \n3. Accept/Decline Offer \n4. Return to Menu \n5, Exit");
					sc.next();
				}

				variables.setMenuOption(sc.nextInt());

				switch (variables.getMenuOption()) {
				case 1:
					employeefunctions.addCarToLot();
			
					/*
					 * Add car by year manufactured, Make of the car, and model of the car.
					 */
					break;
				case 2:
					employeefunctions.removeCarFromLot();
					/*
					 * remove car using sql statement.
					 * Depending on how to delete could be by IDS or Name of the car.
					 * 
					 */
					break;
				case 3:
					employeefunctions.offerDecide();
					/*
					 * add another menu to show offers and to accept or decline them. 
					 */
					break;
				case 4:
					employeefunctions.viewPayments();
					break;
				case 5:
					employeefunctions.returnToMenu();
					/*
					 * Return to the menu.
					 */
					break;
				case 6:
					employeefunctions.exitProgram();
					break;
					
				/*
				case 5:
					System.out.print("Enter");
					if ((variables.getEmployee() == true || variables.getCustomer() == true)
							&& variables.getUser() != null && variables.getPass() != null) {
						// check the table of either employee or customer
						// and compare the username and password
						// then set loops to false
						variables.setLoop(false);
					}
					// call or maker function here to compare the
					// usernames and password in the employee/customer table	
					break;
				*/
				
				default:
					user.setCustomer(false);
					user.setEmployee(true);
					user.setUser(null);
					user.setUser(null);
					variables.setLogin(false);

					System.out.println("Something went wrong. Please enter your selected options correctly.");
					System.out.println("====================================================================");
				}
				}
			}
		return user;
	}



}
