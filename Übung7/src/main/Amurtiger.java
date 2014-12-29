package main;

public class Amurtiger extends Feloide {
	public Amurtiger() {
		futter = new String[] { "Fleisch" };
	}

	@Override
	public String toString() {
		return "Amurtiger: " + id + " Futter: " + getFutter();
	}
}
