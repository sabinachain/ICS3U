package com.bayviewglen.junior1;
//Problem J1: Triangle Times (2014)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class junior1 {

	public static void main(String[] args) throws FileNotFoundException{
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2014\\src\\input\\junior1.dat"; 
		Scanner scanner = new Scanner(new File(fileName));
		int a1 = Integer.parseInt(scanner.nextLine());
		int a2 = Integer.parseInt(scanner.nextLine());
		int a3 = Integer.parseInt(scanner.nextLine());
		
		int sum = a1+a2+a3;
		
		if(a1 == 60 && a2 == 60 && a3 == 60) {
			System.out.println("Equilateral");
		} else if (sum == 180 && (a1 == a2 || a2 == a3 || a1 == a3)){
			System.out.println("Isosceles");
		} else if (sum == 180 && a1!=a2 && a2!=a3 && a1!=a3) {
			System.out.println("Scalene");
		} else {
			System.out.println("Error");
		}
	
		scanner.close();
	}

}
