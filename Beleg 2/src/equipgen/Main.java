package equipgen;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Main {

	
	public static void main(String[] args) throws Exception {
		File f = new File(".\\Data\\Equipment.txt");
		OutputStream ostream = new FileOutputStream(f);
		PrintWriter writer = new PrintWriter(ostream);
		Random zufall = new Random();
		Scanner reader = new Scanner(System.in);
		System.out.print("Anzahl > ");
		int anzahl = reader.nextInt();
		for(int i = 0; i < anzahl; i++){
			switch(zufall.nextInt(6)){
				case 0:
					writer.println("Schwert");
					break;
				case 1:
					writer.println("Bogen");					
					break;
				case 2:
					writer.println("SilberRing");					
					break;
				case 3:
					writer.println("GoldRing");					
					break;
				case 4:
					writer.println("Fluch_der_Schreibfeder");					
					break;
				case 5:
					writer.println("Augen_von_Hypnos");					
					break;
				default:
			}
		}
		reader.close();
		writer.close();
	}

}
