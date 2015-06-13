package com.bayviewglen.zork;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Zork implements Serializable {

	public static void main(String[] args) throws Exception {
		Game game = new Game();
		try {
			FileInputStream f_in = new FileInputStream("savegame.data");

			// Read object using ObjectInputStream
			ObjectInputStream obj_in = new ObjectInputStream(f_in);

			// Read an object
			game = (Game) obj_in.readObject();
		} catch (Exception ex) {
			game = new Game();
		}

	}
}