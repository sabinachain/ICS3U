package com.bayviewglen.zork;

public class Item {
	private String name;
	private double weight;
	
	public Item(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	
	public Item() {
		super();
		this.name = "";
		this.weight = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
