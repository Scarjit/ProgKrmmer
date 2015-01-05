package beleg2;

public class GoldRing extends Ringe implements Juwelier{
	public GoldRing(){
		preis = new String[] {"100"};
	}
	@Override
	public String toString(){
		return "GoldRing: " + id + " kosten: " + getPreis();
	}
	@Override 
	public void kaufen() {
		System.out.println("Gold Ring: " + id + " wurde gekauft"); 
	}
	public String type(){
		return "Gold Ring";
	}
	public int id(){
		return id;
	}
}
