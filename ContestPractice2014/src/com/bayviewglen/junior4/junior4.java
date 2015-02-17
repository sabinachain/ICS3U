package com.bayviewglen.junior4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class junior4 {
	public static int[] remove(int[] a, int r) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if ((i+1) % r != 0) {
				count++;
			}
		}
		int[] good = new int[count];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if ((i+1) % r != 0) {
				good[j]=a[i];
				j++;
			}
		}
		return good;
	}

	public static void main(String[] args) throws FileNotFoundException {
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2014\\src\\input\\junior4.dat";
		Scanner scanner = new Scanner(new File(fileName));

		int people = Integer.parseInt(scanner.nextLine());
		int rounds = Integer.parseInt(scanner.nextLine());

		int[] p = new int[people];
		for (int i = 0; i < people; i++) {
			p[i] = i + 1;
		}

		int[] r = new int[rounds];
		for (int i = 0; i < rounds; i++) {
			r[i] = Integer.parseInt(scanner.nextLine());
		}

		// On each loop, I have an input array and I remove the multiples of
		// r[i], creating a new array.
		for (int i = 0; i < r.length; i++) {
			p = remove(p, r[i]);
		}
		
		for(int i = 0; i<p.length; i++) {
			System.out.println(p[i]);
		}
		
		scanner.close();
	}

}
