package main;

public class Wolf extends Canoidae{
	public Wolf(){
		futter = new String[]{"Fleisch"};
	}
	@Override
	public String toString(){
		return "Wolf: " + id + " Futter: " + getFutter();
	}
}
