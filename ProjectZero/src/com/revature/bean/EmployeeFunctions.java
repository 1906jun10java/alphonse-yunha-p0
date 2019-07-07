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
import com.revature.util.ConnFactory;

public class EmployeeFunctions {
	protected Car car = new Car();
	int yearManufactured;
	String carMake;
	String carModel;
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
		System.out.println("Enter year manufactured: ");
		yearManufactured = sc.nextInt();

		System.out.println("Enter car make: ");
		carMake = sc.nextLine();
		carMake = sc.nextLine();

		System.out.println("Enter car model: ");
		carModel = sc.nextLine();

		car = new Car(userId, yearManufactured, carMake, carModel);
		try {
			cd.removeCarFromLot(car);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void offerDecide(User user) {
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
	
	

}