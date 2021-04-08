package com.grababiteapp.model;

public class Restaurant {
	private int restId;
	private String restName;
	private String restEmail;
	private String restPassword;
	private int restPhone;
	private String restAddress;
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(int restId, String restName, String restEmail, String restPassword, int restPhone,
			String restAddress) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.restEmail = restEmail;
		this.restPassword = restPassword;
		this.restPhone = restPhone;
		this.restAddress = restAddress;
	}
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getRestEmail() {
		return restEmail;
	}
	public void setRestEmail(String restEmail) {
		this.restEmail = restEmail;
	}
	public String getRestPassword() {
		return restPassword;
	}
	public void setRestPassword(String restPassword) {
		this.restPassword = restPassword;
	}
	public int getRestPhone() {
		return restPhone;
	}
	public void setRestPhone(int restPhone) {
		this.restPhone = restPhone;
	}
	public String getRestAddress() {
		return restAddress;
	}
	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}
	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", restName=" + restName + ", restEmail=" + restEmail
				+ ", restPassword=" + restPassword + ", restPhone=" + restPhone + ", restAddress=" + restAddress + "]";
	}
	

}
