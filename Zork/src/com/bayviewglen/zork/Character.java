package com.bayviewglen.zork;

import java.io.Serializable;

public class Character implements Serializable {
	private String name;
	private int hp;
	private Inventory inventory;

public Character(String name, int hp, Inventory inventory) {
	super();
	this.name = name;
	this.hp = hp;
	this.inventory = inventory;
	}

public Character(String name, int hp) {
	super();
	this.name = name;
	this.hp = hp;
	this.inventory = null;
	}

public Character() {
	super();
	this.name = null;
	this.hp = 0;
	this.inventory = null;
	}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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