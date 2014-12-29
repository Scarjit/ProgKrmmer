package anglerverein;
import java.util.Scanner;

import see.See;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		See.fischeAussetzen(); // das darf nicht verändert werden
		Random randomGen = new Random();
		String Vornamen[]={"Olaf","Günther","Joergen","Odin","Thorin","Yolo"};
		String Nachnamen[]={"der Heilige","Sàînt Trôpéz","der mit dem Wolf tanzt","Swaggins","der Bärtige","Eichenschild"};
		Scanner reader = new Scanner(System.in);
		String ein = "";
		int n = 5;
		Angler[] verein = new Angler[n];
		verein[0] = Vorstand.getVorstand();
		for(int i = 1;i<n;i++){
			String vorname = Vornamen[randomGen.nextInt(6)];
			String nachname = Nachnamen[randomGen.nextInt(6)];
			verein[i]=new Angler(vorname,nachname);
		}
		do{
			verein[randomGen.nextInt(n)].angeln();
			System.out.print("Weiter?(j/n) ");
			ein = reader.next();
		} while (ein.equals("j"));
		reader.close();		
	}
}
