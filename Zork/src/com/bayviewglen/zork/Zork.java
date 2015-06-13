package com.bayviewglen.zork;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Zork implements Serializable {
	final static String SAVED_GAME_FILE = "savegame.data"; 

	public static void main(String[] args) throws Exception {
		Game game = new Game();
		try {
			FileInputStream f_in = new FileInputStream(SAVED_GAME_FILE);

			// Read object using ObjectInputStream
			ObjectInputStream obj_in = new ObjectInputStream(f_in);

			// Read the game file if it is already saved. 
			game = (Game) obj_in.readObject();
		} catch (Exception ex) {
			game = new Game();
		}
		game.play();
	}
}