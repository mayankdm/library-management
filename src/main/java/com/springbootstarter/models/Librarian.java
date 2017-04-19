package com.springbootstarter.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Librarian {
	@Id
	private int roll;
	private String name;
	private String Address;
	private int phone;

	public Librarian() {

	}

	public Librarian(int roll, String name, String address, int phone) {
		super();
		this.roll = roll;
		this.name = name;
		Address = address;
		this.phone = phone;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
