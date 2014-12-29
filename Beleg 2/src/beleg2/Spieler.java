package beleg2;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	public final String NAME;
	public int GELD;
	public int KAMPFST�RKE;
	public List<Equipment>  RUCKSACK = new ArrayList<Equipment>();
	public Spieler(String name, int geld, int kampfst�rke, List<Equipment> rucksack){
		this.NAME = name;
		this.GELD = geld;
		this.KAMPFST�RKE = kampfst�rke;
		this.RUCKSACK = rucksack;
	}
	public int getGELD() {
		return GELD;
	}
	public void setGELD(int geld) {
		GELD = geld;
	}
	public int getKAMPFST�RKE() {
		return KAMPFST�RKE;
	}
	public void setKAMPFST�RKE(int kampfst�rke) {
		KAMPFST�RKE = kampfst�rke;
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