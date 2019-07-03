package com.revature.menu;

import java.util.Scanner;

import com.revature.bean.NewUser;
import com.revature.bean.SignupFunctions;
import com.revature.bean.User;


public class SignupMenu{
	public User signinNewUser(User user) {
		NewUser newUser = new NewUser();
		SignupFunctions signin = new SignupFunctions();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		newUser.setLoop(true);
		//variables.setLogin(false);
		String selectionMenu = (""
				+ "1. Enter a new username(must be unique)"
				+ "\n2. Enter a new password "
				+ "\n3. confirm password "
				+ "\n4. First name   "
				+ "\n5. Last name   "
				+ "\n6. Save & exit"
				+ "\n7. Exit");
		while(newUser.getLoop() == true) {
				
				System.out.println(selectionMenu);
				while(!sc.hasNextInt()) {
					System.out.println("Invalid input try again"+selectionMenu);
					sc.next();
				}
				
				newUser.setMenuOption( sc.nextInt());
				
				
				switch (newUser.getMenuOption()) {
		        case 1:
		        	signin.User(newUser);
		            break;
		        case 2:
		        	signin.Password(newUser);
		            break;
		        case 3:
		        	signin.NewPassword(newUser);
		        	break;
		        case 4:
		        	signin.FirstName(newUser);
		            break;
		        case 5:
		        	signin.LastName(newUser);
		            break;
		        case 6:
		        	signin.LastName(newUser);
		            break;
		        case 7:
		        	signin.Save(user, newUser);
		            break;
		        case 8:
		        	signin.Exit(user, newUser);
		            
		        default: 
		        	System.out.println("You did not choose one of the selections");
		        	
		    }
				
				System.out.println(""
						+"\nUsername: "+newUser.getUserName()
						+"\n Password: "+newUser.getPassword()
						+"\nPassword confirmed: "+newUser.getConfirmPassword()
						+"\nFirst name: "+newUser.getFirstName()
						+"\nLast name: "+newUser.getLastName());
		}
		return user;
	}

}