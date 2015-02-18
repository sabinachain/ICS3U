package com.bayviewglen.alljunior2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Junior3 {

	public static void expand(String l, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < l.length(); j++) {
				for (int k = 0; k < n; k++) {
					System.out.print(l.charAt(j));
				}
			}

			System.out.print("\n");

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2012\\src\\input\\junior3.dat";
		Scanner scanner = new Scanner(new File(fileName));

		int n = Integer.parseInt(scanner.nextLine());

		String line1 = "*x*";
		String line2 = " xx";
		String line3 = "* *";
		
		expand(line1, n);
		expand(line2, n);
		expand(line3, n);

		scanner.close();

	}

}
