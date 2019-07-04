package com.revature.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.LotDAO;
import com.revature.util.ConnFactory;

public class EmployeeFunctions implements LotDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	public List<Car> getCarList() throws SQLException{
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LOT");
		Car s = null;
		while(rs.next()) {
			s = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			carList.add(s);
		}
		return carList;
	}
	public void addCarToLot(User user) {
		System.out.println("Add Car.");
	}
	public void removeCarFromLot(User user) {
		System.out.println("Removed.");
	}
	public void offerDecide(User user) {
		System.out.println("Accept/Decline");
	}
	public void viewPayments(User user) {
		System.out.println("View payments");
	}
/*	public void returnToMenu(User user) {
		System.out.println("Returned To Menu");
	}*/
	public void exitProgram(VariableCheck variable, User user) {
		user.setTravelTo("login");
		variable.setLoop(false);
		System.out.println("exiting.");
		//System.exit(0);
	}


}
