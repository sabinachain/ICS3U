package com.bayviewglen.alljunior2012;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
public class Junior2 {

	public static void main(String[] args) throws FileNotFoundException {
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2012\\src\\input\\junior2.dat";
		Scanner scanner = new Scanner(new File(fileName)); 

		int a = Integer.parseInt(scanner.nextLine());
		int b = Integer.parseInt(scanner.nextLine());
		int c = Integer.parseInt(scanner.nextLine());
		int d = Integer.parseInt(scanner.nextLine());
		
		if(a==b && b==c && c==d){
			System.out.println("Constant Depth");
		} else if (a<b && b<c && c<d) {
			System.out.println("Fish Rising");
		} else if (a>b && b>c && c>d) {
			System.out.println("Fish Diving");
		} else {
			System.out.println("No Fish");
		}
		
		scanner.close();
	}

}
