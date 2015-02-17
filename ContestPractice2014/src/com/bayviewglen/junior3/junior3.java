package com.bayviewglen.junior3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class junior3 {

	public static void main(String[] args) throws FileNotFoundException {
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2014\\src\\input\\junior3.dat";
		Scanner scanner = new Scanner(new File(fileName));

		int rounds = Integer.parseInt(scanner.nextLine());
		if (rounds < 1 || rounds > 15) {
			System.out.println("This is not an appropriate input.");
		}

		int[] a = new int[rounds];
		int[] d = new int[rounds];
		int pointsA = 100;
		int pointsD = 100;

		for (int i = 0; i < rounds; i++) {
			a[i] = scanner.nextInt();
			d[i] = scanner.nextInt();
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}

		for (int i = 0; i < rounds; i++) {
			if (a[i] > d[i]) {
				pointsD -= a[i];
			} else if (a[i] < d[i]) {
				pointsA -= d[i];
			}

		}

		System.out.println(pointsA);
		System.out.println(pointsD);
		scanner.close();
	}

}
