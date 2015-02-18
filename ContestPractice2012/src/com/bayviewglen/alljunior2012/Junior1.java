package com.bayviewglen.alljunior2012;

import java.util.Scanner;

public class Junior1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the speed limit: ");
		int limit = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the recorded speed of the car: ");
		int speed = Integer.parseInt(scanner.nextLine());

		if (speed <= limit) {
			System.out.println("Congratulations, you are within the speed limit!");
		} else if (speed <= limit + 20) {
			System.out.println("You are speeding and your fine is $100.");
		} else if (speed <= limit + 30) {
			System.out.println("You are speeding and your fine is $270.");
		} else {
			System.out.println("You are speeding and your fine is $500.");
		}
		scanner.close();
	}

}
