package anglerverein;
import see.See;
import java.util.Scanner;
public class Angler{
	public Angler(String vorname, String nachname){
		this.VORNAME=vorname;
		this.NACHNAME=nachname; 
	}
	protected static int kasse = 1000;
	public void printKasse(){
		System.out.println("Kassenstand = "+kasse);
	}
	public final String VORNAME;
	public final String NACHNAME;
	protected int fishcount=0;
	public void bezahlen(int betrag){
		kasse += betrag;
	}
	public int getKasse(){
		return kasse;
	}
	public void angeln(){
		Scanner input = new Scanner(System.in);
		if(fishcount>=2){
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
