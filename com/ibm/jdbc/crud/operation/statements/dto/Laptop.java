package com.ibm.jdbc.crud.operation.statements.dto;

/*if any program is wronge then report here 
 * https://www.linkedin.com/in/vikas-kumar-517994229/
 * */

public class Laptop {
	private int id;
	private String name;
	private double price;
	private String color;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "id=" + id + ", \nname=" + name + ", \nprice=" + price + ", \ncolor=" + color;
	}
	
	
	
}
