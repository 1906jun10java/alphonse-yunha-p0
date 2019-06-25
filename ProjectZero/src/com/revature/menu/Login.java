package com.revature.menu;

import java.util.Scanner;

public class  Login {


	public void LoginPage() {
		VariableCheck variables = new VariableCheck();
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		variables.setLogin(false);
		
		while(variables.getLoop() == true) {
			
			if(variables.getLogin() == false) {
				System.out.println("1. Username \n2. Password\n3. employee \n4. customer   \n5. to enter");
				while(!sc.hasNextInt()) {
					System.out.println("Invalid input try again \n1. Username \n2. Password\n3. employee \n4. customer   \n5. to enter");
					sc.next();
				}
				
					variables.setMenuOption( sc.nextInt());
				
				
				switch (variables.getMenuOption()) {
		        case 1:
		        	System.out.print("User: ");
		        	variables.setUser(sc.next());
		            break;
		        case 2:
		        	System.out.print("Password: ");
		        	variables.setPass(sc.next());
		            break;
		        case 3:
		        	variables.setEmployee(true);
		        	variables.setCustomer(false);
		        	System.out.println("you are an employee");
		            break;
		        case 4:
		        	variables.setEmployee(false);
		        	variables.setCustomer(true);
		        	System.out.println("you are a customer");
		            break;
		        case 5:
		        	System.out.print("Enter");
		        	if((variables.getEmployee() == true || variables.getCustomer() == true) && variables.getUser() != null && variables.getPass() != null) {
		        		//check the table of either employee or customer
		        		//and compare the username and password
		        		//then set loops to false
		        		variables.setLoop(false);
		        	}
		        	//call or maker function here to compare the 
		        	//usernames and password in the employee/customer table
		        	
		            break;
		        default: 
		        	variables.setCustomer(false);
		        	variables.setEmployee(false);
		        	variables.setUser(null);
		        	variables.setUser(null);
		        	variables.setLogin(false);
		        	
		        	
		        	System.out.println("something went wrong."
		        			+ " please enter your selected options correctly");
		    }
				System.out.println("username: "+variables.getUser()+" password: "+variables.getPass()+
						"\nemployee: "+variables.getEmployee()+" custumer: "+variables.getCustomer()+"\nenter: ");
			}
			
		}
	}
	

}
