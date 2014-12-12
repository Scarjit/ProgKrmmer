package main;

public class Mainecoon extends Feloide implements Haustier{
	public Mainecoon(){
		futter = new String[]{"Katzenfutter"};
	}
	@Override
	public String toString(){
		return "Maincoon: " + id + " Futter: " + getFutter();
	}
	@Override
	public void stroke() {
		System.out.println("Main-Coon gestreichelt");
	}
}
