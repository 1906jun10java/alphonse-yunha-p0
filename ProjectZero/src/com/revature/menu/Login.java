package com.revature.menu;

import java.util.Scanner;

import com.revature.bean.User;
import com.revature.bean.VariableCheck;

public class  Login extends VariableCheck{


	public User LoginPage() {
		VariableCheck variables = new VariableCheck();
		User user = new User();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		variables.setLogin(false);
		String selectionMenu = "1. Username & Password"
							+ "\n2. employee "
							+ "\n3. customer   "
							+ "\n4. to enter";
		while(variables.getLoop() == true) {
			
			//if(variables.getLogin() == false) {
				System.out.println(selectionMenu);
				while(!sc.hasNextInt()) {
					System.out.println("Invalid input try again \n"+selectionMenu);
					sc.next();
				}
				
					variables.setMenuOption( sc.nextInt());
				
				
				switch (variables.getMenuOption()) {
		        case 1:
		        	System.out.print("User: ");
		        	user.setUser(sc.next());
		        	System.out.print("Password: ");
		        	user.setPass(sc.next());
		            break;
		        case 2:
		        	user.setEmployee(true);
		        	user.setCustomer(false);
		        	System.out.println("you are an employee");
		            break;
		        case 3:
		        	user.setEmployee(false);
		        	user.setCustomer(true);
		        	System.out.println("you are a customer");
		            break;
		        case 4:
		        	System.out.print("Enter");
		        	if((user.getEmployee() == true || user.getCustomer() == true) && user.getUser() != null && user.getPass() != null) {
		        		//check the table of either employee or customer
		        		//and compare the username and password
		        		//then set loops to false
		        		
		        		variables.setLoop(false);
		        		if (user.getCustomer() == true ) {
		        			user.setTravelTo("employee");
		        		}
		        		if (user.getEmployee() == true ) {
		        			user.setTravelTo("customer");
		        		}
		        		
		        		
		        		
		        	}
		        	//call or maker function here to compare the 
		        	//usernames and password in the employee/customer table
		        	
		            break;
		        default: 
		        	//variables.setCustomer(false);
		        	//variables.setEmployee(false);
		        	//variables.setUser(null);
		        	//variables.setPass(null);
		        	//svariables.setLogin(false);
		        	
		        	
		        	System.out.println("something went wrong."
		        			+ " please enter your selected options correctly");
		    }
				System.out.println("Username: "+user.getUser()+" Password: "+user.getPass()+
						"\nEmployee: "+user.getEmployee()+" Custmer: "+user.getCustomer()+
						"\nMenu: "+variables.getMenuOption());
		//	}
			
		}
		return user;
	}
	

}
