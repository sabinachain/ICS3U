package com.bayviewglen.functionpractise;

/* Name: Sabina Beleuz-Neagu
 * Course: ICS3U-AP
 * Title: Function Practise Questions
 * Description: Review Practise questions on creating functions. 
 * Question Numbers: 1,2,3,4,5,6,13,14,16,17
 * Due Date: By the end of next term 
 * Teacher: Mr. DesLauriers 
 */
import java.util.Scanner;

public class FunctionPracticeQuestions {

	// #1. Creates a table of cube roots from 10-50
	public static void cubeRoots(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.printf("%d %.4f\n", i, Math.pow(i, (double) 1 / 3));
		}
	}

	// #2. Outputs sum from 1 to given number.
	public static int sumSequence(int n) {
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		return sum;
	}

	// #3. Outputs the factorial of a given number.
	public static int factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

	// #4. Outputs the nth term of the Fibonacci Numbers.
	public static int fibonacci(int n) {
		if (n < 3) {
			return 1;
		}
		int fib = 1;
		int prevfib = 1;
		for (int i = 3; i <= n; i++) {
			int tmp = fib;
			fib = fib + prevfib;
			prevfib = tmp;
		}
		return fib;
	}

	// #5. Outputs a triangle made of asterisks
	public static void triangle(int n) {
		System.out.println();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// #6. Outputs a diamond made of asterisks
	public static void diamond(int n) {
		for (int i = 1; i <= (n / 2) + 1; i++) {
			for (int j = 1; j <= n; j++) {
				if (j > n / 2 + 1 - i && j < n / 2 + i + 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for (int i = 1; i <= n / 2; i++) {
			for (int j = 1; j <= n; j++) {
				if (j > i && j < n + 1 - i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	// #13. Counts down from 100 to desired number by 5's outputting
	// "I stopped." when lower than inputted number
	public static void countDown(int n) {
		for (int i = 100; i >= n; i = i - 5) {
			System.out.printf("%3d\n", i);
		}
		System.out.println("I stopped.");
	}

	// #14. Simulates the playing of a simple dice game
	public static void point() {
		int firstPoint = (int) (6 * Math.random() + 1);
		System.out.println("\nPoint is: " + firstPoint);

		int count = 0;
		int newPoint = 0;
		while (newPoint != firstPoint) {
			newPoint = (int) (6 * Math.random() + 1);
			count++;
			System.out.println("Roll " + count + " is " + newPoint);
		}
	}

	// #16. Creates a formatted calendar for the month from information inputted
	// Input by user: first day of the week and the number of days in the month
	public static void calendarMonth(int start, int day) {
		System.out.println("\nSun Mon Tue Wed Thu Fri Sat");

		for (int i = 1; i < start; i++) {
			System.out.print("    ");
		}

		for (int i = 1; i <= day; i++) {
			System.out.printf("%3d ", i);
			if ((i + start - 1) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	// #17. Takes a number from the user and outputs divisors on one line
	public static void factors(int n) {
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n = 0;
		// #1.
		cubeRoots(10, 50);

		// #2.
		System.out.println("\nPlease enter a number: ");
		n = keyboard.nextInt();
		System.out.println("Sum from 1 to " + n + " is " + sumSequence(n));

		// #3.
		System.out.println("\nPlease enter a number: ");
		n = keyboard.nextInt();
		System.out.println("The factorial of " + n + " is " + factorial(n));

		// #4.
		System.out.println("\nPlease enter a number: ");
		n = keyboard.nextInt();
		System.out.print("The Fibonacci until the term " + n + " is");
		for (int i = 1; i <= n; i++) {
			System.out.print(" " + fibonacci(i));
		}

		// #5.
		System.out
				.println("\n\nPlease enter the desired height of your right triangle: ");
		n = keyboard.nextInt();
		System.out.println();
		triangle(n);

		// #6.
		System.out
				.println("\nPlease enter the desired height of your diamond: ");
		n = keyboard.nextInt();
		System.out.println();
		diamond(n);

		// #13.
		System.out.print("\nCountDown Function - What number do I stop at? ");
		n = keyboard.nextInt();
		countDown(n);

		// #14.
		point();

		// #16.
		System.out.print("\nDay the month starts on (1 for Sunday): ");
		int start = keyboard.nextInt();

		System.out.print("Number of days in month: ");
		int days = keyboard.nextInt();
		calendarMonth(start, days);

		// #17.
		System.out.print("\nEnter a number: ");
		n = keyboard.nextInt();
		factors(n);

		keyboard.close();
	}

}
