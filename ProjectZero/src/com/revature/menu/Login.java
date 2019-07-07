package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bean.LoginFunctions;
import com.revature.bean.User;
import com.revature.bean.VariableCheck;
import com.revature.dao.UserDAOImpl;

public class  Login extends VariableCheck{


	

	public User LoginPage() {
		boolean success = false;
		VariableCheck variables = new VariableCheck();
		User user = new User();
		LoginFunctions log = new LoginFunctions();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		variables.setLogin(false);
		String userName = "";
		String userPass = "";
		String selectionMenu = "1. Enter login credentials"
							+ "\n2. Login"
							+ "\n3. signup";
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
		        	System.out.println("Enter Username: ");
		        	userName = sc.nextLine();
		        	userName = sc.nextLine();
		        	System.out.println("Enter Password: ");
		        	userPass = sc.nextLine();
		        	user.setUser(userName);
		        	user.setPass(userPass);
		        	System.out.println("Are you a customer(1) or an employee(2)");
		        	while(!sc.hasNextInt()) {
						System.out.println("Invalid input try again \n"+selectionMenu);
						sc.next();
					}
		        	int empCust = sc.nextInt();
		        	if(empCust == 2)
		        	{
		        		user.setEmployee(true);
			        	user.setCustomer(false);
			        	System.out.println("you are an employee");
			        
		        	}
		        	if(empCust == 1) {
		        		user.setEmployee(false);
			        	user.setCustomer(true);
			        	System.out.println("you are a customer");
			           
		        	}
		        	else {
		        		System.out.println("That was not one of the options");
		        	}
		        	
		        	
		        	
		        	if(UserDAOImpl.loginConfirm(user.getUser(), user.getPass()) == true) {
		        		System.out.println("Login successful!");
		        		success = true;
		        	}
		        	else {
		        		System.out.println("Login not successful.");
		        	}
		        	
		        	
		            break;
		     
		        case 2:
		        	System.out.print("Enter");
		        	if((user.getEmployee() == true || user.getCustomer() == true) && user.getUser() != null && user.getPass() != null && success ==true) {
		        		//check the table of either employee or customer
		        		//and compare the username and password
		        		//then set loops to false
		        		try {
		        			
							if(log.checkLoginEmployee(user) == true) {
								variables.setLoop(false);
								if (user.getCustomer() == true ) {
									user.setTravelTo("employee");
									
								}
								if (user.getEmployee() == true ) {
									user.setTravelTo("customer");
								}
								
							}
							else {
								System.out.println("");
							}
							
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        		
		        		
		        		
		        		
		        	}
		        	//call or maker function here to compare the 
		        	//usernames and password in the employee/customer table
		        	
		            break;
		            
		        case 3:
		        	user.setTravelTo("signup");
		        	variables.setLoop(false);
		        	user.setCustomer(false);
		        	System.out.println("you are an employee");
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
				System.out.println("Username: "+ user.getUser()+" Password: "+user.getPass()+
						"\nEmployee: "+user.getEmployee()+" Custmer: "+user.getCustomer()+
						"\nMenu: "+variables.getMenuOption());
		//	}
			
		}
		return user;
	}
	

}