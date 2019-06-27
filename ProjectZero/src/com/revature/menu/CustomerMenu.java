package com.revature.menu;

import java.util.Scanner;
import com.revature.bean.CustomerFunctions;
import com.revature.bean.User;
import com.revature.bean.VariableCheck;

public class CustomerMenu{
	public User LoginCustomer(User user) {
		VariableCheck variables = new VariableCheck();
		CustomerFunctions customer = new CustomerFunctions();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		variables.setLoop(true);
		//variables.setLogin(false);
		String selectionMenu = (""
				+ "1. View cars on lot "
				+ "\n2. View my cars"
				+ "\n3. Make an offer "
				+ "\n4. View remaining payment foreach of your car(s)   "
				+ "\n5. Exit");
		while(variables.getLoop() == true) {
				
				System.out.println(selectionMenu);
				while(!sc.hasNextInt()) {
					System.out.println("Invalid input try again"+selectionMenu);
					sc.next();
				}
				
					variables.setMenuOption( sc.nextInt());
				
				
				switch (variables.getMenuOption()) {
		        case 1:
		        	customer.ViewCarLot();
		            break;
		        case 2:
		        	customer.ViewMyCars();
		            break;
		        case 3:
		        	customer.MakeAnOffer(variables);
		        	break;
		        case 4:
		        	customer.ViewCarPaymentDetails();
		            break;
		        case 5:
		        	System.out.println("Exiting");
		        	
		        	variables.setLoop(false);
		        	
		        	user.setTravelTo("login");
		        	
		            break;
		        default: 
		        	customer.ResetUserValues(user, variables);
		    }
				
				System.out.println("Username: "+user.getUser()+
						"\nCar: "+variables.getCarNumber()+" Offer: "+variables.getOffer()
						+"\nMenu: "+variables.getMenuOption());
			
			
		}
		return user;
	}

}
