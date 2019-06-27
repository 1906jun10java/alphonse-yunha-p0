package com.revature.employee;

public class Car {

	
	// best practices: explicitly declare a noargs constructor when
	// any constructor is present, we are not provided the default constructor
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int yearManufactured, String make, String model) {
		super();
		this.yearManufactured = yearManufactured;
		this.make = make;
		this.model = model;
	}

	private int yearManufactured;
	private String make;
	private String model;

	public int getYearManufactured() {
		return yearManufactured;
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [yearManufactured=" + yearManufactured + ", make=" + make + ", model=" + model + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + yearManufactured;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (yearManufactured != other.yearManufactured)
			return false;
		return true;
	}

}