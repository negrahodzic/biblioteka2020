package biblioteka;

import java.util.LinkedList;

public class Knjiga {
	
	private String naslov;
	private String isbn;
	private LinkedList<Autor> autori;
	private String izdavac;
	private int izdanje;
	
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		if (naslov == null || naslov.isEmpty())
			throw new RuntimeException("Naslov ne sme biti null niti prazan String");
		
		this.naslov = naslov;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		if (isbn == null || (isbn.length()!= 8 && isbn.length()!= 13))
			throw new RuntimeException("ISBN ne sme biti null i mora biti duzine tacno 8 ili 13 znakova");
		
		this.isbn = isbn;
	}
	public LinkedList<Autor> getAutori() {
		return autori;
	}
	public void setAutori(LinkedList<Autor> autori) {
		if (autori == null || autori.isEmpty())
			throw new RuntimeException("Morate uneti listu sa autorima koja nije ni null ni prazna");
		
		this.autori = autori;
	}
	public String getIzdavac() {
		return izdavac;
	}
	public void setIzdavac(String izdavac) {
		if (izdavac == null || izdavac.isEmpty())
			throw new RuntimeException("Izdavac ne sme biti null niti prazan String");
		
		this.izdavac = izdavac;
	}
	public int getIzdanje() {
		return izdanje;
	}
	public void setIzdanje(int izdanje) {
		if (izdanje <=0 )
			throw new RuntimeException("Izdanje mora biti broj veci od nule");
		
		this.izdanje = izdanje;
	}
	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
				+ ", izdanje=" + izdanje + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	
	

}
