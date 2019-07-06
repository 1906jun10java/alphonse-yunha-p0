package com.revature.drive;

import java.io.IOException;
import java.util.Scanner;

import com.revature.bean.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.util.ConnFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		boolean loggedIn = false;
		boolean isCustomer = false;

		UserDAO uD = new UserDAOImpl();
		User client = new User();
		String userName = "";
		String userPass = "";
		int userId = 1;

		while (true) {
			System.out.println("1. Signup(New Users)");
			System.out.println("2. Login as Employee");
			System.out.println("3. Exit");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					System.out.println("Please enter a Username: ");
					userName = sc.nextLine();

					if (uD.getUser().contains(uD.getUserById(userName))) {
						System.out.println("Username Taken. Please try again.");
					}
					System.out.println("Please enter a Password: ");
					userPass = sc.nextLine();
					client = new User(userId, userName, userPass);
					uD.createUser(client);
					isCustomer = true;
					break;
				case 2:
					if(!loggedIn) {
						System.out.println("Enter your Username: ");
						userName = sc.nextLine();
						System.out.println("Enter your Password: ");
						userPass = sc.nextLine();
					}
					if(uD.getUser().contains(uD.getUserById(userName)) && uD.getUserById(userName).getUserPass().equals(userPass)) {
						isCustomer = true;
						loggedIn = true;
					}
					
					
				default:
					break;
				}
			} catch (NumberFormatException e) {
			}
		}
	}

}
