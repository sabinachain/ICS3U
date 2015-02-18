package com.bayviewglen.alljunior2013;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
public class Junior1 {

	public static void main(String[] args) throws FileNotFoundException{
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2013\\src\\input\\junior1.dat";
		Scanner scanner = new Scanner(new File(fileName)); 
		
		int a = Integer.parseInt(scanner.nextLine());
		int b = Integer.parseInt(scanner.nextLine());
		
		
		int diff = b-a;
		
		int old=b+diff; 
		System.out.println(old);
		scanner.close();
	}
}

