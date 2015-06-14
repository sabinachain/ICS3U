package com.bayviewglen.zork;

import java.io.Serializable;

public class Character implements Serializable {
	private String name;
	private String talkString;
	private Inventory inventory;

public Character(String name, String talkString, Inventory inventory) {
	super();
	this.name = name;
	this.talkString = talkString;
	this.inventory = inventory;
	}

public Character(String name, int hp) {
	super();
	this.name = name;
	this.talkString = talkString;
	this.inventory = null;
	}

public Character() {
	super();
	this.name = "";
	this.talkString = "";
	this.inventory = null;
	}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getTalkString() {
	return talkString;
}

public void setTalkString(String talkString) {
	this.talkString = talkString;
}

public Inventory getInventory() {
	return inventory;
}

public void setInventory(Inventory inventory) {
	this.inventory = inventory;
}

public void talk() {
	System.out.println(talkString);
}


}