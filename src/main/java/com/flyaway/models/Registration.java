package com.flyaway.models;

public class Registration {

	private int registrationid;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String password;
	
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registration(int registrationid, String firstname, String lastname, String email, String phone,
			String password) {
		super();
		this.registrationid = registrationid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public int getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(int registrationid) {
		this.registrationid = registrationid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Registration [registrationid=" + registrationid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", phone=" + phone + ", password=" + password + "]";
	}
	
}