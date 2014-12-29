package beleg2;

public class Bogen extends Waffen implements Schmiede{
	public Bogen(){
		preis = new String[] {"100"};
		type = "Bogen";
	}
	@Override
	public String toString(){
		return "Bogen: " + id + " kostet: " + getPreis();
	}
	@Override 
	public void kaufen() {
		System.out.println("Bogen: " + id + " wurde gekauft"); 
	}
	public String type(){
		return "Bogen";
	}
	public int id(){
		return id;
	}
}
