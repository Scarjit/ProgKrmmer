package �bung8;

import java.util.Random;

public abstract class Gastst�tte implements Eatable{
	public static Gastst�tte genGastst�tten(){
			int ix=0;
			Random zufall = new Random();
			ix = zufall.nextInt(2);
			switch(ix){
				case 0:return new Pizzeria();
				case 1:return new W�rstchenbude();
				case 2:return new Sushibar();
			}
			System.out.println("Fehler, Gastst�ttentyp ung�ltig generiert.");
			return null;
	}
}
