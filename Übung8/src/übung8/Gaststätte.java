package übung8;

import java.util.Random;

public abstract class Gaststätte implements Eatable{
	public static Gaststätte genGaststätten(){
			int ix=0;
			Random zufall = new Random();
			ix = zufall.nextInt(2);
			switch(ix){
				case 0:return new Pizzeria();
				case 1:return new Würstchenbude();
				case 2:return new Sushibar();
			}
			System.out.println("Fehler, Gaststättentyp ungültig generiert.");
			return null;
	}
}
