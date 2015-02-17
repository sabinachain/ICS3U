package com.bayviewglen.junior1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
public class Junior2 {

	public static void main(String[] args) throws FileNotFoundException{
		final String fileName = "C:\\Users\\sbeleuz\\workspace\\ContestPractice2013\\src\\input\\junior2.dat";
		Scanner scanner = new Scanner(new File(fileName)); 
		
		
		String word = scanner.nextLine();
		int countbad = 0; 
		
		for(int i = 0; i<word.length(); i++) {
			char l = word.charAt(i);
			if(l != 'I'&&l != 'O' && l != 'S' && l != 'H' && l != 'Z' && l != 'X' && l != 'N') {
				countbad++;
			}
		}
		
		if(countbad>0) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
		
		scanner.close();
	}


}
