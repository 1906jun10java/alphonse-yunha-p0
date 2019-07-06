package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bean.LoginFunctions;
import com.revature.bean.User;
import com.revature.bean.VariableCheck;
import com.revature.dao.UserDAOImpl;

public class  Login extends VariableCheck{


	public User LoginPage() {
		VariableCheck variables = new VariableCheck();
		User user = new User();
		LoginFunctions log = new LoginFunctions();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		variables.setLogin(false);
		String userName = "";
		String userPass = "";
		String selectionMenu = "1. Username & Password"
							+ "\n2. employee "
							+ "\n3. customer   "
							+ "\n4. to enter"
							+ "\n5. to signup";
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
		        	
		        	if(UserDAOImpl.loginConfirm(userName, userPass) == true) {
		        		System.out.println("Login successful!");
		        	}else {
		        		System.out.println("Login not successful.");
		        	}
		        	
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
		            
		        case 5:
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
