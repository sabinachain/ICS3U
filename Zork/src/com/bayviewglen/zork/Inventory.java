package com.bayviewglen.zork;

import java.io.Serializable;
import java.util.HashMap;

public class Inventory implements Serializable {

	private static final double MAX_PLAYER_WEIGHT = 20;
	private HashMap<String, Item> items;
	private double currentWeight;
	private double maxWeight;

	// constructor with arguments currentWeight (current weight of inventory)
	// and maxWeight (maximum exclusive limit for inventory weight)
	public Inventory(double currentWeight, double maxWeight) {
		this.items = new HashMap<String, Item>();
		this.currentWeight = currentWeight;
		this.maxWeight = maxWeight;
	}

	// constructor without arguments
	public Inventory() {
		this.items = new HashMap<String, Item>();
		this.maxWeight = MAX_PLAYER_WEIGHT;
	}

	// constructor for room inventory using boolean to check if it is a room as
	// the argument
	public Inventory(Boolean isRoom) {
		if (isRoom)
			this.items = new HashMap<String, Item>();
		this.maxWeight = Double.MAX_VALUE;

	}

	// return the item reference of the inventory
	public HashMap<String, Item> getItems() {
		return items;
	}

	// getters and setters for currentWeight, maxWeight
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

	// addItem function to add an item to an inventory. Input an Item i and
	// returns boolean (true if added, false if not)
	public boolean addItem(Item i) {
		if (i.getWeight() + currentWeight < maxWeight) {
			items.put(i.getName(), i);
			return true;
		} else {
			System.out
					.println("Ow! Altogether, your inventory would be too heavy to pick this up.");
			return false;
		}
	}

	// hasItem function to simply check if the item is in the inventory already.
	public boolean hasItem(String key) {
		if (items.containsKey(key)) {
			return true;
		} else {
			return false;
		}
	}

	// getItem function to return an item for a particular key. If it does not
	// exist, return null.
	public Item getItem(String key) {
		if (items.containsKey(key)) {
			return items.get(key);
		} else {
			System.out.println("You do not have a " + key + ".");
			return null;
		}
	}

	// removeItem function that removes the key from items and returns
	// the reference to the item removed.
	public Item removeItem(String key) {
		Item myItem = items.remove(key);
		if (myItem != null) {
			currentWeight -= myItem.getWeight();
		}
		return myItem;
	}

	// useItem function that uses the item by first checking to see if it is the
	// inventory
	public void useItem(String key) {
		if (items.containsKey(key)) {
			items.get(key).use();
		} else {
			System.out.println("You do not have a " + key + ".");
		}
	}

	// displayInventory function to display what is in the inventory, or print
	// "Empty Inventory." if there is nothing there. It displays it by putting one item per row. 
	public void displayInventory() {
		if (items.size() == 0) {
			System.out.println("Empty inventory.");
		} else {
			for (String key : items.keySet()) {
				System.out.println(key);
			}
		}
	}

	// stringInventory function to print on one line the contents of the inventory. 
	public String stringInventory() {
		String result = "";
		for (String key : items.keySet()) {
			result += " " + key;
		}
		return result;
	}

}
