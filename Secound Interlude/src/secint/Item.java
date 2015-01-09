package secint;

import java.util.Random;

public class Item extends Spielfeld{
	public static Item genItem(){
		Random zufall = new Random();
		switch(zufall.nextInt(7)){
			case 0: return new GrosserHeiltrank();
			case 1: return new KleinerHeiltrank();
			case 2: return new GroßerManatrank();
			case 3: return new KleinerManatrank();
			case 4: return null;
			case 5: return null;
			case 6: return null;
			default: return null;
		}
	}
}
