package com.bayviewglen.zork;

import java.io.Serializable;

public class Character implements Serializable {
	private String name;
	private int hp;
	private Inventory inventory;
	private String message;

public Character(String name, String message, int hp, Inventory inventory) {
	super();
	this.name = name;
	this.message = message;
	this.hp = hp;
	this.inventory = inventory;
	}

public Character() {
	super();
	this.hp = 0;
	this.inventory = null;
	}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMessage() {
	return message;
}

public int getHp() {
	return hp;
}

public void setHp(int hp) {
	this.hp = hp;
}

public Inventory getInventory() {
	return inventory;
}

public void setInventory(Inventory inventory) {
	this.inventory = inventory;
}


}