package com.bayviewglen.blackjack;
/* Name: Sabina Beleuz-Neagu
 * Course: ICS3U-AP
 * Title: The Game of BlackJack
 * Description: A one-player game of BlackJack where the user competes against the computerized dealer. 
 * Due Date: 12/8/2014
 * Teacher: Mr. DesLauriers 
*/

import java.util.Locale;
import java.text.NumberFormat;
import java.lang.Math;
import java.util.Scanner;

public class BlackjackAssignment {

	private static final int START_AMOUNT = 500;
	private static final int NUM_VALUES = 13;
	private static final int NUM_SUITS = 4;
	private static final int MAX_NO_CARDS = 21;

	//randomly generated cards
	//Represented with 3 digit number:
	//-first digit 1-4 represents the suit 1-H, 2-C, 3-S, D-4.
	//-second 2 digits 1-13 represent card value 1-A, 2-2, ..., 10-10, 11-J, 12-Q, 13-K.

	private static int getRandomCard() {
		//1-13
		int cardValue = (int) (Math.random() * NUM_VALUES + 1);
		//1-4
		int cardSuit = (int) (Math.random() * NUM_SUITS + 1);		
		return (cardSuit*100 + cardValue);
	}

	private static int valueCard(int card) {
		int cardValue = card%100;
		if (cardValue>10) {
			cardValue = 10; 
		}
		return cardValue;
	}

	//Using the card number, separate the first digit from the last two digits.
	//Use first digit for suits, last two for card value. 
	private static String displayCard(int card) {		
		String strCard = "";
		int cardValue = card%100;

		//1,11,12,13 Correspond to A,J,Q,K, rest remain unchanged.
		if (cardValue == 1) {
			strCard+="A";
		} else if (cardValue == 11) {
			strCard+="J";
		} else if (cardValue == 12) {
			strCard+="Q";
		} else if (cardValue == 13) {
			strCard+="K";
		} else {			
			strCard+=cardValue;
		}

		//1,2,3,4 Corresponding to H,C,S,D
		int cardSuit = card/100;
		if (cardSuit == 1) 
			strCard += "H";
		else if (cardSuit == 2)
			strCard += "C";
		else if (cardSuit == 3)
			strCard += "S";
		else if (cardSuit == 4)
			strCard += "D";

		return strCard;
	}

	//Loop through the array "cards" and call the displayCard method for each element 
	private static String displayHand(int [] cards, int cnt, boolean useXX) {
		String result="";
		for (int i=0; i<cnt; i++) {
			if (useXX && i>0) {
				result = result + " XX";
			} else {
				result = result + " " + displayCard(cards[i]);
			}
		}
		return result;
	}
	
	//Loop through array of cards and sum the values of each card 
	//Count number of aces and change ace value to 1 if result>21 
	private static int getSumCards(int [] cards, int cnt) {
		int result = 0;
		int numAces = 0;
		for (int i=0; i<cnt; i++) {
			result += valueCard(cards[i]);
			if (valueCard(cards[i])==1) {
				numAces++;
				result += 10;
			}
		}
		
		while (result>21 && numAces>0) {
			result -=10;
			numAces--;
		}
		return result;
	}

	//Prompt user for bet and read bet from screen 
	private static int getBet(int wallet, Scanner in) {
		int bet = 0;
		while (bet<1 || bet>wallet) {
			System.out.println("How much do you want to bet? Bet between 1 to " + wallet);
			if (in.hasNextInt()) {
				bet=in.nextInt();
				in.nextLine();
			} else {
				System.out.println("You have entered an invalid bet. Try again.");
				in.next();
			}
		}
		return bet;
	}

	//Ask user if they want to play again and read desired action 
	private static boolean getPlayOption(Scanner in) {
		boolean play = true;
		System.out.println("Do you want to play again ? Y/N");
		String str = in.nextLine();
		while (!"Y".equalsIgnoreCase(str) && !"N".equalsIgnoreCase(str)) {
			System.out.println("You have entered an invalid option. Try again.");
			str=in.nextLine();
		}
		if ("N".equals(str) || "n".equals(str)) play = false;
		return play;
	}
	
	//Play one hand.
	//dCards is the array for the dealer's hand; dCount stores number of cards dealer has 
	//pCards is the array for the player's hand; pCount stores number of cards player has 
	
	private static int playHand(int sum, int bet, Scanner in) {
		int [] dCards = new int[MAX_NO_CARDS];
		int [] pCards = new int[MAX_NO_CARDS];
		int pCount=0;
		int dCount=0;
		for (int i=0; i<2; i++) {
			dCards[i]=getRandomCard();
			dCount++;		
			pCards[i]=getRandomCard();
			pCount++;
		}		

		//Initialize pOver and pStay which later can be changed inside the loop. 
		boolean pStay=false;
		boolean pOver21=false;
		System.out.println("--------------------- Begin Hand ---------------------");
		while (!pStay && !pOver21) {	
			System.out.print("Dealer:"   + displayHand(dCards, dCount, true));
			System.out.print("\nPlayer:" + displayHand(pCards, pCount, false));
			System.out.println("\n--------------------- Playing ---------------------");
			System.out.println("What do you want to do? 1.Hit 2.Stay 3.Double Down");
			int action=0;
			while (action<1 || action>3) {
				if (in.hasNextInt()) {
					action=in.nextInt();
					in.nextLine();
					if (action<1 || action>3) {
						System.out.println("You have entered an invalid input. Try again.");
					}
				} else {
					System.out.println("You have entered an invalid input. Try again.");
					in.next();
				}
			}
			if (action == 1) {
				pCards[pCount]=getRandomCard();
				pCount++;
			} else if (action == 2) {
				pStay=true;
			} if (action == 3) {
				if (sum < 2*bet) {
					System.out.println("Not enough money to Double Down. Try again.");
				} else {
					pCards[pCount]=getRandomCard();
					pCount++;
					bet*=2;
					pStay=true;
				}
			}
			if (getSumCards(pCards, pCount)>21)
				pOver21=true;
		}
		//If player is not over 21, dealer will hit if their hand sum is less than 17 OR it is less than player  
		while (!pOver21 && (getSumCards(dCards, dCount)<getSumCards(pCards, pCount) ||  getSumCards(dCards, dCount)<17)) {
			dCards[dCount]=getRandomCard();
			dCount++;
		}

		System.out.println("Dealer:" + displayHand(dCards, dCount, false) + " ... " + getSumCards(dCards, dCount));
		System.out.println("Player:" + displayHand(pCards, pCount, false) + " ... " + getSumCards(pCards, pCount));
		System.out.print("Result:");
		if (pOver21 || (getSumCards(dCards, dCount)>=getSumCards(pCards, pCount) && getSumCards(dCards, dCount)<=21)) {
			System.out.println(" Dealer wins! "+ bet);
			bet*=-1;
		} else {
			System.out.println(" Player wins! " + bet);
		}
		System.out.println("--------------------- End Hand ---------------------");
		return bet;
	}

	//Use locale and NumberFormat class to display money in your wallet. 
	private static void displayMoney(int sum, Locale loc) {
		System.out.print("You have " + NumberFormat.getCurrencyInstance(loc).format(sum) +" in your wallet. ");
		return; 
	}

	//Prompt user to select a locale from a predetermined array. Read locale and store. 
	private static Locale getLocale(Scanner in) {
		Locale[] locArray = { Locale.CANADA, Locale.CANADA_FRENCH, Locale.CHINA, Locale.FRANCE, Locale.GERMANY, Locale.ITALY, 
				Locale.JAPAN, Locale.KOREA, Locale.TAIWAN, Locale.UK, Locale.US };
		int selection=-1;
		while (selection<0 || selection>=locArray.length) {
			for (int i=0; i<locArray.length; i++) {
				System.out.println("" + i + ". " + locArray[i].getDisplayCountry());
			}
			System.out.println("Please enter the number that corresponds to your desired locale:");
			if (in.hasNextInt()) {
				selection=in.nextInt();
				in.nextLine();
			} else {
				in.next();
			}
		}
		return locArray[selection];
	}

	//Prompt player for name and store it 
	private static String getPlayerName(Scanner in) {
		String name = "";
		System.out.println("Please enter your name: ");
		name = in.nextLine();
		return name;
	}

	//main program 
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String playerName = getPlayerName(in);
		while (!"quit".equalsIgnoreCase(playerName)) {
			int wallet = START_AMOUNT;
			Locale playerLocale = getLocale(in);
			boolean playerContinue = true;
			while (wallet>0 && playerContinue) {
				displayMoney(wallet, playerLocale);
				int bet = getBet(wallet, in);
				int resultHand = playHand(wallet, bet, in);
				wallet += resultHand;
				displayMoney(wallet, playerLocale);
				if (wallet>0)
					playerContinue = getPlayOption(in);
				else
					System.out.println("No money to play!");
			}
			playerName = getPlayerName(in);
		}
		System.out.println("Bye. Thanks for playing!");
		in.close();
	}

}
