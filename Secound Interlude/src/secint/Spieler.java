package secint;

import java.util.List;

public class Spieler extends Spielfeld{
	protected static String Vorname;
	protected static String Nachname;
	protected static String Spitzname;
	protected static List<Item> Rucksack;
	protected static int[][] Position;
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
	public static int[][] getPosition() {
		return Position;
	}
	public static void setPosition(int[][] position) {
		Position = position;
	}
	
}
