package com.grababiteapp.model;

public class Menu {

	private int foodId;
	private String name;
	private String cuisine;
	private String type;
	private double price;
	private int restId;

	public Menu() {
		super();
	}

	public Menu(int foodId, String name, String cuisine, String type, double price, int restId) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.cuisine = cuisine;
		this.type = type;
		this.price = price;
		this.restId = restId;
	}

	public int getfoodId() {
		return foodId;
	}

	public void setfoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getrestId() {
		return restId;
	}

	public void setrestId(int restId) {
		this.restId = restId;
	}

	@Override
	public String toString() {
		return "Menu [foodId=" + foodId + ", name=" + name + ", cuisine=" + cuisine + ", type=" + type + ", price="
				+ price + ", restId=" + restId + "]";
	}

}
