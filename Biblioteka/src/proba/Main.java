package proba;

import java.util.LinkedList;

import biblioteka.Autor;
import biblioteka.Biblioteka;
import biblioteka.Knjiga;

public class Main {

	public static void main(String[] args) {
		Autor a1 = new Autor("Zil", "Vern");
		Autor a2 = new Autor("Rik", "Jensi");
		
		LinkedList<Autor> autori1 = new LinkedList<>();
		autori1.add(a1);
		autori1.add(a2);

		Knjiga k1 = new Knjiga("Petnaestogodisnji kapetan", "123456789", autori1, "Urban Reads", 10);

		Autor a3 = new Autor("Dzon", "Grin");
		
		LinkedList<Autor> autori2 = new LinkedList<>();
		autori2.add(a3);

		Knjiga k2 = new Knjiga("Obilje Katarina", "987654213", autori2, "Laguna", 3);

		Biblioteka b = new Biblioteka();
		b.dodajKnjigu(k1);
		b.dodajKnjigu(k2);
	
		b.sacuvajSveKnjigeJSON("biblioteka.json");
	
		Biblioteka b2 = new Biblioteka();
		b2.ucitajSveKnjigeJSON("biblioteka.json");

		System.out.println("Broj knjiga: "+b2.vratiSveKnjige().size());
	
		for (Knjiga k : b2.vratiSveKnjige()) {
			System.out.println(k);
		}

	}

}
