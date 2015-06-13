package com.bayviewglen.zork;

public class Weapon extends Item {
	private String name;
	private double weight;
	private int damage;

	public Weapon(String name, double weight, int damage) {
		this.name = name;
		this.weight = weight;
		this.damage = damage;
	}
	
	public Weapon() {
		this.name = "";
		this.weight = 0;
		this.damage = 0;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void dealDamage(Character c) {
		if(Math.random()>0.05){ //95% chance
			c.setHp(c.getHp()-this.getDamage()); //Straight damage counter, very basic
		} else {
			System.out.println("Missed!"); //Enemy dodging is completely random chance
		}
	}

}

