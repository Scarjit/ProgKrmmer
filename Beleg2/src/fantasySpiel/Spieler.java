package fantasySpiel;

import java.util.*;

public class Spieler {

	protected String Name;
	protected int kampfst�rke;
	protected int gold = 1000;
	protected List<Gegenst�nde>rucksack = new ArrayList<Gegenst�nde>();
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getKampfst�rke() {
		return kampfst�rke;
	}
	public void setKampfst�rke(int kampfst�rke) {
		this.kampfst�rke = kampfst�rke;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public List<Gegenst�nde> getRucksack() {
		return rucksack;
	}
	public void setRucksack(List<Gegenst�nde> rucksack) {
		this.rucksack = rucksack;
	}
	
	public void addRucksack(Gegenst�nde g) {
		rucksack.add(g);
	}
	
	
	
	
}
