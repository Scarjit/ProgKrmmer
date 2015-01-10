package secint;

import java.util.List;

public class Spieler extends Spielfeld{
	protected static String Vorname;
	protected static String Nachname;
	protected static String Spitzname;
	protected static List<Item> Rucksack;
	protected static int X;
	protected static int Y;
	public String getVorname() {
		return Vorname;
	}
	public void setVorname(String vorname) {
		Vorname = vorname;
	}
	public String getNachname() {
		return Nachname;
	}
	public void setNachname(String nachname) {
		Nachname = nachname;
	}
	public String getSpitzname() {
		return Spitzname;
	}
	public void setSpitzname(String spitzname) {
		Spitzname = spitzname;
	}
	public static List<Item> getRucksack() {
		return Rucksack;
	}
	public static void setRucksack(List<Item> rucksack) {
		Rucksack = rucksack;
	}
	
	public static int getX() {
		return X;
	}
	public static void setX(int x) {
		X = x;
	}
	public static int getY() {
		return Y;
	}
	public static void setY(int y) {
		Y = y;
	}
	public void setPos(int x, int y){
		X = x;
		Y = y;
	}
	public static void bewegen(char direction){ // wasd steuerung
		if(direction=='W'){
			//Step 1: Spielgrenze verbieten
			//Step 2: Andere Spieler Verbieten
			if(getX()+1>Gr��e||Spielfeld[getX()+1][getY()].getSpieler() != null){
				System.out.println("Zug nicht erlaubt");
			}
			else{
				Spielfeld[getX()][getY()].getSpieler().setPos(getX()+1, getY());
				Spielfeld[getX()+1][getY()].setSpieler(Spielfeld[getX()][getY()].getSpieler());
				Spielfeld[getX()][getY()].setSpieler(null);
			}
		}
	}
}
