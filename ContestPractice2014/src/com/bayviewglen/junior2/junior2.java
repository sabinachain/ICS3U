package com.bayviewglen.junior2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
public class junior2 {

	public static void main(String[] args) throws FileNotFoundException {
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2014\\src\\input\\junior2.dat"; 
		Scanner scanner = new Scanner(new File(fileName));

		int total = Integer.parseInt(scanner.nextLine());
		String votes = scanner.nextLine();
		
		int sumA = 0;
		int sumB = 0; 
		for(int i = 0; i<votes.length(); i++) {
			if(votes.charAt(i) == 'A') {
				sumA++;
			} else {
				sumB++;
			}
		}
		
		if(sumA>sumB) {
			System.out.println("A");
		} else if (sumB>sumA) {
			System.out.println("B");
		} else {
			System.out.println("Tie");
		}
		scanner.close();
	}
}
