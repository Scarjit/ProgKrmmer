package main;

public class Bernhardiner extends Canoidae implements Haustier{
	public Bernhardiner(){
		futter = new String[]{"Hundefutter","Cognac"};
	}
	@Override
	public String toString(){
		return "Bernhardiner: " + id + " Futter: " + getFutter();
	}
	@Override
	public void stroke() {
		System.out.println("Bernhardiner gestreichelt");
	}
}
