package com.revature.bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.revature.bean.User;
import com.revature.util.ConnFactory;
import com.revature.bean.NewUser;
public class SignupFunctions {
	
	public void User(NewUser newUser) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("User:  ");
    	while(!sc.hasNext()) {
			System.out.println("Invalid input try again\nUser: ");
			sc.next();
		}
    	newUser.setUserName(sc.next());
    	
    	System.out.println();
    	
    	
    	
//    	Connection conn = ConnFactory.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");//WHERE user_name = '"+newUser.getUserName()+"'
//		ResultSetMetaData rsmd = rs.getMetaData();
//		int columnsNumber = rsmd.getColumnCount();
//		String colName;
//		
//		
//		while (rs.next()) {
//			for (int i = 1; i <= columnsNumber; i++) {
//				colName = rsmd.getColumnName(i);
//				System.out.print(colName+" ["+rs.getString(i) + "] ");
//			}
//			System.out.println();
//			
//		}
		
    //	SELECT user_name FROM USERS WHERE user_name = 'ooo';
    	
    	
		//System.out.println(stmt.getResultSet()+"found it ****************");
		//rs.getString(i);
    	
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
	public void userType(NewUser newUser) {
		String secret = null;
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("Are you an employee(1) or customer(2)");
    	
    	while(!sc.hasNextInt()) {
			System.out.println("Invalid input try again\nPassword: ");
			sc.next();
		}
    	int custEmp = sc.nextInt();
    	if(custEmp == 1) {
    		newUser.setEmployee(true);
    		newUser.setCustomer(false);
    	}
    	else if(custEmp == 2) {
    		newUser.setCustomer(true);
    		newUser.setEmployee(false);
    	}
    	else {
    		System.out.println("That was not one of the options");
    	}
    	
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
		
	public void Save(User user, NewUser newUser) throws SQLException {
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
		Connection conn = ConnFactory.getConnection();
		Statement stmt = conn.createStatement();
		String custemp;
		if(newUser.getCustomer() == true) {
			 custemp = "Customer";
			
		}
		else if(newUser.getEmployee() == true) {
			 custemp = "Employee";
		}
		else {
			 custemp = "none";

		}
		stmt.executeQuery("INSERT INTO USERS(USER_NAME, USER_PASS, USER_TYPE) VALUES('"+newUser.getUserName()+"','"+newUser.getPassword()+"','"+custemp+"')");
    	
	}
	
	public void Exit(User user, NewUser newUser) {
		System.out.println("Exiting siginup menu");
		newUser.setLoop(false);
		user.setTravelTo("login");
		
	}
	
	

	

	

	

		
	
}
