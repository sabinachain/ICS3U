package com.bayviewglen.zork;

import java.io.Serializable;
import java.util.HashMap;

public class Inventory implements Serializable {

	private static final double MAX_PLAYER_WEIGHT = 20;
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
		this.maxWeight = MAX_PLAYER_WEIGHT;
	}

	public Inventory(Boolean isRoom) {
		if (isRoom)
			this.items = new HashMap<String,Item>();
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
			System.out.println("Ow! Altogether, your inventory would be too heavy to pick this up.");
			return false;
		}
	}

	public boolean hasItem(String key) {
		if (items.containsKey(key)) {
			return true;
		} else {
			return false;
		}
	}

	public Item getItem(String key) {
		if (items.containsKey(key)) {
			return items.get(key);
		} else {
			System.out.println("You do not have a " + key + ".");
			return null;
		}
	}

	public Item removeItem(String key) {
		Item myItem = items.remove(key);
		if (myItem != null) {
			currentWeight -= myItem.getWeight();
		}
		return myItem;
	}

	public void useItem(String key) {
		if (items.containsKey(key)) {
			items.get(key).use();
		} else {
			System.out.println("You do not have a " + key + ".");
		}
	}

	public void displayInventory() {
		if (items.size() == 0) {
			System.out.println("Empty inventory.");
		} else {
			for (String key : items.keySet()) {
				System.out.println(key);
			}
		}
	}

	public String stringInventory() {
		String result = "";
		for (String key : items.keySet()) {
			result += " " + key;
		}
		return result;
	}

	// Methods required:
	// getItem - return Item, input string
	// addItem - return boolean
	// hasItem - return boolean
	// removeItem- return Item
	// display Inventory - return void; just displays inventory
	// removeItem - void
	// useItem - void
}
