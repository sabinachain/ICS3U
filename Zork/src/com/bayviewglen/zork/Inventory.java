package com.bayviewglen.zork;

import java.io.Serializable;
import java.util.HashMap;

public class Inventory implements Serializable {

	private HashMap<String, Item> items;
	private double currentWeight;
	private double maxWeight;

	public Inventory(double currentWeight, double maxWeight) {
		this.items = new HashMap<String, Item>();
		this.currentWeight = currentWeight;
		this.maxWeight = maxWeight;
	}

	public Inventory() {
		this.items = new HashMap<String, Item>();
	}

	public Inventory(Boolean isRoom) {
		if (isRoom)
			this.maxWeight = Double.MAX_VALUE;

	}

	public HashMap<String, Item> getItems() {
		return items;
	}

	public void setItems(HashMap<String, Item> items) {
		this.items = items;
	}

	public double getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public boolean addItem(Item i) {
		if (i.getWeight() + currentWeight < maxWeight) {
			items.put(i.getName(), i);
			return true;
		} else {
			System.out.println("Ow! This is way too heavy to pick up.");
			return false;
		}
	}

	public boolean hasItem(String i) {
		if (items.containsKey(i)) {
			return true;
		} else {
			return false;
		}
	}

	public Item getItem(String i) {
		if (items.containsKey(i)) {
			return items.get(i);
		} else {
			System.out.println("You do not have a " + i + ".");
			return null;
		}
	}

	public Item removeItem(String key) {
		return items.remove(key);
	}

	public void displayInventory() {
		for (String key : items.keySet()) {
			System.out.println(key);
		}

		// Methods required:
		// getItem - return Item, input string
		// addItem - return boolean
		// hasItem - return boolean
		// removeItem- return Item
		// display Inventory - return void; just displays inventory

	}
}
