package fantasySpiel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main implements Gegenstände {

	public static void main(String[] args) {
		
		Spieler bla = new Spieler();
	

		List<Waffen> schmiede = new ArrayList<Waffen>();

		for (int i = 0; i < 4; i++) {

			Random zufall = new Random();
			int z = zufall.nextInt(10);

			switch (z) {
			case 0:
				schmiede.add(Stich);
				break;
			case 1:
				schmiede.add(Schlächter);
				break;
			case 2:
				schmiede.add(Kurzschwert);
				break;
			case 3:
				schmiede.add(Langschwert);
				break;
			case 4:
				schmiede.add(Excalibur);
				break;
			case 5:
				schmiede.add(Langbogen);
				break;
			case 6:
				schmiede.add(Jägerbogen);
				break;
			case 7:
				schmiede.add(EbenholzBogen);
				break;
			case 8:
				schmiede.add(Zielgenau);
				break;
			case 9:
				schmiede.add(ElbenBogen);
				break;
			}

		}
		System.out.println("Schmiede: ");
		for (int i = 0; i < schmiede.size(); i++) {
			System.out.println(i+1 + ". " + schmiede.get(i));
			}
		
		bla.addRucksack(schmiede.get(0));
		
		System.out.println(bla.getRucksack());
		
		schmiede.remove(0);
		

		List<Ringe> juwelier = new ArrayList<Ringe>();

		for (int i = 0; i < 2; i++) {

			Random zufall = new Random();
			int z = zufall.nextInt(4);

			switch (z) {
			case 0:
				juwelier.add(Ruhe);
				break;
			case 1:
				juwelier.add(Flüsterer);
				break;
			case 2:
				juwelier.add(Sturm);
				break;
			case 3:
				juwelier.add(Orkan);
				break;
			}
			
		}	
		
			System.out.println("\n Juwelier: ");
			for (int i = 0; i < juwelier.size(); i++) {
				System.out.println(i+1 + ". " + juwelier.get(i));
			}

		}
		
		

	}


