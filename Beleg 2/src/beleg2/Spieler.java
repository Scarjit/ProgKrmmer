package beleg2;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	public final String NAME;
	public int GELD;
	public int KAMPFSTÄRKE;
	public List<Equipment>  RUCKSACK = new ArrayList<Equipment>();
	public Spieler(String name, int geld, int kampfstärke, List<Equipment> rucksack){
		this.NAME = name;
		this.GELD = geld;
		this.KAMPFSTÄRKE = kampfstärke;
		this.RUCKSACK = rucksack;
	}
	public int getGELD() {
		return GELD;
	}
	public void setGELD(int geld) {
		GELD = geld;
	}
	public int getKAMPFSTÄRKE() {
		return KAMPFSTÄRKE;
	}
	public void setKAMPFSTÄRKE(int kampfstärke) {
		KAMPFSTÄRKE = kampfstärke;
	}
	public List<Equipment> getRUCKSACK() {
		return RUCKSACK;
	}
	public void addRUCKSACK(Equipment equip) {
		RUCKSACK.add(equip);
	}
	public void remRUCKSACK(int arg0) {
		RUCKSACK.remove(arg0);
	}
	public String getNAME() {
		return NAME;
	}
	public void iniRUCKSACK(){
		RUCKSACK = new ArrayList<Equipment>();
	}
	
	
}
