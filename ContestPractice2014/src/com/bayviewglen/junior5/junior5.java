package com.bayviewglen.junior5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class junior5 {

	public static void main(String[] args) throws FileNotFoundException {
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2014\\src\\input\\junior5.dat";
		Scanner scanner = new Scanner(new File(fileName));

		int n = Integer.parseInt(scanner.nextLine()); // number of students

		String names1 = scanner.nextLine();
		String names2 = scanner.nextLine();

		String[] a = names1.split("\\s+");
		String[] b = names2.split("\\s+");
		boolean okay = true;

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < b.length; j++) {
				if (a[i].equals(b[j]) && !a[j].equals(b[i])) {
					okay = false;
				} 
			}

		}

		if (okay == false) {
			System.out.println("bad");
		} else {
			System.out.println("good");
		}

		scanner.close();
	}
}
