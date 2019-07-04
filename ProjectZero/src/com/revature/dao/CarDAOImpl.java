package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Car;
import com.revature.util.ConnFactory;

public class CarDAOImpl implements CarDAO {
	public List<Car> getCar() {
		List<Car> carList = new ArrayList<>();
		
		String sql = "SELECT * FROM LOT";
		
		try(Connection conn = ConnFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			
			while(rs.next()) {
				Car c = new Car();
				int carYear = rs.getInt("CAR_YEAR");
				c.setYearManufactured(carYear);
				
				String carMake = rs.getString("CAR_MAKE");
				c.setMake(carMake);
				
				String carModel = rs.getString("CAR_MODEL");
				c.setModel(carModel);
				
				carList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carList;
	}
	
	public Car getCarById(String id) {
		Car c = null;
		String sql = "SELECT CAR_ID, CAR_YEAR, CAR_MAKE, CAR_MODEL FROM LOT WHERE CAR_YEAR = '?' AND CAR_MAKE = '?' AND CAR_MODEL = '?'";
		
		ResultSet rs = null;
		try(Connection conn = ConnFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int carID = rs.getInt("CAR_ID");
				int carYear = rs.getInt("CAR_YEAR");
				String carMake = rs.getString("Car_MAKE");
				String carModel = rs.getString("Car_Model");
				
				c = new Car(carID, carYear, carMake, carModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!= null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return c;
	}
	@Override
	public Car getCarById(String id, Connection conn) {
		Car c = null;
		String sql = "SELECT CAR_ID, CAR_YEAR, CAR_MAKE, CAR_MODEL FROM LOT WHERE CAR_YEAR = '?' AND CAR_MAKE = '?' AND CAR_MODEL = '?'";
		
		ResultSet rs = null;
		try(PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int carID = rs.getInt("CAR_ID");
				int carYear = rs.getInt("CAR_YEAR");
				String carMake = rs.getString("Car_MAKE");
				String carModel = rs.getString("Car_Model");
				
				c = new Car(carID, carYear, carMake, carModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!= null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return c;
	}
	public int addCarToLot(Car car) {
		int addedCar = 0;
		String sql = "INSERT INTO LOT(CAR_YEAR, CAR_MAKE, CAR_MODEL) VALUES(?,?,?)";
		try(Connection conn = ConnFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1, car.getYearManufactured());
			ps.setString(2, car.getMake());
			ps.setString(3, car.getModel());
			addedCar = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addedCar;
		
	}

}
