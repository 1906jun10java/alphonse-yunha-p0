package com.revature.employee;

import java.util.Scanner;
import com.revature.menu.*;

public class EmployeeMenu {

	public void EmployeeMenu() {
		Login drive = new Login();
		VariableCheck variables = new VariableCheck();
		Car car = new Car();
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		variables.setLogin(false);

		while (variables.getLoop() == true) {

			if (variables.getLogin() == false) {
				System.out.println("1. Add Car \n2. Remove Car \n3. Accept/Decline Offer \n4. Return to Menu \n5. Exit");
				while (!sc.hasNextInt()) {
					System.out.println("1. Add Car \n2. Remove Car \n3. Accept/Decline Offer \n4. Return to Menu \n5, Exit");
					sc.next();
				}

				variables.setMenuOption(sc.nextInt());

				switch (variables.getMenuOption()) {
				case 1:
					System.out.println("Enter year manufactured: ");
					car.setYearManufactured(sc.nextInt());
					System.out.println("Enter make of car: ");
					car.setMake(sc.next());
					System.out.println("Enter model of car:");
					car.setModel(sc.next());
					break;
				case 2:
					System.out.println("Removed Car");
					break;
				case 3:
					System.out.println("Accepted/Declined Offer");
					break;
				case 4:
					System.out.println("Returned to Menu");
					break;
				case 5:
					System.out.println("Good bye.");
					System.exit(0);
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
					variables.setCustomer(false);
					variables.setEmployee(false);
					variables.setUser(null);
					variables.setUser(null);
					variables.setLogin(false);

					System.out.println("something went wrong." + " please enter your selected options correctly");
				}
				if(variables.getMenuOption() == 1) {
				System.out.println(
						"Year: " + car.getYearManufactured() + " Make: " + car.getMake() + " Model: " + car.getModel());
				}
				else if(variables.getMenuOption() == 2) {
					System.out.println("TESTTTTTTTTTTTTTTTTTT 2");
				}else if (variables.getMenuOption() == 3){
					System.out.println("TESETTTTTETETETETTTT 3");
				}else if (variables.getMenuOption() == 4) {
					drive.LoginPage();
				}
			}

		}
	}
}
