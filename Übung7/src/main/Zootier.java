package main;

public class Zootier {
	private static int idCount = 1056;
	protected int id = idCount++;
	protected String[] futter;
	String p;
	public static Zootier genZootier(String line) {
		switch(line){
			case "Maine-Coon" : return new Mainecoon();
			case "Amurtiger" : return new Amurtiger();
			case "Wolf" : return new Wolf();
			case "Bernhardiner" : return new Bernhardiner();
			default:
					System.out.println("Unbekanntes Tier: " + line);
					return null;
		}
		}
	public String getFutter() {
		String ret = "";
		for (String s:futter){
			ret += (s + "");
		}
		return ret;}
}
