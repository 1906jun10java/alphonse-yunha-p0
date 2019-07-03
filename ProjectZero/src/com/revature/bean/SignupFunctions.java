package com.revature.bean;
import java.util.Scanner;
import com.revature.bean.User;
import com.revature.bean.NewUser;
public class SignupFunctions {
	
	public void User(NewUser newUser) {
		
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("User:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nUser: ");
			sc.next();
		}
    	newUser.setUserName(sc.next());
    	
    	System.out.println();
	}
	
	public void Password(NewUser newUser) {
		
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("Password:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nPassword: ");
			sc.next();
		}
    	newUser.setPassword(sc.next());
    	
    	System.out.println();
	}
	public void NewPassword(NewUser newUser) {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Confirm password:  ");
			String confirm = sc.next();
			if(confirm.equals(newUser.getPassword())) {
				newUser.setConfirmPassword(true);
				System.out.println("Password confirmed");
			}
			
		}catch(Exception e) {
			System.out.println("Invalid input try again");
			
		}finally{
			System.out.println();
		}
    	
	}
	public void FirstName(NewUser newUser) {
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("First name:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nFirst name: ");
			sc.next();
		}
    	newUser.setFirstName(sc.next());
    	
    	System.out.println();
		
	}
	public void LastName(NewUser newUser) {
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("Last name:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nLast name: ");
			sc.next();
		}
    	newUser.setLastName(sc.next());
    	
    	System.out.println();
		
	}
		
	public void Save(User user, NewUser newUser) {
		if((newUser.getConfirmPassword() == true) 
			&& (newUser.getUserName() != null)
			&& (newUser.getFirstName() != null)
			&& (newUser.getLastName() != null)) {
			
			System.out.println("Saved");
			newUser.setLoop(false);
			user.setTravelTo("login");
			// save the data into the sql user sql tables
			
		}
		else {
			System.out.println("you did not fill out the menu \nwith the required feilds");
		}
    	
	}
	
	public void Exit(User user, NewUser newUser) {
		System.out.println("Exiting siginup menu");
		newUser.setLoop(false);
		user.setTravelTo("login");
		
	}
	
	

	

	

	

		
	
}
