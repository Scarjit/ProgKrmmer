package fantasySpiel;



public class Ringe{

	

	public int Preis;
	public String Name;

	public int getPreis() {
		return Preis;
	}

	public void setPreis(int preis) {
		Preis = preis;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Ringe [Preis = " + Preis + ", Name = " + Name + "]";
	}

}
