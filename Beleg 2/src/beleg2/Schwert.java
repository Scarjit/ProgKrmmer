package beleg2;

public class Schwert extends Waffen implements Schmiede{
	public Schwert(){
		preis = new String[] {"100"};
	}
	@Override
	public String toString(){
		return "Schwert: " + id + " kostet: " + getPreis();
	}
	@Override 
	public void kaufen() {
		System.out.println("Schwert: " + id + " wurde gekauft"); 
	}
	public String type(){
		return "Schwert";
	}
	public int id(){
		return id;
	}
}
