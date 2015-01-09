package fantasySpiel;



public class Waffen implements Gegenstände{

	

	protected int Preis;
	protected String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPreis() {
		return Preis;
	}

	public void setPreis(int preis) {
		Preis = preis;
	}

	@Override
	public String toString() {
		return "Waffen [Preis = " + Preis + ", Name = " + Name + "]";
	}

}
