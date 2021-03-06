package beleg2;

public class Equipment {
	private static int idCount = 0;
	protected int id = idCount++;
	protected static String[] preis;
	public static Equipment genEquipment(String line){
		switch(line){
			case "Schwert": return new Schwert();
			case "Bogen": return new Bogen();
			case "SilberRing": return new SilberRing();
			case "GoldRing": return new GoldRing();
			case "Fluch_der_Schreibfeder": return new FluchderSchreibfeder();
			case "Augen_von_Hypnos": return new AugenvonHypnos();
			default:
				System.out.println("Unbekannter Gegenstand: " + line);
				return null;
		}
	}
	public static String getPreis(){
		String ret = "";
		for(String s:preis){
			ret += (s + "");
		}
		return ret;
	}
}
