package fantasySpiel;

public interface Gegenst�nde {
	
	Schwert Stich = new Schwert("Stich", 100);
	Schwert Schl�chter = new Schwert("Schl�chter", 250);
	Schwert Langschwert = new Schwert("Langschwert", 270);
	Schwert Kurzschwert = new Schwert("Kurzschwert", 150);
	Schwert Excalibur = new Schwert("Excalibur", 500); 
	
	Bogen Langbogen = new Bogen("Langbogen", 100);
	Bogen J�gerbogen = new Bogen("J�gerbogen", 150);
	Bogen EbenholzBogen = new Bogen("Ebenholzbogen" , 200);
	Bogen ElbenBogen = new Bogen("ElbenBogen", 300);
	Bogen Zielgenau = new Bogen("Zielgenau", 450);
	
	Goldring Ruhe = new Goldring("Ruhe", 50);
	Goldring Fl�sterer = new Goldring("Fl�sterer", 100);
	
	Silberring Sturm = new Silberring("Sturm", 50);
	Silberring Orkan = new Silberring("Orkan", 100);
	

	
	

}
