package com.revature.employee;

import java.util.Scanner;
import com.revature.menu.*;

public class EmployeeMenu {
	
	public void EmployeeMenu() {
		EmployeeMenu drive2 = new EmployeeMenu();
		VariableCheck variables = new VariableCheck();
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		variables.setLogin(false);

		while (variables.getLoop() == true) {

			if (variables.getLogin() == false) {
				System.out.println("1. Add Car \n2. Remove Car \n3. Accept/Decline Offer");
				while (!sc.hasNextInt()) {
					System.out.println(
							"1. Add Car \n2. Remove Car \n3. Accept/Decline Offer");
					sc.next();
				}

				variables.setMenuOption(sc.nextInt());

				switch (variables.getMenuOption()) {
				case 1:
					System.out.println("Added Car");
					break;
				case 2:
					System.out.println("Removed Car");
					break;
				case 3:
					System.out.println("Accepted/Declined Offer");
					break;
				case 4:
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
				default:
					variables.setCustomer(false);
					variables.setEmployee(false);
					variables.setUser(null);
					variables.setUser(null);
					variables.setLogin(false);

					System.out.println("something went wrong." + " please enter your selected options correctly");
				}
				System.out.println(
						"username: " + variables.getUser() + " password: " + variables.getPass() + "\nemployee: "
								+ variables.getEmployee() + " custumer: " + variables.getCustomer() + "\nenter: ");
			}

		}
	}
}
