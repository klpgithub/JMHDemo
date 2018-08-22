package com.sys.jsonTest.model;

public class FullName {

	private String firstName;
	private String middleName;
	private String lastName;

	public FullName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FullName(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "[firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}

}
