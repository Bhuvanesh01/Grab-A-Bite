package com.grababiteapp.model;

public class Menu {

	private Integer foodId;
	private String name;
	private String cuisine;
	private String type;
	private Double price;
	private Integer restId;

	public Menu() {
		super();
	}

	public Menu(Integer foodId, String name, String cuisine, String type, Double price, Integer restId) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.cuisine = cuisine;
		this.type = type;
		this.price = price;
		this.restId = restId;
	}

	public Menu(String name, String cuisine, String type, Double price, Integer restId) {
		super();
		this.name = name;
		this.cuisine = cuisine;
		this.type = type;
		this.price = price;
		this.restId = restId;
	}

	public Integer getfoodId() {
		return foodId;
	}

	public void setfoodId(Integer foodId) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getrestId() {
		return restId;
	}

	public void setrestId(Integer restId) {
		this.restId = restId;
	}

	@Override
	public String toString() {
		return "Menu [foodId=" + foodId + ", name=" + name + ", cuisine=" + cuisine + ", type=" + type + ", price="
				+ price + ", restId=" + restId + "]";
	}

}
