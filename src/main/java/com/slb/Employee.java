package com.slb;

public class Employee {
	int id;
	String firstName;
	String LastName;
	float salary;
	int addressId;
	
	public Employee() {
		super();
	}
	public Employee(int id, String firstName, String lastName, float salary, int addressId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.LastName = lastName;
		this.salary = salary;
		this.addressId = addressId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}
