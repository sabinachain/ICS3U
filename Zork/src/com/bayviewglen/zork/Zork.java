package com.bayviewglen.zork;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Zork implements Serializable {
	final static String SAVED_GAME_FILE = "savegame.data";

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		System.out.println("Do you want to load a saved game ? Y/N");
		String str = in.nextLine();
		while (!"Y".equalsIgnoreCase(str) && !"N".equalsIgnoreCase(str)) {
			System.out
					.println("You have entered an invalid option. Try again.");
			str = in.nextLine();
		}
		if ("Y".equals(str) || "y".equals(str)) {
			try {
				System.out.println("Loading game from: " + SAVED_GAME_FILE);
				FileInputStream f_in = new FileInputStream(SAVED_GAME_FILE);

				// Read object using ObjectInputStream
				ObjectInputStream obj_in = new ObjectInputStream(f_in);

				// Read the game file if it is already saved.
				game = (Game) obj_in.readObject();
			} catch (Exception ex) {
				game = new Game();
			}
		}
		game.play();
	}
}