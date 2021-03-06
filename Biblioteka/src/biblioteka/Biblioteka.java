package biblioteka;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import biblioteka.interfejs.BibliotekaInterfejs;

/**
 * Klasa predstavlja biblioteku sa knjigama. Knjige se cuvaju u
 * listi. Klasa implementira interfejs BibliotekaInterfejs.
 * 
 * @author Bojan Tomic
 */
public class Biblioteka implements BibliotekaInterfejs {
	
	/**
	 * Lista sa knjigama iz biblioteke.
	 */
	private List<Knjiga> knjige = new ArrayList<Knjiga>();

	/**
	 * Dodaje novu knjigu u biblioteku. Knjiga se dodaje na kraj
	 * liste knjiga.
	 * 
	 * @param knjiga Nova knjiga koja se dodaje u biblioteku.
	 * 
	 * @throws java.lang.RuntimeException Ako je:
	 * <ul>
	 * 	<li> uneta knjiga null ili
	 *  <li> ako vec postoji ista knjiga u biblioteci
	 * </ul>
	 * 
	 * @see <a href = "http://ai.fon.bg.ac.rs/">AI SAJT</a>
	 */
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new RuntimeException("Knjiga ne sme biti null");
		
		if (knjige.contains(knjiga))
			throw new RuntimeException("Knjiga vec postoji u biblioteci");

		knjige.add(knjiga);
	}

	/**
	 * Brise knjigu iz liste biblioteke.
	 * 
	 * @param knjiga Knjiga koju je potrebno obrisati.
	 * 
	 * @throws java.lang.RuntimeException Ako je uneta knjiga null.
	 */
	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new RuntimeException("Knjiga ne sme biti null");
		
		knjige.remove(knjiga);
	}

	/**
	 * Vraca listu sa svim knjigama iz biblioteke.
	 * 
	 * @return Lista svih knjiga.
	 */
	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	/**
	 * Pretrazuje biblioteku po zadatim parametrima i vraca
	 * listu knjiga koje odgovaraju pretrazi. Ako se neki
	 * parametar izostavi (prosledi se null), pretrazivanje
	 * se vrsi po ostalim parametrima.
	 * 
	 * @param autor Autor knjige kao kriterijum
	 * @param isbn	ISBN knjige kao kriterijum
	 * @param naslov Naslov knjige kao kriterijum (moze
	 *  i samo deo naslova)
	 * @param izdavac Izdavac kao kriterijum
	 * 
	 * @return Lista knjiga koje odgovaraju kriterijumima ili null
	 * ako su svi kriterijumi pretrage uneto kao null.
	 */
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

	@Override
	public void sacuvajSveKnjigeJSON(String fajl) {
		try(FileWriter out = new FileWriter(fajl)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();		
			gson.toJson(knjige, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ucitajSveKnjigeJSON(String fajl) {
		try(FileReader in = new FileReader(fajl)) {
			Gson gson = new Gson();
			Type collectionType = new TypeToken<LinkedList<Knjiga>>(){}.getType();
			knjige.clear();
			knjige = gson.fromJson(in, collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
