package biblioteka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {
	// Ovo je lista sa knjigama iz biblioteke, implementacija
	// ArrayList zbog brzine citanja
	private List<Knjiga> knjige = new ArrayList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new RuntimeException("Knjiga ne sme biti null");
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new RuntimeException("Knjiga ne sme biti null");
		
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if (autor == null && naslov == null && isbn == null	&& izdavac == null)
			return null;		
		
		List<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		for(Knjiga k: knjige)
			if (k.getNaslov().contains(naslov))
				rezultat.add(k);
		
		return rezultat;
	}

}
