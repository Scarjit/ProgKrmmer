package �bung8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Gastst�tte.genGastst�tten().getFood();
		HashMap<String,List<Gastst�tte>> strassen = new HashMap<String,List<Gastst�tte>>();
		Scanner input = new Scanner(System.in);
		String strasse = "";
		while(!(strasse.equals("End"))){
				System.out.println("Strasse: ");
				strasse = input.nextLine();
			if(strassen.containsKey(strasse)){
				System.out.println("Strasse vorhanden");
			}
			else{
				Random zufall = new Random();
				List<Gastst�tte> tempEat = new ArrayList<Gastst�tte>();
				for(int i = 0;i<(zufall.nextInt(10)+1);i++){
					Gastst�tte x = Gastst�tte.genGastst�tten();
					System.out.println(x);
					tempEat.add(x);
				}
				strassen.put(strasse, tempEat);
			}
		}
		/*System.out.println(strassen.values().iterator());
		for(int i=0;i<strassen.size();i++){
			System.out.println("Strasse: " + strasse);
			System.out.println("");
		}*/
		System.out.println("Alle Essensm�glichkeiten:\n");
		for(String strasse1 : strassen.keySet()){
			System.out.println(strassen.get(strasse1));
		}
		System.out.println("Essen ohne Pizza:\n");
		for(String strasse2 : strassen.keySet()){
			System.out.println(strasse2);
			Iterator<Gastst�tte> eatit = strassen.get(strasse2).iterator();
			while(eatit.hasNext()){
				Gastst�tte ge = eatit.next();
				if(ge instanceof Pizzeria){
					eatit.remove();
				}
			}
		}
		for(String strasse1: strassen.keySet()){
			System.out.println(strasse1);
			Iterator<Gastst�tte> eatit2 = strassen.get(strasse1).iterator();
			while(eatit2.hasNext()){
				System.out.println(eatit2.next());
			}
		}
		
	}
	
	
	
}
