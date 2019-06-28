package com.revature.bean;
import java.util.Scanner;

import com.revature.bean.VariableCheck;
public class CustomerFunctions {
	public void ViewCarLot() {
		//displays list of available cars on lot 
    	//from the sql table
    	System.out.println("1.car, 2.car, 3.car");
	}
	
	public void ViewMyCars() {
		//displays list of available cars previously purchased 
    	//from the sql table

    	System.out.println("You have no cars ");
	}
	
	public Object MakeAnOffer(VariableCheck variables) {
		String selectionMenu = (""
				+ "1. View cars on lot "
				+ "\n2. View my cars"
				+ "\n3. Make an offer "
				+ "\n4. View remaining payment foreach of your car(s)   "
				+ "\n5. Exit");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Which car would you like to make an offer for?");
    	//displays list of available cars on lot 
    	//from the sql table
    	System.out.println("1.car, 2.car, 3.car");
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
			return variables;
    	//}
	}
	
	public void ViewCarPaymentDetails() {
		//use sql to list the remaining payment for each of the owned cars
    	System.out.println("you own no money so far");
	}
	
	public void ResetUserValues(User user, VariableCheck variables) {
		user.setCustomer(false);
    	user.setEmployee(false);
    	user.setUser(null);
    	user.setPass(null);
    	variables.setLogin(false);
    	
    	
    	System.out.println("something went wrong."
    			+ " please enter your selected options correctly");
		
	}
	
	public void Exit(User user, VariableCheck variables) {
		System.out.println("Exiting");
    	variables.setLoop(false);
    	user.setTravelTo("login");
	}

		
	
}
