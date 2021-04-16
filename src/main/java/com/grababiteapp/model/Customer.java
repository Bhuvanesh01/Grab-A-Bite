package com.grababiteapp.model;

public class Customer {

	private Integer custId;
	private String custName;
	private String custEmail;
	private String custPassword;
	private Integer custPhone;
	private String custAddress;

	public Customer() {
		super();
	}

	public Customer(Integer custId, String custName, String custEmail, String custPassword, Integer custPhone,
			String custAddress) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.custPhone = custPhone;
		this.custAddress = custAddress;
	}

	public Customer(String custName, String custEmail, String custPassword, Integer custPhone, String custAddress) {
		super();
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.custPhone = custPhone;
		this.custAddress = custAddress;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public Integer getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(Integer custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custPassword="
				+ custPassword + ", custPhone=" + custPhone + ", custAddress=" + custAddress + "]";
	}

}
