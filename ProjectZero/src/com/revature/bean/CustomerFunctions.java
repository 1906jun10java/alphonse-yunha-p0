package com.revature.bean;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bean.VariableCheck;
import com.revature.dao.UserDAOImpl;
public class CustomerFunctions {
	EmployeeFunctions ef = new EmployeeFunctions();
	UserDAOImpl userDao = new UserDAOImpl();
	public void ViewCarLot() {
		//displays list of available cars on lot 
    	//from the sql table
		try {
			ef.getCarList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//System.out.println("1.car, 2.car, 3.car");
	}
	
	public void ViewMyCars(User user) throws SQLException {
		//displays list of available cars previously purchased 
    	//from the sql table
		userDao.getUserid(user);
		ef.getMyOwnedList(user);

    	//System.out.println("You have no cars ");
	}
	
	public void MakeAnOffer(User user, CustomerFunctions customer, VariableCheck variables) {
		Scanner sc = new Scanner(System.in);
		
		//INSERT INTO "JUNGYUNHA"."OWNED" (CAR_ID, USER_ID, OWNED_AMOUNT_LEFT) VALUES ('23', '5', '600')

		customer.ViewCarLot();
		userDao.retreiveUserId(user);
		
		try {
			System.out.println();
			System.out.print("Select a CAR_ID for your offer... \nOffer:");
			int carId = sc.nextInt();
			System.out.println("Make an offer for the car");
			int offer = sc.nextInt();
			
			ef.setOffer(offer, user, carId);
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
			
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
