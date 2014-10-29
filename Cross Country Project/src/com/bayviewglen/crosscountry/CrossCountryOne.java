package com.bayviewglen.crosscountry;
/* Name: Sabina Beleuz-Neagu
 * Course: ICS3U-AP
 * Title: Cross Country Assignment
 * Description: A computerized solution to calculate time splits for five runners
 * Due Date: 10/31/2014
 * Teacher: Mr. Deslauriers 
*/
import java.text.DecimalFormat;
import java.lang.Double;
import java.util.Scanner;

// Get rid of ln
// Print name in one and split on space 

public class CrossCountryOne {
	private static final int SECONDS_PER_MINUTE = 60;
	private static final String SECONDS_MILLISECONDS = "00.000";

	// Converts the time string of format (mm:ss.sss) to the time in seconds (double)
	private static double convertStringTimeToSec(String str) {
		// breaks into minutes and seconds on the :
		String minStr = str.substring(0,str.indexOf(':'));
		String secStr = str.substring(str.indexOf(':')+1);
		
		// Converts into seconds 
		return Double.parseDouble(minStr)*SECONDS_PER_MINUTE+Double.parseDouble(secStr);
	}
	
	// Converts the time in seconds into the string format of (mm:ss.sss)
	private static String convertDoubleToStringTime (double sec) {
		DecimalFormat formatter = new DecimalFormat(SECONDS_MILLISECONDS); //To format the seconds and milliseconds portion
		int min = (int)sec / SECONDS_PER_MINUTE;
		double remainderSec = sec-min * SECONDS_PER_MINUTE;
		String timeStr = min + ":" + formatter.format(remainderSec);
		return timeStr;
	}
	
	// Extract first name from the full name given
	private static String extractFirstName(String str) {
		String firstname = str.substring(0,str.indexOf(' '));
		return firstname;
	}

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
	
		// Runner 1, End of Mile 1
		System.out.print("Please enter Runner 1's full name: ");
		String fullName1 = keyboard.nextLine();
		// Take the first name only
		String firstName1 = extractFirstName(fullName1);
		System.out.print("Please enter " + firstName1 + "'s time to the first mile in the format (mm:ss.sss): ");
		String timeFirst1 = keyboard.nextLine();		
		// Convert string to double:  
		double secTimeFirst1 = convertStringTimeToSec(timeFirst1);
		
		// Runner 1, End of Mile 2
		System.out.print("Please enter " + firstName1 + "'s time to the end of the second mile in the format (mm:ss.sss): ");
		String timeSecond1 = keyboard.nextLine();
		//Convert string to double:  
		double secTimeSecond1 = convertStringTimeToSec(timeSecond1);

		// Runner 1, End of 5 km 
		System.out.print("Please enter " + firstName1 + "'s time to complete the 5 kms in the format (mm:ss.sss): ");
		String timeThird1 = keyboard.nextLine();
		// Convert string to double:  
		double secTimeThird1 = convertStringTimeToSec(timeThird1);

		// Summary for Runner 1
		System.out.println("Runner 1 Name: " + fullName1);
		System.out.println("Split 1 Time: " + convertDoubleToStringTime(secTimeFirst1));
		System.out.println("Split 2 Time: " + convertDoubleToStringTime(secTimeSecond1 - secTimeFirst1));
		System.out.println("Split 3 Time: " + convertDoubleToStringTime(secTimeThird1 - secTimeSecond1));
		System.out.println("Total Time: " + convertDoubleToStringTime(secTimeThird1));
			
		// Runner 2, End of Mile 1
		System.out.print("Please enter Runner 2's full name: ");
		String fullName2 = keyboard.nextLine();
		// Take the first name only
		String firstName2 = extractFirstName(fullName2);
		System.out.print("Please enter " + firstName2 + "'s time to the first mile in the format (mm:ss.sss): ");
		String timeFirst2 = keyboard.nextLine();		
		
		// Convert string to double:  
		double secTimeFirst2 = convertStringTimeToSec(timeFirst2);
		
		// Runner 2, End of Mile 2
		System.out.print("Please enter " + firstName2 + "'s time to the end of the second mile in the format (mm:ss.sss): ");
		String timeSecond2 = keyboard.nextLine();
		// Convert string to double:  
		double secTimeSecond2 = convertStringTimeToSec(timeSecond2);

		// Runner 2, End of 5 km 
		System.out.print("Please enter " + firstName2 + "'s time to complete the 5 kms in the format (mm:ss.sss): ");
		String timeThird2 = keyboard.nextLine();
		// Convert string to double:  
		double secTimeThird2 = convertStringTimeToSec(timeThird2);

		// Summary for Runner 2
		System.out.println("Runner 2 Name: " + fullName2);
		System.out.println("Split 1 Time: " + convertDoubleToStringTime(secTimeFirst2));
		System.out.println("Split 2 Time: " + convertDoubleToStringTime(secTimeSecond2 - secTimeFirst2));
		System.out.println("Split 3 Time: " + convertDoubleToStringTime(secTimeThird2 - secTimeSecond2));
		System.out.println("Total Time: " + convertDoubleToStringTime(secTimeThird2));
	
		// Runner 3, End of Mile 1
		System.out.print("Please enter Runner 3's full name: ");
		String fullName3 = keyboard.nextLine();
		// Take the first name only
		String firstName3 = extractFirstName(fullName3);
		System.out.print("Please enter " + firstName3 + "'s time to the first mile in the format (mm:ss.sss): ");
		String timeFirst3 = keyboard.nextLine();		
		// Convert string to double:  
		double secTimeFirst3 = convertStringTimeToSec(timeFirst3);
		
		// Runner 3, End of Mile 2
		System.out.print("Please enter " + firstName3 + "'s time to the end of the second mile in the format (mm:ss.sss): ");
		String timeSecond3 = keyboard.nextLine();
		// Convert string to double:  
		double secTimeSecond3 = convertStringTimeToSec(timeSecond3);

		// Runner 3, End of 5 km 
		System.out.print("Please enter " + firstName3 + "'s time to complete the 5 kms in the format (mm:ss.sss): ");
		String timeThird3 = keyboard.nextLine();
		// Convert string to double:  
		double secTimeThird3 = convertStringTimeToSec(timeThird3);

		// Summary for Runner 3
		System.out.println("Runner 3 Name: " + fullName3);
		System.out.println("Split 1 Time: " + convertDoubleToStringTime(secTimeFirst3));
		System.out.println("Split 2 Time: " + convertDoubleToStringTime(secTimeSecond3 - secTimeFirst3));
		System.out.println("Split 3 Time: " + convertDoubleToStringTime(secTimeThird3 - secTimeSecond3));
		System.out.println("Total Time: " + convertDoubleToStringTime(secTimeThird3));
		
		// Runner 4, End of Mile 1
		System.out.print("Please enter Runner 4's full name: ");
		String fullName4 = keyboard.nextLine();
		// Take the first name only
		String firstName4 = extractFirstName(fullName4);
		System.out.print("Please enter " + firstName4 + "'s time to the first mile in the format (mm:ss.sss): ");
		String timeFirst4 = keyboard.nextLine();		
		// Convert string to double:  
		double secTimeFirst4 = convertStringTimeToSec(timeFirst4);
		
		// Runner 4, End of Mile 2
		System.out.print("Please enter " + firstName4 + "'s time to the end of the second mile in the format (mm:ss.sss): ");
		String timeSecond4 = keyboard.nextLine();
		// Convert string to double:  
		double secTimeSecond4 = convertStringTimeToSec(timeSecond4);

		// Runner 4, End of 5 km 
		System.out.print("Please enter " + firstName4 + "'s time to complete the 5 kms in the format (mm:ss.sss): ");
		String timeThird4 = keyboard.nextLine();
		// Convert string to double:  
		double secTimeThird4 = convertStringTimeToSec(timeThird4);

		// Summary for Runner 4
		System.out.println("Runner 4 Name: " + fullName4);
		System.out.println("Split 1 Time: " + convertDoubleToStringTime(secTimeFirst4));
		System.out.println("Split 2 Time: " + convertDoubleToStringTime(secTimeSecond4 - secTimeFirst4));
		System.out.println("Split 3 Time: " + convertDoubleToStringTime(secTimeThird4 - secTimeSecond4));
		System.out.println("Total Time: " + convertDoubleToStringTime(secTimeThird4));
		
		// Runner 5, End of Mile 1
		System.out.print("Please enter Runner 5's full name: ");
		String fullName5 = keyboard.nextLine();
		// Take the first name only
		String firstName5 = extractFirstName(fullName5);
		System.out.print("Please enter " + firstName5 + "'s time to the first mile in the format (mm:ss.sss): ");
		String timeFirst5 = keyboard.nextLine();		
		// Convert string to double:  
		double secTimeFirst5 = convertStringTimeToSec(timeFirst5);
		
		// Runner 5, End of Mile 2
		System.out.print("Please enter " + firstName5 + "'s time to the end of the second mile in the format (mm:ss.sss): ");
		String timeSecond5 = keyboard.nextLine();
		// Convert string to double:  
		double secTimeSecond5 = convertStringTimeToSec(timeSecond5);

		// Runner 5, End of 5 km 
		System.out.print("Please enter " + firstName5 + "'s time to complete the 5 kms in the format (mm:ss.sss): ");
		String timeThird5 = keyboard.nextLine();
		// Convert string to double:  
		double secTimeThird5 = convertStringTimeToSec(timeThird5);

		// Summary for Runner 5
		System.out.println("Runner 5 Name: " + fullName5);
		System.out.println("Split 1 Time: " + convertDoubleToStringTime(secTimeFirst5));
		System.out.println("Split 2 Time: " + convertDoubleToStringTime(secTimeSecond5 - secTimeFirst5));
		System.out.println("Split 3 Time: " + convertDoubleToStringTime(secTimeThird5 - secTimeSecond5));
		System.out.println("Total Time: " + convertDoubleToStringTime(secTimeThird5));

				
		// Making the table including all the summaries:
		System.out.printf("\n%10s %30s %12s %12s %12s %12s\n", "Runner#", "FullName", "TimeSplit1", "TimeSplit2", "TimeSplit3", "TimeTotal");
		System.out.printf("%10d %30s %12s %12s %12s %12s\n", 1, fullName1, convertDoubleToStringTime(secTimeFirst1), convertDoubleToStringTime(secTimeSecond1 - secTimeFirst1), convertDoubleToStringTime(secTimeThird1 - secTimeSecond1), convertDoubleToStringTime(secTimeThird1));
		System.out.printf("%10d %30s %12s %12s %12s %12s\n", 2, fullName2, convertDoubleToStringTime(secTimeFirst2), convertDoubleToStringTime(secTimeSecond2 - secTimeFirst2), convertDoubleToStringTime(secTimeThird2 - secTimeSecond2), convertDoubleToStringTime(secTimeThird2));
		System.out.printf("%10d %30s %12s %12s %12s %12s\n", 3, fullName3, convertDoubleToStringTime(secTimeFirst3), convertDoubleToStringTime(secTimeSecond3 - secTimeFirst3), convertDoubleToStringTime(secTimeThird3 - secTimeSecond3), convertDoubleToStringTime(secTimeThird3));
		System.out.printf("%10d %30s %12s %12s %12s %12s\n", 4, fullName4, convertDoubleToStringTime(secTimeFirst4), convertDoubleToStringTime(secTimeSecond4 - secTimeFirst4), convertDoubleToStringTime(secTimeThird4 - secTimeSecond4), convertDoubleToStringTime(secTimeThird4));
		System.out.printf("%10d %30s %12s %12s %12s %12s\n", 5, fullName5, convertDoubleToStringTime(secTimeFirst5), convertDoubleToStringTime(secTimeSecond5 - secTimeFirst5), convertDoubleToStringTime(secTimeThird5 - secTimeSecond5), convertDoubleToStringTime(secTimeThird5));
	
		keyboard.close();
	}


}
