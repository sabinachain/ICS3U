package com.bayviewglen.horseracing;
/* Name: Sabina Beleuz-Neagu
 * Course: ICS3U-AP
 * Title: Horse-Racing Assignment
 * Description: A multi-player game where players select horses to bet on and then watch the race in time-steps. 
 * Extra Feature: A two-dimensional array for bets so that players can bet on more than one horse. 
 * Betting Style: Winner gets all betting funds collected from every player. 
 * If there are multiple they share the funds collected proportionally based on their own bet amounts. 
 * Due Date: 2/9/2015
 * Teacher: Mr. DesLauriers 
*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HorseRacing {

	private static String[] loadAllHorses(String fileName) {
		try {
			Scanner input = new Scanner(new File(fileName));
			int noNames = 0;
			// first line is an integer which tells you number of names to follow.
			if (input.hasNextLine()) {
				noNames = Integer.parseInt(input.nextLine());
			}
			String[] names = new String[noNames];
			int i = 0;
			while (input.hasNextLine() && i < noNames) {
				// line has a String, which represents a name.
				names[i] = input.nextLine();
				i++;
			}
			input.close();
			return names;
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", fileName);
			e.printStackTrace(); //Prints extra details about the call
			return new String[0];
		}
	}

	//random selection of n names from array of names.
	//return the array of names selected
	private static String[] selectRaceHorses(String[] a, int n) {
		String[] h = new String[n];
		//generate a random integer between 0 and n-1
		int i = 0; // index for the selection array
		while (i < n && i < a.length) {
			int k = (int) (Math.random() * n);
			boolean selected = false; // check if the horse was selected already.
			for (int j = 0; j < i; j++) {
				if (a[k].equals(h[j])) {
					selected = true;
				}
			}
			//if new horse, add to selection.
			if (!selected) {
				h[i] = a[k];
				i++;
			}
		}
		return h;
	}

	//load players file.
	//returns player names and also populate wallets.
	private static String[] loadPlayersFromFile(String fileName, Integer[] w) {
		try {
			Scanner input = new Scanner(new File(fileName));
			int noNames = 0;
			// first line is an integer which tells you number of names to follow.
			if (input.hasNextLine()) {
				noNames = Integer.parseInt(input.nextLine());
			}
			String[] names = new String[noNames];
			int i = 0;
			while (input.hasNextLine() && i < noNames) {
				//each line has a String, integer separated by space.
				//Jack 500
				String pairStr = input.nextLine();
				names[i] = pairStr.substring(0, pairStr.indexOf(" "));
				w[i] = Integer.valueOf( pairStr.substring( pairStr.indexOf(" ") + 1 ));
				i++;
			}
			input.close();
			return names;
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", fileName);
			e.printStackTrace();
			return new String[0];
		}
	}
	
	//save players file by overwriting file in this name
	private static void savePlayersToFile(String fileName, String[] p, Integer[] w) {
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            // first line has number of rows to follow.
            fw.write(String.valueOf(p.length)+ "\n");
            for (int i=0; i<p.length; i++) {
            	String line = p[i] + " " + w[i].toString() + "\n";
            	fw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //close resources
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	//pay the bets for winner's horse (index in array is winH for winning horse)
	private static void payPlayerBet(String[] h, String[] p, Integer[] w, Integer[][] b, int winH) {
		int totalBetAmount=0;
		int winHorseBetAmount=0;
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < h.length; j++) {
				if (b[i][j]>0) {
					totalBetAmount += b[i][j]; 
					if (j==winH) 
						winHorseBetAmount += b[i][j];
				}	
			}
		}
		double payRate = 0;
		if (winHorseBetAmount>0) 
			payRate = (double) totalBetAmount/winHorseBetAmount;
		System.out.printf("All horses bet amount %d, horse %s bet ammount %d, %.2f pay rate\n", totalBetAmount, h[winH], winHorseBetAmount, payRate);
		for (int i = 0; i < p.length; i++) {
				if (b[i][winH]>0) {
					w[i] = w[i] + Integer.valueOf((int)( b[i][winH]*payRate));
					System.out.println("Player " + p[i] + " original bet "+ b[i][winH] + " won " + (int)(b[i][winH]*payRate));
				}
		}	
	}

	//select player
	private static void selectPlayerBet(String[] h, String[] p, Integer[] w, Integer[][] b) {
		Scanner sc = new Scanner(System.in);
		boolean selectPlayer = false;
		while (!selectPlayer) {
			System.out.printf("%2s. %10s %8s\n", "NO", "PLAYER", "WALLET");
			for (int i = 0; i < p.length; i++) {
				System.out.printf("%2d. %10s %8d\n", i, p[i], w[i]);
			}
			System.out.print("Select player to place a bet (or choose a value outside array to end selection): ");
			if (sc.hasNextInt()) {
				int numberP = sc.nextInt();
				sc.nextLine();
				if (numberP >= 0 && numberP < p.length) {
					System.out.println("Selected player is " + p[numberP]);
					selectPlayerHorseBet(h, p, w, b, numberP, sc);
				} else {
					selectPlayer = true;
				}
			} else {
				System.out.println("Must select a player to bet using a number.");
				sc.next();
				selectPlayer = true;
			}
		}
		System.out.println("Done player betting selection.");
	}

	//select horse
	private static void selectPlayerHorseBet(String[] h, String[] p, Integer[] w,
			Integer[][] b, int numberP, Scanner sc) {
		boolean selectPlayerHorse = false;
		while (!selectPlayerHorse) {
			System.out.printf("%2s. %20s %8s\n", "NO", "HORSE", "BET");
			for (int i = 0; i < h.length; i++) {
				System.out.printf("%2d. %20s %8d\n", i, h[i], b[numberP][i]);
			}
			System.out.print(p[numberP] + ", select your horse (or choose a value outside array to end selection): ");
			if (sc.hasNextInt()) {
				int numberH = sc.nextInt();
				sc.nextLine();
				if (numberH >= 0 && numberH < h.length) {
					System.out.print(p[numberP] + "'s selected horse is "
							+ h[numberH]);
					placeBetPlayerHorse(h, p, w, b, numberP, numberH, sc);
				} else {
					System.out.println(p[numberP] + " is done betting.");
					selectPlayerHorse = true;
				}
			} else {
				System.out.println("Must select a horse using a number.");
				sc.next();
			}
		}
	}

	//Extra feature: multiple betting for winning horse. 
	//The implementation is done using a 2 dimensional array Integer[players.length][horses.length]
	//set the bet amount for player and horse selected, see element b[numberP][numberH].
	private static void placeBetPlayerHorse(String[] h, String[] p, Integer[] w,
			Integer[][] b, int numberP, int numberH, Scanner sc) {
		System.out.printf(", has $" + w[numberP] + " available for betting. ");
		System.out.printf( p[numberP] + ", what amount do you want to bet on " + h[numberH] + "? ");

		boolean betDone = false;
		while (!betDone) {
			if (sc.hasNextInt()) {
				int bet = sc.nextInt();
				sc.nextLine();
				if (bet >= 0 && bet < w[numberP]) {
					w[numberP] -= bet;
					b[numberP][numberH] += bet;
				} else {
					System.out.println("Insuficient funds.");
				}
				betDone = true;
			} else {
				System.out.println("Must be a number.");
				sc.next();
			}
		}
	}

	private static int runRace(String[] h, int distance, int timeStep) {
		System.out.println("Starting race for distance " + distance + " using time step " + timeStep);
		double[] currPosition = new double[h.length];
		int t=0;
		double frontHorseTime = 1000.;
		boolean raceFinished = false;
		int frontHorse = 0;
		while (t<1000 && !raceFinished) {
			System.out.print("\nCurrent time " + (t + timeStep)
					+ ", time step used " + timeStep + "\n");
			for (int s = 0; s < distance + 32; s++) {
				System.out.print("-");
			}
			System.out.print("\n");
			for (int i = 0; i < h.length; i++) {
				double distanceStep = Math.random() * (2 * timeStep);
				currPosition[i] += distanceStep;	
				if (currPosition[i] >= distance) {
					double playerTime = t + timeStep - timeStep	* (currPosition[i] - distance) / distanceStep;
					currPosition[i] = distance;
					// The first player who reaches the finish line
					if (!raceFinished) {
						raceFinished = true;
						frontHorse = i;
						frontHorseTime = playerTime;
					} else {
						// if multiple players finish the race during the last step
						// timeStep, select the winner based on who has the shorter time.
						if (frontHorseTime > playerTime) {
							frontHorse = i;
							frontHorseTime = playerTime;
						}
					}
				}
				System.out.printf("%20s | %6.2f |", h[i], currPosition[i]);		
				for (int s=0; s<=distance; s++) {
					if (s == (int) currPosition[i])
						System.out.print(i);
					else
						System.out.print(" ");
				}

				System.out.print("\n");
				for (int s=0; s < distance + 32; s++) {
					System.out.print("-");
				}
				System.out.print("\n");
			}
			t += timeStep;
		}
		System.out.printf("\nRace winner: %s, covered distance: %d in time: %.2f\n", h[frontHorse], distance, frontHorseTime);
		return frontHorse;
	}
	
	private static boolean selectPlayOption(Scanner in) {
		boolean play = true;
		System.out.println("Do you want to race again ? Y/N");
		String str = in.nextLine();
		while (!"Y".equalsIgnoreCase(str) && !"N".equalsIgnoreCase(str)) {
				System.out.println("You have entered an invalid option. Try again.");
				str=in.nextLine();
		}
		if ("N".equals(str) || "n".equals(str)) play = false;
		return play;
	}
	
	private static int selectTimeStepOption(Scanner in) {
		int selection=-1;
		while (selection<1 || selection>100) {
			System.out.println("Please enter the time step used to display the race (1-100): ");
			if (in.hasNextInt()) {
				selection=in.nextInt();
				in.nextLine();
			} else {
				in.next();
			}
		}
		return selection;
	}

	public static void main(String[] args) {
		final int MAX_PLAYERS = 100;
		final int NUMBER_RACE_HORSES = 5;
		final int DISTANCE_RACE = 100;
		//update the path if changing the file locations. 
		final String HORSES_FILE = "C:\\Users\\sbeleuz\\workspace\\HorseRacing\\src\\horseData.dat"; 
		final String PLAYERS_FILE = "C:\\Users\\sbeleuz\\workspace\\HorseRacing\\src\\playerData.dat";

		Scanner in = new Scanner(System.in);
		
		String[] allHorses = loadAllHorses(HORSES_FILE);
		System.out.println("Horses loaded from file " + HORSES_FILE +" "+ allHorses.length);
		
		Integer[] wallets = new Integer[MAX_PLAYERS];
		
		String[] players = loadPlayersFromFile(PLAYERS_FILE, wallets);
		System.out.println("Players loaded from file " + PLAYERS_FILE + " " + players.length);

		boolean race = true;
		while (race) {
			String[] horses = selectRaceHorses(allHorses, NUMBER_RACE_HORSES);
			//Double array because you can bet on more than one horse.
			Integer[][] bets = new Integer[players.length][horses.length]; 
			for (int i = 0; i < players.length; i++) {
				for (int j = 0; j < horses.length; j++) { 
					bets[i][j] = 0;
				}
			}
			selectPlayerBet(horses, players, wallets, bets);
			int timeStep = selectTimeStepOption(in);
			int winH = runRace(horses, DISTANCE_RACE, timeStep);
			payPlayerBet(horses, players, wallets, bets, winH);
			race = selectPlayOption(in);
			if (!race) {
				savePlayersToFile(PLAYERS_FILE, players, wallets);
			}
		}
		in.close();
	}
}
