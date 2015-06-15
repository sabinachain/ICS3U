package com.bayviewglen.zork;

import java.io.Serializable;

public class Item implements Serializable {
	private String name;
	private double weight;
	private String usage;

	public Item(String n, String u, double w) {
		this.name = n;
		this.usage = u;
		this.weight = w;
	}

	public Item() {
		this.name = "";
		this.usage = "";
		this.weight = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void use() {
		System.out.println(usage);
	}

}
