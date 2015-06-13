package com.bayviewglen.zork;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Zork implements Serializable {
	final static String SAVED_GAME_FILE = "savegame.data";

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		Game game = new Game(); // constructor for new game object

		System.out.println("Do you want to load a saved game ? Y/N");  //asks if they want to load a saved game or start a new game
		String str = in.nextLine();
		while (!"Y".equalsIgnoreCase(str) && !"N".equalsIgnoreCase(str)) {
			System.out
					.println("You have entered an invalid option. Try again."); //if the response is not y/n (not case sensitive)
			str = in.nextLine();
		}
		if ("Y".equals(str) || "y".equals(str)) { //checks response
			try { //tries to load a saved game from savegame.data if exists
				System.out.println("Loading game from: " + SAVED_GAME_FILE); //displays file from which game was loaded
				FileInputStream f_in = new FileInputStream(SAVED_GAME_FILE);

				// Read object using ObjectInputStream
				ObjectInputStream obj_in = new ObjectInputStream(f_in);

				// Read the game file if it is already saved.
				game = (Game) obj_in.readObject();
			} catch (Exception ex) {
				game = new Game();
			}
		}
		game.play(); // calling play function for the game
	}
}