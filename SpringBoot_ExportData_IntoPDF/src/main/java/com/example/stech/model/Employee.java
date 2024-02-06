package com.example.stech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_dataset02")
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "department")
	private String department;
    @Column(name = "firstname")
    private String firstName;
 
    @Column(name = "lastname")
    private String lastName;
	@Column(name = "gender")
    private String gender;
	@Column(name = "email")
	private String mail;
    @Column(name = "address")
	private String address;
    @Column(name = "phonenumber")
    private String phoneNumber;

//Default constructor
//Parameterised Constructor
//Generate Getters & setters

	public Employee() {
		super();
	}

	public Employee(String department, String firstName, String lastName, String gender, String mail, String address, String phoneNumber) {
		super();
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mail = mail;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;

	}
}