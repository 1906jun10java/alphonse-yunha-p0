package com.revature.menu;

import java.util.Scanner;

import com.revature.bean.User;
import com.revature.bean.VariableCheck;

public class CustomerMenu{
	public User LoginCustomer(User user) {
		VariableCheck variables = new VariableCheck();
		
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
			
		//	if(variables.getLogin() == false) {
				
				System.out.println(selectionMenu);
				while(!sc.hasNextInt()) {
					System.out.println("Invalid input try again"+selectionMenu);
					sc.next();
				}
				
					variables.setMenuOption( sc.nextInt());
				
				
				switch (variables.getMenuOption()) {
		        case 1:
		        	//displays list of available cars on lot 
		        	//from the sql table
		        	System.out.print("1.car, 2.car, 3.car");
		            break;
		        case 2:
		        	//displays list of available cars previously purchased 
		        	//from the sql table

		        	System.out.print("You have no cars ");
		        	
		            break;
		        case 3:
		        	System.out.print("Which car would you like to make an offer for?");
		        	//displays list of available cars on lot 
		        	//from the sql table
		        	System.out.print("1.car, 2.car, 3.car");
		        	while(!sc.hasNextInt()) {
						System.out.println("Invalid input try again"+selectionMenu);
						sc.next();
					}
		        	variables.setCarNumber(sc.nextInt());
		        	// 
		        	//use the get method below to figure if the car actually exists in the database 
		        	// if it does then display the car using sql below.
		        	
		        	//if(car exists) {
		        		System.out.println("making an offer for "+variables.getCarNumber());
		        		System.out.println("What would you like to offer: ");
		        		System.out.print("$");
		        		while(!sc.hasNextInt()) {
							System.out.println("Invalid input try again"+selectionMenu);
							sc.next();
						}
		        		variables.setOffer(sc.nextInt());
		        		System.out.println("Thankyou, your offer will viewed by an employee shortly");
		        		//use the get method to input the offer to the database
		        //	}
		        	//else{System.out.println(that car does not exist);

		        	//}
		        	
		            
		        	break;
		        case 4:
		        	
		        	//use sql to list the remaining payment for each of the owned cars
		        	System.out.println("you own no money so far");
		            break;
		        case 5:
		        	System.out.println("Exiting");
		        	
		        	variables.setLoop(false);
		        	
		        	user.setTravelTo("login");
		        	
		            break;
		        default: 
		        	user.setCustomer(false);
		        	user.setEmployee(false);
		        	user.setUser(null);
		        	user.setPass(null);
		        	variables.setLogin(false);
		        	
		        	
		        	System.out.println("something went wrong."
		        			+ " please enter your selected options correctly");
		    }
				System.out.println("Username: "+user.getUser()+
						"\nCar: "+variables.getCarNumber()+" Offer: "+variables.getOffer()
						+"\nMenu: "+variables.getMenuOption());
			//}
			
		}
		return user;
	}

}
