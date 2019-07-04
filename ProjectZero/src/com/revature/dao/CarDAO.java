package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.bean.Car;

public interface CarDAO {
	public List<Car> getCar();
	public Car getCarById(String id);
	public Car getCarById(String id, Connection conn);
	public int addCarToLot(Car car);
}
