package com.mayank.springbootstarter.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Library {
	@Id
	private int libraryId;
	private String name;
	private String Address;
	
	public Library(){
		
	}
	
	public Library(int libraryId, String name, String address) {
		super();
		this.libraryId = libraryId;
		this.name = name;
		Address = address;
	}
	
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
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
	
	
	
}
