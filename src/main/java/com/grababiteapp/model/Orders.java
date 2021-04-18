package com.grababiteapp.model;

public class Orders {

	private Integer orderid;
	private Integer custid;
	private String foodname;
	private Double price;
	private Integer quantity;
	private Integer restid;
	private String status;

	public Orders() {
		super();
	}

	public Orders(Integer orderid, Integer custid, String foodname, Double price, Integer quantity, Integer restid,
			String status) {
		super();
		this.orderid = orderid;
		this.custid = custid;
		this.foodname = foodname;
		this.price = price;
		this.quantity = quantity;
		this.restid = restid;
		this.status = status;
	}

	public Orders(Integer orderid, String foodname, Double price, Integer quantity, String status) {
		super();
		this.orderid = orderid;
		this.foodname = foodname;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getRestid() {
		return restid;
	}

	public void setRestid(Integer restid) {
		this.restid = restid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", custid=" + custid + ", foodname=" + foodname + ", price=" + price
				+ ", quantity=" + quantity + ", restid=" + restid + ", status=" + status + "]";
	}

}
