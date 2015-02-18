package com.bayviewglen.alljunior2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays; //To use the sorting function 
import java.util.Scanner;

public class Junior4 {

	public static void main(String[] args) throws FileNotFoundException {
		final String fileName = "C:\\Users\\sbeleuz\\Google Drive\\git\\ICS3U\\ContestPractice2013\\src\\input\\junior4.dat";
		Scanner scanner = new Scanner(new File(fileName));

		int tmax = Integer.parseInt(scanner.nextLine());
		int chores = Integer.parseInt(scanner.nextLine());
		int sum = 0;
		int count = 0;

		int t = 0;
		int[] times = new int[chores];

		for (int i = 0; i < chores; i++) {
			t = Integer.parseInt(scanner.nextLine());
			times[i] = t;
		}

		Arrays.sort(times); // Sorts from least to greatest

		for (int i = 0; i < chores; i++) {
			if (sum + times[i] <= tmax) {
				sum += times[i];
				count++;
			}
		}
		System.out.println(count);
		scanner.close();
	}
}