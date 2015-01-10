package secint;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Gib die Anzahl der Spieler ein:");
		GlobalVarStorage.setSint(reader.nextInt());
		Spielfeld.setVSpieler(GlobalVarStorage.getSint());
		System.out.println("Gib die Feldgr��e ein: (Mindestens " + (3+GlobalVarStorage.getSint()) + ")");
		Spielfeld.setGr��e(reader.nextInt());
		if(Spielfeld.getGr��e()<(3+GlobalVarStorage.getSint())){
			System.out.println("Spielfeldgr��e zu gering.");
			System.exit(1);
		}
		Spielfeld.genSpielfeld(Spielfeld.getGr��e());
		Spielfeld.graphOut();
		//TODO: Spieler d�rfen sich bewegen.
		//TODO: Spieler sammel Items ein
		Spieler.bewegen('W');
		Spielfeld.graphOut();
	}

}
