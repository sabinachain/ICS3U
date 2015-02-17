package com.bayviewglen.junior1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Junior3 {
	
	public static boolean distinctDigits(int y) {
		//NOTE: To parse a number and get all the digits in an array 
		int[] digits = new int[10]; 
		int countD = 0; 
		int countBad = 0;
		boolean distinct = true;
		while(y>0) {
			int d = y%10;
			y=y/10;
			digits[countD]=d; 
			countD++;
		}
		
		for(int i = 0; i<countD; i++) {
			for(int j = i+1; j<countD; j++) {
				if(digits[i]==digits[j]) {
					distinct=false;
				}
			}
		}
		return distinct;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2013\\src\\input\\junior3.dat";
		Scanner scanner = new Scanner(new File(fileName));

		int year = Integer.parseInt(scanner.nextLine());

		boolean foundDistinct = false;
		while(!foundDistinct) {
			year++;
			foundDistinct = distinctDigits(year);
		}
		System.out.println(year);
		
		scanner.close();
	}
}
