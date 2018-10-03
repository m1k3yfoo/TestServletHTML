package com.tcs.ilp.bean;

import java.util.List;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String contact;
	private String gender;
	private char isMarried;
	private String city;
	private List<String> hobbies;
	
	public Customer() {}
	
	public Customer(int customerId, String firstName, String lastName, String contact, String gender,
			String city) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.gender = gender;
//		this.isMarried = isMarried;
		this.city = city;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public char getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(char isMarried) {
		this.isMarried = isMarried;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	
}
