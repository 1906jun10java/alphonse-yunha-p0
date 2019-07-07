package com.revature.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.CarDAO;
import com.revature.dao.CarDAOImpl;
import com.revature.bean.Offer;
import com.revature.dao.*;
import com.revature.dao.UserDAOImpl;



import com.revature.util.ConnFactory;

public class EmployeeFunctions {
	protected Car car = new Car();
	int yearManufactured;
	String carMake;
	String carModel;
	int carId = 0;
	UserDAOImpl userDao = new UserDAOImpl();
	CarDAO cd = new CarDAOImpl();
	int userId = 1;
	Scanner sc = new Scanner(System.in);
	public static ConnFactory cf = ConnFactory.getInstance();
	

	public void addCarToLot(Car car) {
		System.out.println("Enter year manufactured: ");
		yearManufactured = sc.nextInt();

		System.out.println("Enter car make: ");
		carMake = sc.nextLine();
		carMake = sc.nextLine();

		System.out.println("Enter car model: ");
		carModel = sc.nextLine();

		car = new Car(userId, yearManufactured, carMake, carModel);
		try {
			cd.addCarToLot(car);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removeCarFromLot(Car car) {
		System.out.println("Enter CarID:  ");
		carId = sc.nextInt();
		car = new Car(carId, yearManufactured, carMake, carModel);
		try {
			cd.removeCarFromLot(car);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void offerDecide(User user) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("would you like to reject(1) or accept(2) an offer");
		try {
			int decide = sc.nextInt();
			if(decide == 1) {
				System.out.println("Which Offer_id do you wish to reject");
				int reject = sc.nextInt();
				rejectOffer(reject);
			}
			else if (decide == 2) {
				System.out.println("Which Offer_id do you wish to accept");
				int accept = sc.nextInt();
				retreiveCarUserAmount(user, accept);
				acceptOffer(user.getCar_id(), user.getUser_id(), user.getOffer_price());
				rejectOffer(accept);
				
			}
			else {
				System.out.println("That was not one of the options");
			}
		}catch(Exception e) {
			
		}
		
		System.out.println("Accept/Decline");
	}

	public void viewPayments(User user) {
		System.out.println("View payments");
	}

	/*
	 * public void returnToMenu(User user) { System.out.println("Returned To Menu");
	 * }
	 */
	public void exitProgram(VariableCheck variable, User user) {
		user.setTravelTo("login");
		variable.setLoop(false);
		System.out.println("exiting.");
		// System.exit(0);
	}



	public List<Car> getCarList() throws SQLException {
		List<Car> carList = new ArrayList<Car>();
		Connection conn = ConnFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LOT");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		String colName;
		
		Car s = null;
		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				colName = rsmd.getColumnName(i);
				System.out.print(colName+" ["+rs.getString(i) + "] ");
			}
			System.out.println();
			carList.add(s);
		}
		return carList;
	}

	public void setOffer(int offer, User user, int carId) throws SQLException  {
		
		String sql = "INSERT INTO PENDINGOFFER (USER_ID, CAR_ID, OFFER_PRICE) VALUES(?,?,?)";
		try (Connection conn = ConnFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, user.getUserId());
			ps.setInt(2, carId);
			ps.setInt(3, offer);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public void rejectOffer(int offer_id) throws SQLException  {
		//DELETE FROM PENDINGOFFER WHERE OFFER_ID = ?;


		String sql = "DELETE FROM PENDINGOFFER WHERE OFFER_ID = ?";
		try (Connection conn = ConnFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, offer_id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void acceptOffer(int car_id, int user_id, int amount_owe) throws SQLException  {
		//DELETE FROM PENDINGOFFER WHERE OFFER_ID = ?;
		
		String sql = "INSERT INTO OWNED (CAR_ID, USER_ID, owned_amount_left) VALUES (?, ?, ?)";
		try (Connection conn = ConnFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, car_id);
			ps.setInt(2, user_id);
			ps.setInt(3, amount_owe);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void retreiveCarUserAmount(User user, int offerId) {

		try(Connection conn = ConnFactory.getConnection();){
			String sql = "SELECT CAR_ID, USER_ID, OFFER_PRICE FROM PENDINGOFFER";
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int offer_id = rs.getInt("OFFER_ID");
				int car_id = rs.getInt("CAR_ID");
				int user_id = rs.getInt("USER_ID");
				int offer_price = rs.getInt("OFFER_PRICE");
				if(offer_id==offerId) {
					user.setCar_id(car_id);
					user.setUser_id(user_id);
					user.setOffer_price(offer_price);
				}
				
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error occured, Returning to login menu");
			e.printStackTrace();
		}		
	}

	public List<Offer> getOfferList() throws SQLException {
		List<Offer> offerList = new ArrayList<Offer>();
		Connection conn = ConnFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PENDINGOFFER");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		String colName;
		
		Offer s = null;
		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				colName = rsmd.getColumnName(i);
				System.out.print(colName+" ["+rs.getString(i) + "] ");
			}
			System.out.println();
			offerList.add(s);
		}
		return offerList;	
	}
	
	public List<Owned> getOwnedList() throws SQLException{
		List<Owned> ownedList = new ArrayList<Owned>();
		Connection conn = ConnFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OWNED");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		String colName;
		
		Owned s = null;
		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				colName = rsmd.getColumnName(i);
				System.out.print(colName+" ["+rs.getString(i) + "] ");
			}
			System.out.println();
			ownedList.add(s);
		}
		return ownedList;	
	}

}