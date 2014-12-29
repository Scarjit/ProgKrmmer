package beleg2;

public class FluchderSchreibfeder extends Schriftrollen implements Buchhandlung{
	public FluchderSchreibfeder(){
		preis = new String[] {"100"};
		type = "Fluch der Schreibfeder";
	}
	@Override
	public String toString(){
		return "FluchderSchreibfeder: " + id + " kosten: " + getPreis();
	}
	@Override 
	public void kaufen() {
		System.out.println("Fluch der Schreibfeder: " + id + " wurde gekauft"); 
	}
	public String type(){
		return "Fluch der Schreibfeder";
	}
	public int id(){
		return id;
	}
}
