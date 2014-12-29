package anglerverein;

import java.util.Scanner;

import see.See;

public class Vorstand extends Angler{
	private static Vorstand vs = null;
	public static Vorstand getVorstand(){
		return(vs==null) ? vs = new Vorstand("Doktor","Zed") : vs;
	}
	private Vorstand(String vorname,String nachname){
		super(vorname,nachname);
	}
	public void redeHalten(){
		System.out.println("Ja, ich habe keine Lizenz,\n aber wenn du das nächste mal kurz vorm sterben bist,\n wirst du glücklich sein mich zu haben");
	}
	public void angeln(){
		Scanner input = new Scanner(System.in);
		if(fishcount>=4){
			System.out.println(VORNAME+" "+NACHNAME);
			System.out.print("Beitrag bezahlen?(j/n) > ");
			String eingabe = input.next();
			if(eingabe.charAt(0) =='j'){
				bezahlen(30);
				fishcount=0;
				System.out.println("Kassenstand: "+getKasse());
			}else{
				System.out.println("Er hat aufgegeben... Lappen.");
				return;
			}
		}
		System.out.print(VORNAME+" "+NACHNAME);
		if(See.catchFish(false)){
			fishcount++;
			System.out.print(" hat einen Fisch getötet\n");
		}else{
			System.out.print(" kann einfach nicht angeln\n");
		}
		/* static boolean catchFish(boolean test)
		 * test == true Es wird nur eine Ausschrift erzeugt
		 * test == false Es wird für 3 sec ein Bild des Fangs angezeigt
		 * Die Funktion liefert true, falls ein Wassertier gefangen wurde,
		 * false sonst
		 */
		
	}
}
