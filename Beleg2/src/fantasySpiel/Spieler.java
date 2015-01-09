package fantasySpiel;

import java.util.*;

public class Spieler {

	protected String Name;
	protected int kampfstärke;
	protected int gold = 1000;
	protected List<Gegenstände>rucksack = new ArrayList<Gegenstände>();
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getKampfstärke() {
		return kampfstärke;
	}
	public void setKampfstärke(int kampfstärke) {
		this.kampfstärke = kampfstärke;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public List<Gegenstände> getRucksack() {
		return rucksack;
	}
	public void setRucksack(List<Gegenstände> rucksack) {
		this.rucksack = rucksack;
	}
	
	public void addRucksack(Gegenstände g) {
		rucksack.add(g);
	}
	
	
	
	
}
